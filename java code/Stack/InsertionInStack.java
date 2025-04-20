import java.util.Stack;

public class InsertionInStack {
    public static void pushAtBottomRec(Stack<Integer> st,int x){
        if(st.size()==0) {
            st.push(x);
            return;
        }
        int top=st.pop();
        pushAtBottomRec(st,x);
        st.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        pushAtBottomRec(st,10);
        System.out.println(st);
//        int idx=3;
//        int x=10;
//        Stack <Integer> temp=new Stack<>();
//        while (st.size()>idx){
//            temp.push(st.pop());
//        }
//        st.push(x);
//        while (temp.size()>0){
//            st.push(temp.pop());
//        }
//        System.out.println(st);
    }
}
