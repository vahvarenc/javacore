package elementary;

/**
 * Created by Vahag on 9/16/2016.
 */
public class XOR {
    public static void main(String [] args){
       // int [] a = new int[n];
       // for (int i = 0; i < n; i++) {
        int [] a = {1,2,6,2,7,1,6};
        XOR.theOddNumber(a);
    }
    static void theOddNumber(int [] a){
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result ^= a[i];
        }
        System.out.println("The number that does not occur twice is " + result);
    }
}
