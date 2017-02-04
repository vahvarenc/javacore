package hanoiTower;

import dynamicarray.DynamicArray;
import dynamicarray.DynamicArrayImpl;


import java.awt.*;

/**
 * Created by Vahag on 11/29/2016.
 */
public class Pole extends Figure {
    private DynamicArray<Disk> disks = new DynamicArrayImpl<>();
    int dX = 0;
    int dY = 0;
    int size = disks.size();

    public int getSize() {
        return size;
    }

    public Pole(int x, int y, int width, int height, Color color, FigureCanvas canvas) {
        super(x, y, width, height, color, canvas);
    }

    public Pole(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY() + getHeight() - 10, getWidth(), 10);
        g.fillRect(getX(), getY() + getHeight() - 10, getWidth(), 10);
        g.drawRect(getX() + (getWidth() - 10) / 2, getY(), 10, getHeight());
        g.fillRect(getX() + (getWidth() - 10) / 2, getY(), 10, getHeight());
        for (int i = 0; i < disks.size(); i++) {
            disks.get(i).draw(g);
        }

    }

    public void loadDisks(int numberOfDisks) {
        FigureCanvas canvas = getCanvas();
        int dif = (getWidth() - 30) / (2 * numberOfDisks);
        while (disks.size() != 0) {
            clearDisks();
        }
        for (int i = 0; i < numberOfDisks; i++) {
            Disk disk = new Disk(getX() + (i + 1) * dif, getY() + getHeight() - 20 - 10 * i - 2 * i, getWidth() - 2 * (i + 1) * dif, 10, Color.BLUE, canvas, this);
            disks.add(disk);
        }
    }


    public void clearDisks() {
        for (int i = 0; i < disks.size(); i++) {
            disks.remove(i);
        }

    }

    public Disk getLastDisk() {
        return disks.get(disks.size() - 1);
    }

    public Disk getPenultimateDisk() {
        if (disks.size() > 1) {
            return disks.get(disks.size() - 2);
        }
        return null;
    }

    public void moveTo(Pole pole) {
        Disk movingDisk = getLastDisk();
        MovingStatus movingStatus = MovingStatus.GO_UP;
        while (movingStatus != MovingStatus.DONE) {
            switch (movingStatus) {
                case GO_UP:
                    if (movingDisk.getY() + movingDisk.getHeight() > getY() - 5) {
                        dX = 0;
                        dY = -2;
                    } else {
                        disks.remove(movingDisk);
                        getCanvas().setFlyingDisk(movingDisk);
                        movingStatus = MovingStatus.TO_DESTINATION;
                    }
                    break;
                case TO_DESTINATION:
                    int destX = pole.getX() + (pole.getWidth() - movingDisk.getWidth()) / 2;
                    int destY = pole.getY() - 5;
                    if (!movingDisk.isInBox(destX, destY, 3)) {
                        checkDirectionOnFlightMode(pole, movingDisk);
                    } else {
                        movingDisk.setX(destX);
                        movingDisk.setY(destY - 10);
                        pole.disks.add(movingDisk);
                        getCanvas().setFlyingDisk(null);
                        movingStatus = MovingStatus.GO_DOWN;
                        dX = 0;
                        dY = 0;
                    }
                    break;
                case GO_DOWN:
                    if (pole.getPenultimateDisk() == null) {
                        if (movingDisk.getY() + movingDisk.getHeight() < pole.getY() + pole.getHeight() - 10 - 2) {
                            dX = 0;
                            dY = 2;
                        } else {
                            movingDisk.setY(pole.getY() + pole.getHeight() - 22);
                            movingStatus = MovingStatus.DONE;
                        }
                    } else {
                        if (movingDisk.getY() + movingDisk.getHeight() < pole.getPenultimateDisk().getY() - 2) {
                            dX = 0;
                            dY = 2;
                        } else {
                            movingDisk.setY(pole.getPenultimateDisk().getY() - 14);
                            movingStatus = MovingStatus.DONE;
                        }
                    }
            }
            movingDisk.move(dX, dY);
            getCanvas().repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    enum MovingStatus {GO_UP, TO_DESTINATION, GO_DOWN, DONE}


    @Override
    public void move(int dX, int dY) {
        setX(getX() + dX);
        setY(getY() + dY);
        for (int i = 0; i < disks.size(); i++) {
            disks.get(i).setX(disks.get(i).getX() + dX);
            disks.get(i).setY(disks.get(i).getY() + dY);
        }
    }

    private void checkDirectionOnFlightMode(Pole destination, Disk currentDisk) {
        int diskX = currentDisk.getX();
        int diskY = currentDisk.getY() + currentDisk.getHeight();
        int destX = destination.getX() + (destination.getWidth() - currentDisk.getWidth()) / 2;
        int destY = destination.getY() - 5;
        if (diskX < destX) {
            dX = 2;
        } else {
            dX = -2;
        }
        if (diskY < destY) {
            dY = 1;
        } else {
            dY = -1;
        }
    }

    public void addDisk(Disk disk) {

    }

    @Override
    boolean isBelong(int x, int y) {
        return (x > getX() + (getWidth() - 10) / 2 && x < getX() + (getWidth() - 10) / 2 + 10 && y > getY() && y < getY() + getHeight()) || (x > getX() && x < getX() + getWidth() && y > getY() + getHeight() - 10 && y < getY() + getHeight());

    }
}
