package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.black);

    Board board = new Board();
        frame.add(board);
        frame.setVisible(true);
    }
}