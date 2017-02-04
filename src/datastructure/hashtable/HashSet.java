package datastructure.hashtable;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * A hash set stores an unordered collection of objects, using
 * a hash table.
 */
public class HashSet extends AbstractSet {

    private Link[] buckets;
    private int size;


    /**
     * Constructs a hash table.
     *
     * @param bucketsLength the length of the buckets array
     */
    public HashSet(int bucketsLength) {
        buckets = new Link[bucketsLength];
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
     *         already in the set
     */
    public boolean add(Object x) {
        int h = x.hashCode();
        if (h < 0) h = -h;
        h = h % buckets.length;

        Link current = buckets[h];
        while (current != null) {
            if (current.data.equals(x))
                return false; // already in the set
            current = current.next;
        }
        Link newLink = new Link();
        newLink.data = x;
        newLink.next = buckets[h];
        buckets[h] = newLink;
        size++;
        return true;
    }

    /**
     * Removes an object from this set.
     *
     * @param x an object
     * @return true if x was removed from this set, false
     *         if x was not an element of this set
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
        private int bucket;
        private Link current;
        private int previousBucket;
        private Link previous;

        /**
         * Constructs a hash set iterator that points to the
         * first element of the hash set.
         */
        public HashSetIterator() {
            bucket = 0;
            previous = null;
            previousBucket = buckets.length;

            // set bucket to the index of the first nonempty bucket
            while (bucket < buckets.length && buckets[bucket] == null)
                bucket++;
            if (bucket < buckets.length) current = buckets[bucket];
            else current = null;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Object next() {
            Object r = current.data;

            if (current.next == null) // move to next bucket
            {
                previousBucket = bucket;
                bucket++;

                while (bucket < buckets.length && buckets[bucket] == null)
                    bucket++;
                if (bucket < buckets.length)
                    current = buckets[bucket];
                else
                    current = null;
            } else {  // move to next element in bucket
                previous = current;
                current = current.next;
            }

            return r;
        }

        public void remove() {
            if (previous != null){
                previous.next = previous.next.next;
            } else if (previousBucket < buckets.length) {
                buckets[previousBucket] = null;
            } else {
                throw new IllegalStateException();
            }
            previous = null;
            previousBucket = buckets.length;
        }


    }
}
