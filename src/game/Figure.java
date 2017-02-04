package game;

import javax.swing.*;
import java.awt.*;

abstract public class Figure implements Runnable{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private FigureCanvas canvas;

    private boolean isRunning = false;
    private Thread t;
    private int dX;
    private int dY;

    public Figure(int x, int y, int width, int height) {
       this(x, y, width, height, Color.BLUE);
    }

    public Figure(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.canvas = canvas;
    }

    public Figure(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    abstract public void draw(Graphics g);
    abstract boolean isBelong(int x, int y);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void move(int dX, int dY){
        x += dX;
        y += dY;
    }

    public void run(){
        while(isRunning){
            move(dX, dY);
            canvas.repaint();
            insureDirection();
            try{
                Thread.sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void start(){
        t = new Thread(this);
        dX = 3;
        dY = 3;
        isRunning = true;
        t.start();
    }

    void insureDirection() {
        checkRect();
        checkLeft();
        checkRight();
        checkTop();
       if(y + 30 > canvas.getHeight()){
            JOptionPane.showMessageDialog(new JFrame(), "Game Over!", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            FigureCanvas canvas1 = new FigureCanvas();
            canvas = canvas1;
            canvas.repaint();

            try {
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void checkRect(){
        if(x+15 > canvas.getRect().getX() && y + 30 > canvas.getRect().getY() && y + 30 < canvas.getRect().getY() + 3 && x + 15 < canvas.getRect().getX() + canvas.getRect().getWidth() ){
            dY = -dY;
        //}else if(y + 15 > 360 && y + 15 < 380 && (x + 30 > canvas.getRect().getX() || x  < canvas.getRect().getX() + canvas.getRect().getWidth()) ){
        //    dX = -dX;
        }

    }

    void checkLeft(){
        if(x < 0){
            dX = -dX;

        }
    }

    void checkBottom(){
        if(y + height >= canvas.getHeight()){
            dY = -dY;
        }
    }

    void checkRight(){
        if(x + width > canvas.getWidth()){
            dX = -dX;
        }
    }

    void checkTop(){
        if(y < 0){
            dY = -dY;
        }
    }

}





