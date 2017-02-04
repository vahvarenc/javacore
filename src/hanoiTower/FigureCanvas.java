package hanoiTower;

import dynamicarray.DynamicArrayImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Vahag on 10/13/2016.
 */
class FigureCanvas extends JPanel {
    DynamicArrayImpl<Figure> figures = new DynamicArrayImpl<Figure>();
    Disk flyingDisk;

    private int numberOfDisks;
    private int mX;
    private int mY;
    private Pole pole1;
    private Pole pole2;
    private Pole pole3;

    private boolean isSelected;

    public Figure getPole1() {
        return pole1;
    }

    public void setNumberOfDisks(int numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
    }

    public void setNumberOfDisks(){

    }

    public Disk getFlyingDisk() {
        return flyingDisk;
    }

    public void setFlyingDisk(Disk flyingDisk) {
        this.flyingDisk = flyingDisk;
    }

    FigureCanvas(){
        pole1 = new Pole(150,350,150,200, Color.BLACK, this);
        pole2 = new Pole(450,350,150,200, Color.BLACK, this);
        pole3 = new Pole(750,350,150,200, Color.BLACK, this);
        add(pole1);
        add(pole2);
        add(pole3);


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
        if(flyingDisk != null) {
            flyingDisk.draw(g);
        }
    }

    public void load(int numberOfDisks){
        pole1.loadDisks(numberOfDisks);
        repaint();
    }

    static void moveDiscs (int n, Pole pole1, Pole pole2, Pole pole3) {
        if(n == 1) {
            pole1.moveTo(pole3);
        }
        else{
            moveDiscs(n - 1, pole1, pole3, pole2);
            pole1.moveTo(pole3);
            moveDiscs(n - 1, pole2, pole1, pole3);
        }
    }

    public void reset(){
        pole1.clearDisks();
        pole2.clearDisks();
        pole3.clearDisks();
        setFlyingDisk(null);
        repaint();
    }

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                moveDiscs(numberOfDisks, pole1, pole2, pole3);
            }
        }).start();
    }

//    public void pause(){
//        getSelected().pause();
//    }
//
//    public void stop(){
//        getSelected().stop();
//    }
//
//    public void resume(){
//        getSelected().resume();
//    }


}
