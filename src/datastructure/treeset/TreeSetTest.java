package datastructure.treeset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
   A program to test hash codes of coins
*/
public class TreeSetTest
{
   public static void main(String[] args)
   {
      Coin coin1 = new Coin(0.25, "quarter");
      Coin coin2 = new Coin(0.25, "quarter");
      Coin coin3 = new Coin(0.01, "penny");
      Coin coin4 = new Coin(0.05, "nickel");

      class CoinComparator implements Comparator
      {
         public int compare(Object firstObject, Object secondObject)
         {
            Coin first = (Coin)firstObject;
            Coin second = (Coin)secondObject;
            if (first.getValue() < second.getValue()) return -1;
            if (first.getValue() == second.getValue()) return 0;
            return 1;
         }
      }

      Comparator comp = new CoinComparator();
      Set coins = new TreeSet(comp);
      coins.add(coin1);
      coins.add(coin2);
      coins.add(coin3);
      coins.add(coin4);

      Iterator iter = coins.iterator();
      while (iter.hasNext())
         System.out.println(iter.next());
   }
}
