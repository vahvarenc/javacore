package datastructure.map;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
   This program tests a map that maps names to colors.
*/
public class MapTest
{
   public static void main(String[] args)
   {

      
      Map favoriteColors = new HashMap();
      favoriteColors.put("Juliet", Color.pink);
      favoriteColors.put("Romeo", Color.green);
      favoriteColors.put("Adam", Color.blue);
      favoriteColors.put("Eve", Color.pink);
      print(favoriteColors);
   }

   /**
      Prints the contents of a map
      @param m a map
   */
   private static void print(Map m)
   {
      Set keySet = m.keySet();
      Iterator iter = keySet.iterator();
      while (iter.hasNext())
      {
         Object key = iter.next();
         Object value = m.get(key);
         System.out.println(key + "->" + value);
      }
   }
}
