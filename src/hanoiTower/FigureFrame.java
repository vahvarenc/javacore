package hanoiTower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;

/**
 * Created by Vahag on 10/13/2016.
 */
public class FigureFrame extends JFrame{

    private FigureCanvas canvas = new FigureCanvas();
    JTextField textField = new JTextField(7);
    Graphics g;
    FigureFrame(){
        JPanel controlPanel = new JPanel();
        final Color color = black;

        JButton loadBtn = new JButton("Load");
        JButton startBtn = new JButton("Start");

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startActionPerformed();
            }
        });
        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadActionPerformed();
            }
        });

        controlPanel.add(startBtn);
        controlPanel.add(loadBtn);
        controlPanel.add(textField);
        add(controlPanel, BorderLayout.AFTER_LINE_ENDS);
        add(controlPanel, BorderLayout.BEFORE_FIRST_LINE);
        add(canvas, BorderLayout.CENTER);

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 1050, 700);
        setVisible(true);
    }

    public void startActionPerformed(){
        canvas.start();
    }

    public void loadActionPerformed(){
        canvas.reset();
        canvas.load(Integer.parseInt(textField.getText()));
        canvas.setNumberOfDisks(Integer.parseInt(textField.getText()));
    }

    public static void main(String[] args) {
        new FigureFrame();
    }
}
