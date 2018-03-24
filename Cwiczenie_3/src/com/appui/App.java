package com.appui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class App {
    private JPanel panel1;
    private JButton button1;
    private JMenu jMenu;
    private JMenuItem menuItem;
    private JMenuBar menuBar;



    public static void main(String args[]){

        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar1= new JMenuBar();
        menuBar1.setVisible(true);
        JMenu menu = new JMenu("Program");
        JMenuItem menuItem=new JMenuItem("Zamknij");
        menu.add(menuItem);
        JLabel lebel1 = new JLabel("Label1");
        JButton button1 = new JButton("Button");
        frame.add(lebel1);
        frame.add(button1);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        App a = new App();
      // frame.setContentPane(a.panel1);
       Table table = new Table();
       table.setOpaque(true);
       frame.setContentPane(table);
        frame.setJMenuBar(menuBar1);
        frame.setMinimumSize(new Dimension(800,600));
        menuBar1.add(menu);
        frame.add(new Button("Usun"));
        frame.pack();
        frame.setVisible(true);


    }
}
