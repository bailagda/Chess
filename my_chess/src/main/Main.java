package main;

import pieces.Knight;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.black);

        Board board = new Board();
        board.addPieces();

        frame.add(board);
        frame.setVisible(true);
    }
}