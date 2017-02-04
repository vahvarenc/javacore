package datastructure.uselist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

/**
   A program that demonstrates the LinkedList class
*/
public class ListTest
{  
   public static void main(String[] args)
   {  
      LinkedList staff = new LinkedList();
      staff.addLast("Dick");
      staff.addLast("Harry");
      staff.addLast("Romeo");
      staff.addLast("Tom");

       Collections.sort(staff);
      
      // | in the comments indicates the iterator position

      ListIterator iterator = staff.listIterator(); // |DHRT
      iterator.next(); // D|HRT
      iterator.next(); // DH|RT

      // add more elements after second element
      
      iterator.add("Juliet"); // DHJ|RT
      iterator.add("Nina"); // DHJN|RT

      iterator.next(); // DHJNR|T

      // remove last traversed element 

      iterator.remove(); // DHJN|T
     
      // print all elements

      iterator = staff.listIterator();
      while (iterator.hasNext())
         System.out.println(iterator.next());
   }
}
