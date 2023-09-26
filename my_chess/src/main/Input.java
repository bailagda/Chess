package main;

import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {

    Board board;
    public Input(Board board) {
        this.board = board;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / board.titleSize;
        int row = e.getY() / board.titleSize;

        Piece pieceXY = board.getPiece(col, row);
        if(pieceXY != null) {
            board.selectedPiece = pieceXY;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / board.titleSize;
        int row = e.getY() / board.titleSize;

        if(board.selectedPiece != null) {
            Move move = new Move(this.board, board.selectedPiece, col, row);

            if(board.isValidMove(move)) {
                board.makeMove(move);
            } else {
                board.selectedPiece.xPos = board.selectedPiece.col * board.titleSize;
                board.selectedPiece.yPos = board.selectedPiece.row * board.titleSize;
            }
        }

        board.selectedPiece = null;
        board.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
            if(board.selectedPiece != null) {
                board.selectedPiece.xPos = e.getX() - board.titleSize / 2;
                board.selectedPiece.yPos = e.getY() - board.titleSize / 2;
            }

            board.repaint();
    }

}
