import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> st=new HashSet<>();
        st.add("James");
        st.add("Lockus");
        st.add("James");
        System.out.println(st);
        System.out.println(st.contains("James"));
        System.out.println(st.size());
        st.remove("James");
        System.out.println(st);
        System.out.println(st.size());
        st.add("Marcos");
        for (var i:st){
            System.out.println(i);
        }
    }
}
