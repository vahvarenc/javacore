package datastructure.set;

import javax.swing.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This program demonstrates a set of strings. The user
 * can add and remove strings.
 */
public class SetTest {
    public static void main(String[] args) {
        Set names = new HashSet();
        boolean done = false;
        while (!done) {
            String input = JOptionPane.showInputDialog("Add name, Cancel when done");
            if (input == null)
                done = true;
            else {
                names.add(input);
                print(names);
            }
        }

        done = false;
        while (!done) {
            String input = JOptionPane.showInputDialog("Remove name, Cancel when done");
            if (input == null)
                done = true;
            else {
                names.remove(input);
                print(names);
            }
        }
        System.exit(0);
    }

    /**
     * Prints the contents of a set
     *
     * @param s a set
     */
    private static void print(Set s) {
        Iterator iter = s.iterator();
        System.out.print("{ ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" ");
        }
        System.out.println("}");
    }
}


