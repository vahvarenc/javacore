package game;

import java.awt.*;

public class Oval extends Figure {

    public Oval(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public Oval(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        super(x, y, width, height, color, canvas);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(getX(), getY(), getWidth(), getHeight());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    boolean isBelong(int x, int y) {
        return  x > getX() &&  x < getX() + getWidth() && y > getY() && y < getHeight() + getY();
    }

}
