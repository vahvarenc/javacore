package datastructure.tree;

/**
   This program tests the binary search tree class.
*/
public class TreeTest
{ 
   public static void main(String[] args)
   {  
      Tree names = new Tree();
      names.insert("Romeo");
      names.insert("Juliet");
      names.insert("Tom");
      names.insert("Dick");
      names.insert("Harry");

      names.print();
   }
}

