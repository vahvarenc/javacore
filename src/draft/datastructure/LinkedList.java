package draft.datastructure;

/**
 * Created by Vahag on 1/23/2017.
 */
interface LinkedList<T> {

        /**
         Returns the first element in the linked list.
         @return the first element in the linked list
         */
        public T getFirst();

        /**
         Removes the first element in the linked list.
         @return the removed element
         */
        public T removeFirst();

        /**
         Adds an element to the front of the linked list.
         */
        public void addFirst(T obj);

        /**
         Returns an iterator for iterating through this list.
         @return an iterator for iterating through this list
         */
        public ListIterator listIterator();
}
