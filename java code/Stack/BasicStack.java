import java.util.Stack;

public class BasicStack {
    public static void main(String[] args) {
        Stack <Integer> st=new Stack<>();
        System.out.println(st);
        System.out.println("Size of the stack : "+st.size());
        //Push Operation
        st.push(1);
        st.push(3);
        st.push(5);
        st.push(7);
        st.push(9);
        System.out.println(st);
        System.out.println("Size of the stack : "+st.size());
        //Peek
        System.out.println(st.peek());
        //Pop
        st.pop();
        System.out.println(st.pop());
        System.out.println(st);
        System.out.println("Size of the stack : "+st.size());
    }
}
