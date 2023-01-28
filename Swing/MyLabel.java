package Swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel() {
        Border border = BorderFactory.createLineBorder(Color.green, 3);
        this.setText("Tsula, madloba blinebistvis");
        ImageIcon imageIcon = new ImageIcon("/home/apeiron/pictures/MiniJava.png");
        this.setIcon(imageIcon);
        this.setForeground(new Color(0x00ff12));
        this.setFont(new Font("MV Boli", Font.ITALIC, 20));
        this.setOpaque(true); // display background color
        // this.setHorizontalTextPosition(JLabel.CENTER);
        // this.setVerticalTextPosition(JLabel.TOP);
        // this.setVerticalTextPosition(JLabel.TOP);
        // this.setHorizontalTextPosition(JLabel.CENTER);
        // this.setBounds(0,0,250,250);
    }
}
