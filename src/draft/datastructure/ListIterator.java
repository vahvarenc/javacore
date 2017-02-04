package draft.datastructure;

/**
 * Created by Vahag on 1/23/2017.
 */
interface ListIterator<T> {
    /**
     Moves the iterator past the next element.
     @return the traversed element
     */
    T next();

    /**
     Tests if there is an element after the iterator
     position.
     @return true if there is an element after the iterator
     position
     */
    boolean hasNext();

    /**
     Adds an element before the iterator position
     and moves the iterator past the inserted element.
     @param obj the object to add
     */
    void add(T obj);

    /**
     Removes the last traversed element. This method may
     only be called after a call to the next() method.
     */
    void remove();

    /**
     Sets the last traversed element to a different
     value.
     @param obj the object to set
     */
    void set(T obj);
}
