package datastructure.impllist;

//import java.util.LinkedList;
//import java.util.ListIterator;


/**
   A program that demonstrates the LinkedList class
*/
public class ListTest
{  
   public static void main(String[] args) {
       LinkedList<Student> studentList
               = new LinkedListImple<Student>();

      LinkedList<StringBuffer> staff = new LinkedListImple<StringBuffer>();
      staff.addFirst(new StringBuffer("Dick"));
      staff.addFirst(new StringBuffer("Harry"));
      staff.addFirst(new StringBuffer("Romeo"));
      staff.addFirst(new StringBuffer("Tom"));

      
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

class Student implements Comparable<Student> {



   @Override
   public int compareTo(Student o) {
      return 0;
   }
}