package figures;

import java.awt.*;

public class Oval extends Figure {

    public Oval(int x, int y, int width, int height, FigureCanvas canvas) {
        super(x, y, width, height, canvas);
    }

    /*public Oval(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color, color);
    }*/

    @Override
    public void draw(Graphics g) {
        g.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean isBelong(int x, int y) {
        return false;
    }

}
