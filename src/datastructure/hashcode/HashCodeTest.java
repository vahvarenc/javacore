package datastructure.hashcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
   A program to test hash codes of coins
*/
public class HashCodeTest {

   public static void main(String[] args)  {
      Dram dram1 = new Dram(0.25, "quarter");
      Dram dram2 = new Dram(0.25, "quarter");
      Dram dram3 = new Dram(0.05, "nickel");

      System.out.println("hash code of dram1="
         + dram1.hashCode());
      System.out.println("hash code of dram2="
         + dram2.hashCode());
      System.out.println("hash code of dram3="
         + dram3.hashCode());

      Set coins = new HashSet();
      coins.add(dram1);
      coins.add(dram2);
      coins.add(dram3);

      Iterator iter = coins.iterator();
      while (iter.hasNext())
         System.out.println(iter.next());
   }
}
