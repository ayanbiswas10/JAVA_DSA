package Collection_Framework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInterfaceExamples {
    public static void main(String[] args) {
//        Map<Integer, String> mp=new HashMap<>();   // Unordered, Unique, Hashing internally
//        Map<Integer, String> mp=new LinkedHashMap<>();   // Order of insertion, Unique, LinkedList+HashMap
        Map<Integer, String> mp=new TreeMap<>();     // Sorted Ordered, Unique, self-balancing BST, Red block tree
        mp.put(3,"Rupayan");
        mp.put(1,"Sayan");
        mp.put(2,"Ayan");
        mp.putIfAbsent(1,"None");
//        System.out.println(mp);
        System.out.println(mp.entrySet());
        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.get(2));
        System.out.println(mp.containsKey(4));
        System.out.println(mp.containsValue("Sayan"));

        //mapping over values
        for(var i: mp.values()){
            System.out.println(i);
        }

        //mapping over keys, values
        for(var i: mp.entrySet()){
            System.out.println(i);
        }
    }
}
