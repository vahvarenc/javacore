package hanoiTower;

import java.awt.*;

abstract public class Figure implements Runnable{
    private int x;
    private int y;
    private int width;
    private int height;
    private static Color color;

    private Thread t;
    private boolean isRunning;
    private boolean isPaused;
    private int dX;
    private int dY;
    private FigureCanvas canvas;
    public static final Color DEFAULT_COLOR = Color.black;

    protected FigureCanvas getCanvas() {
        return canvas;
    }

    public Figure(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.canvas = canvas;
    }

    public Figure(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public static void setColor(Color c) {
        color = c;
    }

    public void move(int dX, int dY){
        x += dX;
        y += dY;
    }

    public void moveToThePoint(int x, int y){
        int slope = (y - this.y)/(x - this.x);
        move(1, slope);
    }

    public boolean isInBox(int x0, int y0, int r){
        if(getX() < x0 + r && getX() > x0 - r && getY() + getHeight() < y0 + r && getY() + getHeight() > y0 - r){
            return true;
        }
        return false;
    }

    public void run (){
        while(isRunning){
            if(isPaused){
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            checkBorders();
            move(dX, dY);
            canvas.repaint();
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void resume(){
        if (isPaused) {
            notify();
        }
        isPaused = false;
    }

    public void stop(){
        isRunning = false;
    }

    public void start0(){
        t = new Thread(this);
        dX = 2;
        dY = 2;
        isRunning = true;
        isPaused = false;
        t.start();
    }

    public void pause(){
        isPaused = true;
    }

    void checkLeft(){
        if(getX() <= 0){
            dX = -dX;
        }
    }

    void checkBottom(){
        if(getY() + getHeight() >= canvas.getHeight()){
            dY = -dY;
        }
    }

    void checkTop(){
        if(getY() <= 0){
            dY = -dY;
        }
    }

    void checkRight(){
        if(getX() + getWidth() >= canvas.getWidth()){
            dX = -dX;
        }
    }

    void checkBorders(){
        checkBottom();
        checkLeft();
        checkRight();
        checkTop();
    }

}





