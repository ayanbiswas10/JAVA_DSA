import java.util.Stack;

public class reverseStack {
    public static void pushAtBottomRec(Stack<Integer> st,int x){
        if(st.size()==0) {
            st.push(x);
            return;
        }
        int top=st.pop();
        pushAtBottomRec(st,x);
        st.push(top);
    }
    public static void reverseRec(Stack<Integer> st){
        if(st.size()==0) return;
        int top=st.pop();
        reverseRec(st);
        pushAtBottomRec(st,top);
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        reverseRec(st);
        System.out.println(st);
//        Stack<Integer> rt=new Stack<>();
//        while (st.size()>0){
//            rt.push(st.pop());
//        }
//        Stack<Integer> tt=new Stack<>();
//        while (rt.size()>0){
//            tt.push(rt.pop());
//        }
//        while (tt.size()>0){
//            st.push(tt.pop());
//        }
//        System.out.println(st);
    }
}
