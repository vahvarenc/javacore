package datastructure.impllist;

import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of links with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedListImple<E> implements LinkedList<E> {
    private Link<E> first;

    /**
     * Constructs an empty linked list.
     */
    public LinkedListImple() {
        first = null;
    }

    /**
     * Returns the first element in the linked list.
     *
     * @return the first element in the linked list
     */
    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     *
     * @return the removed element
     */
    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        E obj = first.data;
        first = first.next;
        return obj;
    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param obj the object to add
     */
    public void addFirst(E obj) {
        Link<E> newLink = new Link<E>();
        newLink.data = obj;
        newLink.next = first;
        first = newLink;
    }

    /**
     * Returns an iterator for iterating through this list.
     *
     * @return an iterator for iterating through this list
     */
    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    private class Link<E> {
        public E data;
        public Link<E> next;
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Link<E> position;
        private Link<E> previous;

        /**
         * Constructs an iterator that points to the front
         * of the linked list.
         */
        public LinkedListIterator() {
        }

        /**
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = position; // remember for remove

            if (position == null){
                position =  first;
            }else{
                position = position.next;
            }

            return position.data;
        }

        /**
         * Tests if there is an element after the iterator
         * position.
         *
         * @return true if there is an element after the iterator
         *         position
         */
        public boolean hasNext() {
            if (position == null) {
                return first != null;
            } else {
                return position.next != null;
            }
        }

        /**
         * Adds an element before the iterator position
         * and moves the iterator past the inserted element.
         *
         * @param obj the object to add
         */
        public void add(E obj) {
            if (position == null) {
                addFirst(obj);
                position = first;
            } else {
                Link<E> newLink = new Link<E>();
                newLink.data = obj;
                newLink.next = position.next;
                position.next = newLink;
                position = newLink;
            }
            previous = null;
        }

        /**
         * Removes the last traversed element. This method may
         * only be called after a call to the next() method.
         */
        public void remove() {
            if (position == first) {
                removeFirst();
                position = first;
            } else {
                if (previous == null) {
                    throw new IllegalStateException();
                }

                previous.next = position.next;
                position = previous;
            }
            previous = null;
        }

        /**
         * Sets the last traversed element to a different
         * value.
         *
         * @param obj the object to set
         */
        public void set(E obj) {
            if (position == null){
                throw new NoSuchElementException();
            }
            position.data = obj;
        }
    }
}
