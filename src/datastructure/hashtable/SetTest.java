package datastructure.hashtable;

import java.util.Iterator;
import java.util.Set;

/**
   This program tests the hash set class.
*/
public class SetTest {
   public static void main(String[] args) {
      Set names = new HashSet(101); // 101 is a prime

      names.add("Sue");
      names.add("Harry");
      names.add("Nina");
      names.add("Susannah");
      names.add("Larry");
      names.add("Eve");
      names.add("Sarah");
      names.add("Adam");
      names.add("Tony");
      names.add("Katherine");
      names.add("Juliet");
      names.add("Romeo");
      names.remove("Romeo");
      names.remove("George");

      Iterator iterator = names.iterator();
      while (iterator.hasNext())
         System.out.println(iterator.next());
   }
}
