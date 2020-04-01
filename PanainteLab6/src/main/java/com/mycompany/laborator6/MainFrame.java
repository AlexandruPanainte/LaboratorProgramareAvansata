/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laborator6;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawPanel canvas;

    public MainFrame() {
        super("ImBoredAtHome");
        init();
    }
    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);


        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}