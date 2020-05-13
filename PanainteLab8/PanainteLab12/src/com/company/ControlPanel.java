package com.company;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class ControlPanel extends JPanel{

    DesignPanel control;
    MainFrame frame;
    public ControlPanel(MainFrame frame)
    {

        super(Boolean.parseBoolean("My Frame"));
        this.frame=frame;
        Init();

    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == control) {
                try {
                    create();
                } catch (IOException e1) {
                    System.out.println(" ");
                }
            }
        }
    };
    private void Init()
    {
        //New frame creation
        JFrame f = new JFrame("New frame");
        JButton b;
        //New button with the specified name
        b = new JButton("Swing component");
        //Add button
        f.add(b);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setSize(600,600);
        b.setSize(225, 150);
        //New action
        control.button.addActionListener(actionListener);
    }

    private void create() throws IOException{
        control.addComponents();
    }

}
