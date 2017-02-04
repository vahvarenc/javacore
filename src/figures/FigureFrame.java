package figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

import static java.awt.Color.black;

/**
 * Created by Vahag on 10/13/2016.
 */



public class FigureFrame extends JFrame{

    private FigureCanvas figureCanvas = new FigureCanvas();

    Graphics g;
    FigureFrame(){
        JPanel controlPanel = new JPanel();
        final JPanel inputPanel = new JPanel();
        Integer intWidth = 100;
        Integer intHeight = 100;
        Integer intX = 10;
        Integer intY = 10;

        final Color color = black;
        JButton chooseButton = new JButton("Choose Color");

        final JFormattedTextField widthField = new JFormattedTextField(7);
        widthField.setValue(new Integer(intWidth));
        widthField.setColumns(7);
        final JFormattedTextField heightField = new JFormattedTextField(7);
        heightField.setValue(new Integer(intHeight));
        heightField.setColumns(7);
        final JFormattedTextField xCoordField = new JFormattedTextField(7);
        xCoordField.setValue(new Integer(intX));
        xCoordField.setColumns(7);
        final JFormattedTextField yCoordField = new JFormattedTextField(7);
        yCoordField.setValue(new Integer(intY));
        yCoordField.setColumns(7);

        inputPanel.add(new JLabel("x-coordinate : "));
        inputPanel.add(xCoordField);
        inputPanel.add(new JLabel("y-coordinate : "));
        inputPanel.add(yCoordField);
        inputPanel.add(new JLabel("Width :"));
        inputPanel.add(widthField);
        inputPanel.add(new JLabel("Height : "));
        inputPanel.add(heightField);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a Color", figureCanvas.getForeground());
            }
        });
        inputPanel.add(chooseButton);

        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");
        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");
        JButton pauseBtn = new JButton("Pause");
        JButton resumeBtn = new JButton("Resume");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, inputPanel, "Rectangle dimensions : ", JOptionPane.OK_CANCEL_OPTION);

                //Oval oval = new Oval(10, 10, 200, 200);
                Rectangle rect = new Rectangle((Integer) xCoordField.getValue(), (Integer) yCoordField.getValue(), (Integer) widthField.getValue(), (Integer) heightField.getValue(), color,figureCanvas);
                //figureCanvas.add(oval);
                figureCanvas.add(rect);
            }
        });

        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figureCanvas.remove();
            }
        });

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startActionPerformed();
            }
        });

        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseActionPerformed();
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopActionPerformed();
            }
        });

        resumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resumeActionPerformed();
            }
        });

        controlPanel.add(addBtn);
        controlPanel.add(removeBtn);
        controlPanel.add(startBtn);
        controlPanel.add(stopBtn);
        controlPanel.add(pauseBtn);
        controlPanel.add(resumeBtn);
        add(controlPanel, BorderLayout.AFTER_LINE_ENDS);
        add(controlPanel, BorderLayout.BEFORE_FIRST_LINE);
        add(figureCanvas, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 500, 400);
        setVisible(true);
    }

    public void stopActionPerformed(){
        figureCanvas.stop();
    }

    public void pauseActionPerformed(){
        figureCanvas.pause();
    }

    public void startActionPerformed(){
        figureCanvas.start();
    }

    public void resumeActionPerformed(){
        figureCanvas.resume();
    }
}
