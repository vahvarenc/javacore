package bracechecker.util;


public class StackImpl<E> implements Stack<E> {
    static final int DEFAULT_SIZE = 16;

    private Object stck[];
    private int tos;

    public StackImpl() {
        this(DEFAULT_SIZE);
    }

    public StackImpl(int size) {
        stck = new Object[size];
        tos = -1;
    }

    public void push(E item) {
        if (tos == stck.length - 1) {
            ensureContent();
        }
        stck[++tos] = item;
    }

    public E pop() {
        if (tos < 0) {
            System.out.println("StackImpl underflow.");
            return null;
        }
        E res = (E)stck[tos];
        stck[tos] = null;
        tos--;
        return  res;
    }

    public void reset(){
        tos = -1;
    }

    private void ensureContent (){
        Object[] newContent = new Object[stck.length * 3/2  + 1];
        for (int i = 0; i < stck.length; i++) {
            newContent[i] = stck[i];
        }
        stck = newContent;
    }

}
