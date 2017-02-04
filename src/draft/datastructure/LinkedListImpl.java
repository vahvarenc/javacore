package draft.datastructure;

import java.util.NoSuchElementException;

/**
 * Created by Vahag on 1/23/2017.
 */
class LinkedListImpl<T> implements LinkedList<T> {
    private Link first;

    @Override
    public T getFirst() {
        if(first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    @Override
    public T removeFirst() {
        if(first == null)
            throw new NoSuchElementException();
        T removed = first.data;
        first = first.next;
        return removed;
    }

    @Override
    public void addFirst(T obj) {
        Link newLink = new Link();
        newLink.data =  obj;
        newLink.next = first;
        first = newLink;
    }

    @Override
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    private class Link{
        public T data;
        public Link next;
    }

    private class LinkedListIterator implements ListIterator<T> {
        private Link position;
        private Link previous;

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            previous = position;

            if(position == null)
                position = first;
            else
                position = position.next;

            return position.data;
        }

        @Override
        public boolean hasNext() {
            if(position == null)
                return first != null;
            else
                return position.next != null;
        }

        @Override
        public void add(T obj) {
            if(position == null){
                addFirst(obj);
                position = first;
            }else{
                Link newLink = new Link();
                newLink.data = obj;
                newLink.next = position.next;
                position.next = newLink;
                position = newLink;
            }
            previous = null;
        }

        @Override
        public void remove() {
            if(position == first) {
                removeFirst();
                position = first;
            }else{
                if(previous == null)
                    throw new IllegalStateException();
                previous.next = position.next;
                position = previous;
            }
            previous = null;
        }

        @Override
        public void set(T obj) {
            if(position == null)
                throw new NoSuchElementException();
            position.data = obj;
        }
    }
}
