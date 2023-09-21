package main;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public int titleSize = 85;
    int cols = 8;
    int rows = 8;


    public Board() {
        this.setPreferredSize((new Dimension(cols*titleSize, rows*titleSize)));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; ++r)
            for(int c = 0; c < cols; ++c) {
                g2d.setColor((r+c) % 2 == 0 ? new Color(107, 86, 86) : new Color(51, 42, 42));
                g2d.fillRect(c*titleSize, r*titleSize, titleSize, titleSize);
            }
    }
}
