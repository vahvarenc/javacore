package datastructure;

import java.util.*;

/**
 * Created by karenvardanyan on 5/21/16.
 */
public class CollectionDemo {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bb");
        list.add("c");
        list.add("d");
        list.add("E");
        String [] s0 = new String[10];
        String [] s = list.toArray(s0);
        System.out.println(s.length);
        System.out.println(s.hashCode());
        System.out.println(s0.hashCode());

        Set<List<String>> initialSet = new HashSet<>();
        initialSet.add(list);

        Set<List<String>> set = new HashSet<>(initialSet);

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
       // Collection<Integer> grades = new LinkedList<>();
        Iterator iterator =  list.iterator();

        while (iterator.hasNext()){
            list.remove(1);
            iterator = list.iterator();
            String a =  (String)iterator.next();

//            if(a == 1){
//                a=2;
//            }
        }

//        for (Object current : list) {
//            if((Integer)current == 1){
//                current = 2;
//            }
//        }


    }

    static <T>  T[] doSomething (T[] t){
        return (T[])new Integer[12];
    }
}
