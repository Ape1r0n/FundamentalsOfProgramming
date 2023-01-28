package Swing;

import javax.swing.*;
import java.awt.Color;

public class MyFrame extends JFrame{
    JButton button;
    public MyFrame(){
        this.setTitle("Heaven's doooor!!!");
        this.setSize(1600,1000);
        this.setVisible(true);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon lukito = new ImageIcon("/home/apeiron/pictures/Eggplant.png");
        this.setIconImage(lukito.getImage());
        this.getContentPane().setBackground(new Color(191,38,158));

        button = new JButton();
        button.setBounds(200,100,100,50);
        button.addActionListener(e -> System.out.println("Not every pee time is a poo time"));
        button.setBackground(Color.CYAN);
        button.setFocusable(false);
        button.setText("ute papaute");
        //this.getContentPane().add(button);
    }
}
