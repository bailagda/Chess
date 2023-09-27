package main;

import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    public int titleSize = 85;
    int cols = 8;
    int rows = 8;

    ArrayList<Piece> pieceList = new ArrayList<>();

    public Piece selectedPiece;

    public Input input = new Input(this);

    public Board() {
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
        this.setPreferredSize((new Dimension(cols*titleSize, rows*titleSize)));
    }


    public Piece getPiece(int col, int row){
        for(Piece piece : pieceList) {
            if(piece.col == col && piece.row == row) {
                return piece;
            }
        }

        return null;
    }

    public boolean isValidMove(Move move) {
        if(sameTeam(move.piece, move.capture)) {
            return false;
        }
        if(!move.piece.isValidMovement(move.newCol, move.newRow)) {
            return false;
        }
        if(move.piece.moveCollidesWithPiece(move.newCol, move.newRow)) {
            return false;
        }
        return true;
    }

    public boolean sameTeam(Piece p1, Piece p2) {
        if(p1 == null || p2 == null) {
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }

    public void makeMove(Move move) {
        move.piece.col = move.newCol;
        move.piece.row = move.newRow;
        move.piece.xPos = move.newCol * titleSize;
        move.piece.yPos = move.newRow * titleSize;

        move.piece.itsFirstMove = false;
        capture(move);
    }

    public void capture(Move move) {
        pieceList.remove(move.capture);
    }
    public void addPieces() {

        pieceList.add(new King(this, 4, 0, false));
        pieceList.add(new Queen(this, 3, 0, false));
        pieceList.add(new Knight(this, 1, 0, false));
        pieceList.add(new Knight(this, 6, 0, false));
        pieceList.add(new Bishop(this, 2, 0, false));
        pieceList.add(new Bishop(this, 5, 0, false));
        pieceList.add(new Rook(this, 0, 0, false));
        pieceList.add(new Rook(this, 7, 0, false));

        pieceList.add(new King(this, 4, 7, true));
        pieceList.add(new Queen(this, 3, 7, true));
        pieceList.add(new Knight(this, 1, 7, true));
        pieceList.add(new Knight(this, 6, 7, true));
        pieceList.add(new Bishop(this, 2, 7, true));
        pieceList.add(new Bishop(this, 5, 7, true));
        pieceList.add(new Rook(this, 0, 7, true));
        pieceList.add(new Rook(this, 7, 7, true));


        pieceList.add(new Paw(this, 0, 1, false));
        pieceList.add(new Paw(this, 1, 1, false));
        pieceList.add(new Paw(this, 2, 1, false));
        pieceList.add(new Paw(this, 3, 1, false));
        pieceList.add(new Paw(this, 4, 1, false));
        pieceList.add(new Paw(this, 5, 1, false));
        pieceList.add(new Paw(this, 6, 1, false));
        pieceList.add(new Paw(this, 7, 1, false));

        pieceList.add(new Paw(this, 0, 6, true));
        pieceList.add(new Paw(this, 1, 6, true));
        pieceList.add(new Paw(this, 2, 6, true));
        pieceList.add(new Paw(this, 3, 6, true));
        pieceList.add(new Paw(this, 4, 6, true));
        pieceList.add(new Paw(this, 5, 6, true));
        pieceList.add(new Paw(this, 6, 6, true));
        pieceList.add(new Paw(this, 7, 6, true));

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // BOARD
        for(int r = 0; r < rows; ++r)
            for(int c = 0; c < cols; ++c) {
                g2d.setColor((r+c) % 2 == 0 ? new Color(227, 190, 151) : new Color(152, 98, 52));
                g2d.fillRect(c*titleSize, r*titleSize, titleSize, titleSize);
            }
        if(selectedPiece != null)
        for(int r = 0; r < rows; ++r)
            for(int c = 0; c < cols; ++c) {
                if (isValidMove(new Move(this, selectedPiece, c, r))) {
                    g2d.setColor(new Color(37, 255, 0, 124));
                    g2d.fillRect(c * titleSize, r * titleSize, titleSize, titleSize );
                }
            }

        //PIECES
        for (Piece piece : pieceList) {
            piece.paint(g2d);
        }
    }


}
