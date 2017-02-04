/**
 * Created by Vahag on 9/7/2016.
 */
public class Rectangle {
    private double length;
    private double width;

    void setDim(double l, double w) {
        width = w;
        length = l;
    }

    double Perimeter() {
        return 2 * (width + length);
    }

    double Area() {
        return width * length;
    }
}



