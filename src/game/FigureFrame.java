package game;

import figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vahag on 10/13/2016.
 */
public class FigureFrame extends JFrame{
    FigureCanvas figureCanvas = new FigureCanvas();
    Graphics g;
    JPanel inputPanel = new JPanel();
    Figure figure;


    FigureFrame(){


        JPanel controlPanel = new JPanel();

        JButton startBtn = new JButton("Start");

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startActionPerformed();
            }
        });


        controlPanel.add(startBtn);
        add(controlPanel, BorderLayout.AFTER_LINE_ENDS);
        add(controlPanel, BorderLayout.BEFORE_FIRST_LINE);
        add(figureCanvas, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 100, 800, 500);
        setVisible(true);
    }



    public void startActionPerformed(){
        figureCanvas.start();
    }

}
