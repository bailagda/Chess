package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Paw extends Piece {
    public Paw(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;

        this.xPos = col * board.titleSize;
        this.yPos = row * board.titleSize;

        this.name = "Paw";
        this.sprite = sheet.getSubimage(5 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale)
                .getScaledInstance(board.titleSize, board.titleSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {
        if(itsFirstMove) {
            return (col == this.col && (1 == Math.abs(this.row - row) || 2 == Math.abs(this.row - row)));
        } else
            return isWhite ? col == this.col && (1 == (this.row - row)) : col == this.col && (-1 == (this.row - row));
    }
}
