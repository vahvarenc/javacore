package hanoiTower;

import java.awt.*;

public class Oval extends Figure {

    public Oval(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /*public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color, color);
    }*/

    @Override
    public void draw(Graphics g) {
        g.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    boolean isBelong(int x, int y) {
        return false;
    }

}
