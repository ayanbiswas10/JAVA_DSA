package Collection_Framework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterfaceExamples {
    public static void main(String[] args) {
//        HashSet<Integer> st=new HashSet<>();  // Unordered, Unique, Hashing internally
//        LinkedHashSet<Integer> st=new LinkedHashSet<>();   // Order of insertion, Unique, LinkedList+Hashset
        TreeSet<Integer> st=new TreeSet<>();    // Sorted Ordered, Unique, self-balancing BST, Red block tree
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(48);
        st.add(20);
        st.add(10);
        System.out.println(st);
        st.add(1);
        st.add(1);
        st.add(2);
        System.out.println(st);
        st.remove(2);
        System.out.println(st.contains(2));
        System.out.println(st.size());
    }
}
