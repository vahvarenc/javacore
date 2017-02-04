package game;

import java.awt.*;

public class Rectangle extends Figure {

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public Rectangle(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        super(x, y, width, height, color, canvas);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect (getX(), getY(), getWidth(), getHeight());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
        //g.fillRect(x, y, width, hight);
    }


    boolean isBelong(int x, int y) {
        return  x > getX() &&  x < getX() + getWidth() && y > getY() && y < getHeight() + getY();
    }

}