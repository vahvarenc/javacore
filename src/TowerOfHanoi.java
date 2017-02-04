import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Vahag on 9/19/2016.
 */
public class TowerOfHanoi {
    static void MoveDiscs (int n,int a, int b, int c) {
        if(n == 1) {
            System.out.println("Move disc from " + a + " to " + c);
        }
        else{
            MoveDiscs(n - 1, a, c, b);
            System.out.println("Move disc from " + a + " to " + c);
            MoveDiscs(n - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        int a=1, b=2, c=3, n=5;
        TowerOfHanoi.MoveDiscs(n,a,b,c);
    }
}
