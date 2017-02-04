package draft.util;

/**
 * Created by Vahag on 10/1/2016.
 */
public class StackImpl<E> implements Stack<E> {
    private Object [] stck;
    private int tos;
    static final int DEFAULT_SIZE = 16;


    public StackImpl(){
        tos = DEFAULT_SIZE;
    }

    public StackImpl(int size){
        stck = new Object[size];
        tos = -1;
    }

    public void push(E item) {
        if(tos == stck.length-1){
            ensureContent();
        }
        stck[tos++] = item;
    }


    public E pop() {
        if(tos == -1){
            System.out.println("Stack underflow");
            return null;
        }
        E res = (E) stck[tos];
        stck[tos] = null;
        tos--;
        return res;
    }

    void ensureContent(){
        Object newContent[] = new Object [stck.length*3/2+1];
        for (int i = 0; i < stck.length-1; i++) {
            newContent[i] = stck[i];
        }
        stck= newContent;
    }


    public void reset() {
        tos = -1;
    }
}
