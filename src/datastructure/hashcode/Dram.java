package datastructure.hashcode;

/**
   A coin with a monetary value.
*/
public class Dram {

   private double value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin.
      @param aName the name of the coin
   */
   public Dram(double aValue, String aName) {
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() {
      return name;
   }

   public boolean equals(Object otherObject) {
      if (otherObject == null) return false;
      if (getClass() != otherObject.getClass()) return false;
      Dram other = (Dram)otherObject;
      return value == other.value && name.equals(other.name);
   }

   public int hashCode() {
      int h1 = name.hashCode();
      int h2 = new Double(value).hashCode();
      final int HASH_MULTIPLIER = 29;
      int h = HASH_MULTIPLIER * h1 + h2;
      return h;
   }

   public String toString() {
      return "Dram[value=" + value + ",name=" + name + "]";
   }

}
