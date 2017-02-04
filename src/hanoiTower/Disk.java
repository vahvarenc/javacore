package hanoiTower;


import java.awt.*;

/**
 * Created by Vahag on 12/1/2016.
 */
public class Disk extends Figure{
    Pole pole;

    public Disk(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        super(x, y, width, height, color, canvas);
    }




    public Disk(int x, int y, int width, int height, Color color, FigureCanvas canvas, Pole pole) {
        super(x, y, width, height, color, canvas);
        this.pole = pole;
    }



    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect (getX(), getY(), getWidth(), getHeight());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean isBelong(int x, int y) {
        return false;
    }
}
