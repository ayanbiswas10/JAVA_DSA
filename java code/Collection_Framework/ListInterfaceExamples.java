package Collection_Framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ListInterfaceExamples {
    static void ArrayListExamples(){
        ArrayList<Integer> li=new ArrayList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        System.out.println(li);
        System.out.println(li.get(1));
        li.set(1,10);
        System.out.println(li);
        System.out.println(li.contains(10));
    }

    static void LinkedListExamples(){
        LinkedList<Integer> li=new LinkedList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        System.out.println(li);
        System.out.println(li.get(1));
        li.set(1,10);
        System.out.println(li);
        System.out.println(li.contains(10));
    }

    static void StackExamples(){
        Stack<String> s=new Stack<>();
        s.push("ayan");
        s.push("biswas");
        System.out.println(s.peek());
        System.out.println(s);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s);
    }

    public static void main(String[] args) {
        ArrayListExamples();
        LinkedListExamples();
        StackExamples();
    }
}
