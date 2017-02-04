package figures;

import java.awt.*;

public class Rectangle extends Figure {

    /*public Rectangle(int x, int y, int width, int height, FigureCanvas canvas) {
        super(x, y, width, height, canvas);
    }*/

    public Rectangle(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        super(x, y, width, height, color, canvas);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect (getX(), getY(), getWidth(), getHeight());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }


    public boolean isBelong(int x, int y) {
        return  x > getX() &&  x < getX() + getWidth() && y > getY() && y < getHeight() + getY();
    }

}