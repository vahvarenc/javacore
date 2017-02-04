public class RecDemo {
    public static void main(String args[]) {
        Rectangle rec1 = new Rectangle();
        Rectangle rec2 = new Rectangle();

        rec1.setDim(3, 4);
        rec2.setDim(4, 5);
        double Per = rec1.Perimeter();
        System.out.println("Perimeter is " + Per);
        System.out.println("Perimeter is " + rec2.Perimeter());
        System.out.println("Area is " + rec1.Area());
        System.out.println("Area is " + rec2.Area());
    }

}
