package datastructure.newhashtable;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A hash set stores an unordered collection of objects, using
 * a hash table.
 */
public class HashSet<E> extends AbstractSet<E> {

    private Link[] buckets;
    private int size;

    /**
     * Constructs a hash table.
     *
     * @param bucketsLength the length of the buckets array
     */
    public HashSet(int bucketsLength) {

        buckets = (HashSet<E>.Link[]) new HashSet.Link[bucketsLength];
        size = 0;
    }

    /**
     * Tests for set membership.
     *
     * @param x an object
     * @return true if x is an element of this set
     */
    public boolean contains(Object x) {
        int h = x.hashCode();

        if (h < 0) h = -h;
        h = h % buckets.length;

        Link current = buckets[h];
        while (current != null) {
            if (current.data.equals(x)) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * Adds an element to this set.
     *
     * @param x an object
     * @return true if x is a new object, false if x was
     * already in the set
     */
    public boolean add(E x) {
        int h = x.hashCode();
        if (h < 0) h = -h;
        int r = h % buckets.length;

        Link current = buckets[r];
        //TODO: add isExistInRow();
        while (current != null) {
            if (current.data.equals(x))
                return false; // already in the set
            current = current.next;
        }
        Link newLink = new Link();
        newLink.data = x;
        newLink.next = buckets[r];
        buckets[r] = newLink;
        size++;
        return true;
    }

    /**
     * Removes an object from this set.
     *
     * @param x an object
     * @return true if x was removed from this set, false
     * if x was not an element of this set
     */
    public boolean remove(Object x) {
        int h = x.hashCode();
        if (h < 0) h = -h;
        h = h % buckets.length;

        Link current = buckets[h];
        Link previous = null;
        while (current != null) {
            if (current.data.equals(x)) {
                if (previous == null) buckets[h] = current.next;
                else previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    /**
     * Returns an iterator that traverses the elements of this set.
     *
     * @return a hash set iterator
     */
    public Iterator iterator() {
        return new HashSetIterator();
    }

    /**
     * Gets the number of elements in this set.
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    private class Link {
        public Object data;
        public Link next;
    }

    private class HashSetIterator implements Iterator {
        private int currentIndex;
        private Link current;
        private Link next;
        private int previousIndex;
        private Link previous;


        private void findNext(){
            while (currentIndex < buckets.length && buckets[currentIndex] == null) {
                currentIndex++;
            }
            if (currentIndex < buckets.length) next = buckets[currentIndex];
            else next = null;
        }

        /**
         * Constructs a hash set iterator that points to the
         * first element of the hash set.
         */
        public HashSetIterator() {
            currentIndex = 0;
            previous = null;
            current = null;

            previousIndex = buckets.length;
            // set currentIndex to the index of the first nonempty currentIndex
            findNext();
        }

        public boolean hasNext() {
            findNext();
            return next != null;
        }

        public E next() {
            if(next == null){
                throw new NoSuchElementException();
            }

            E r = (E) next.data;
            if (next.next == null) { // move to next currentIndex
                previousIndex = currentIndex;
                currentIndex++;

                previous = current;
                current = next;
                findNext();
            } else {  // move to next element in currentIndex
                if (current != null) {
                    previous = current;


                }
                current = next;
                next = next.next;
            }

            return r;
        }

        private void skipNullRows() {
            while (currentIndex < buckets.length && buckets[currentIndex] == null) {
                currentIndex++;
            }
        }

        public void remove() {
            if (current != null) {
                if (previous == null) {
                    buckets[next == null ? previousIndex : currentIndex] = next;
                } else {
                    previous.next = current.next == null ? null: next;
                }
            } else if (previousIndex < buckets.length) {
                buckets[previousIndex] = null;
            } else {
                throw new IllegalStateException();
            }
            size--;
            current = null;
            previousIndex = buckets.length;
        }
    }
}
