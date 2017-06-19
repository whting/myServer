package collection;

import java.util.*;

public class Colletion_demo {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.size());

        System.out.println("-------------------------");
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList.size());

        System.out.println("-------------------------");
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        System.out.println(vector.size());

        System.out.println("-------------------------");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 10; i++) {
            hashSet.add(i);
        }
        System.out.println(hashSet.size());

        System.out.println("-------------------------");
        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < 10; i++) {
            treeSet.add(i);
        }
        System.out.println(treeSet.size());
    }
}

/**
 * arrayList = {ArrayList@466} "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"
 * elementData = {Object[10]@469}
 * size = 10
 * modCount = 10
 * <p>
 * linkedList = {LinkedList@470} "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"
 * size = 10
 * first = {LinkedList$Node@475}
 * item = {Integer@483} 0
 * next = {LinkedList$Node@494}
 * prev = null
 * last = {LinkedList$Node@476}
 * item = {Integer@492} 9
 * next = null
 * prev = {LinkedList$Node@493}
 * modCount = 10
 * <p>
 * vector = {Vector@477} "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"
 * elementData = {Object[10]@482}
 * elementCount = 10
 * capacityIncrement = 0
 * modCount = 10
 */