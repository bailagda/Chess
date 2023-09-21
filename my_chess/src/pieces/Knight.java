package pieces;

import main.Board;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Knight extends Piece {
    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;

        this.xPos = col * board.titleSize;
        this.yPos = row * board.titleSize;

        this.name = "Knight";
        this.sprite = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(sheetScale, sheetScale, BufferedImage.SCALE_SMOOTH);
    }
}
