package elementary;

/**
 * Created by Vahag on 9/16/2016.
 */
public class UsingShift {
    public static void main(String[] args) {
        int a=7489;
        UsingShift.detachIntByBytes(a);
    }

    static void detachIntByBytes(int a){
        byte b;
        for (int i = 0; i < 4; i++) {
            b = (byte) (a);
            a = a >> 8;
            System.out.println(b);
        }
    }
}
