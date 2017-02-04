package dynamicarray;

/**
 * Created by Vahag on 10/6/2016.
 */
public class DynamicArrayImpl<E> implements DynamicArray<E> {

    private E[] array;
    private int size;

    public DynamicArrayImpl() {
        array = (E[]) new Object[16];
        size = 0;
    }

    public <E> E[] getArray(){
        return (E[])array;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    /**
     * Returns <tt>true</tt> if this DynamicArray contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this DynamicArray contains
     * at least one element <tt>e</tt> such that
     * o==null ? get(i)==null : o.equals( get(i) ).
     *
     * @param o element whose presence in this DynamicArray is to be tested
     * @return <tt>true</tt> if this DynamicArray contains the specified element
     */
    public boolean contains(E o) {
        return indexOf(o) > -1;
    }

    /**
     * Returns the index of the I occurrence of the specified element
     * in this DynamicArray, or -1 if this DynamicArray does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * o==null ? get(i)==null : o.equals( get(i) )
     * or -1 if there is no such index.
     */
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this DynamicArray, or -1 if this DynamicArray does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * o==null ? get(i)==null : o.equals( get(i) )
     * or -1 if there is no such index.
     */
    public int lastIndexOf(E o) {
        if (contains(o))
            for (int i = size; i > -1; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        return -1;
    }

    /**
     * Returns the element at the specified position in this DynamicArray.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this DynamicArray
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < size) {
            return array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Replaces the element at the specified position in this DynamicArray with
     * the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException
     */
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E tmp = array[index];
        array[index] = element;
        return tmp;


    }

    /**
     * Appends the specified element to the end of this DynamicArray.
     *
     * @param e element to be appended to this DynamicArray
     * @return <tt>true</tt>
     */
    public boolean add(E e) {
        E newArray[] = (E[]) new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        array[size] = e;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * DynamicArray. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, E element) {
        //   throw new IndexOutOfBoundsException();


        if (index < size) {
            E newArray[] = (E[]) new Object[size + 1];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            for (int i = index + 1; i < size; i++) {
                newArray[i] = array[i];
            }
            array[index] = element;
            array = newArray;
        }

    }


    /**
     * Removes the element at the specified position in this DynamicArray.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the DynamicArray
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        E tmp = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return tmp;
    }

    /**
     * Removes the I occurrence of the specified element from this DynamicArray,
     * if it is present.  If the DynamicArray does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * <tt>i</tt> such that
     * <tt>(o==null? get(i)==null : o.equals( get(i) ) )</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this DynamicArray
     * contained the specified element (or equivalently, if this DynamicArray
     * changed as I result of the call).
     *
     * @param o element to be removed from this DynamicArray, if present
     * @return <tt>true</tt> if this DynamicArray contained the specified element
     */

    public boolean remove(E o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
            return true;
        }
        return false;
    }
}


