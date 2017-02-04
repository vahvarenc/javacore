package figures;

import dynamicarray.DynamicArrayImpl;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Vahag on 10/13/2016.
 */
class FigureCanvas extends JPanel {
    DynamicArrayImpl<Figure> figures = new DynamicArrayImpl<Figure>();

    private int mX;
    private int mY;

    private boolean isSelected;

    FigureCanvas(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressPerformed(e);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseDragPerformed(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

    }

    public Figure getSelected(){
        return isSelected ? figures.get(figures.size() - 1) : null;
    }

    private void select(int x, int y) {
        int size = figures.size();
        for (int i = size-1; i >= 0; i--) {
            if(figures.get(i).isBelong(x, y)){
                isSelected  = true;
                figures.add(figures.remove(i));
                return;
            }
        }
        isSelected = false;
    }

    private void mousePressPerformed(MouseEvent e){
        select(e.getX(), e.getY());
        if(isSelected){
            repaint();
        }
        mX = e.getX();
        mY = e.getY();
    }

    private void mouseDragPerformed(MouseEvent e) {
        if (isSelected) {
            getSelected().move(e.getX() - mX, e.getY() - mY);
            repaint();
        }
        mX = e.getX();
        mY = e.getY();
    }

    public void add(Figure fig){
        figures.add(fig);
        repaint();
    }

    public void remove(){
        try{figures.remove(figures.size()-1);}
        catch(Exception e){
            System.out.println("IndexOutOfBoundsException");
        }
        repaint();
    }


    public void paint(Graphics g) {
        g.clearRect(0,0,4000, 4000);
        for (int i = 0; i < figures.size(); i++) {
            figures.get(i).draw(g);
        }
    }

    public void start(){
        getSelected().start0();
    }

    public void pause(){
        getSelected().pause();
    }

    public void stop(){
        getSelected().stop();
    }

    public void resume(){
        getSelected().resume();
    }

    public static void main(String[] args) {
        new FigureFrame();
    }
}
