import java.util.Stack;

public class deleteStack {
    public static void deleteRec(Stack<Integer> st,int idx){
        if(st.size()==0) return;
        else if(st.size()==idx) {
            st.pop();
        }
        int top=st.pop();
        deleteRec(st,idx);
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
        deleteRec(st,3);
        System.out.println(st);
//        Stack<Integer> temp=new Stack<>();
//        int pos=3;
//        while (st.size()>pos) temp.push(st.pop());
//        st.pop();
//        while (st.size()>0) temp.push(st.pop());
//        while (temp.size()>0) st.push(temp.pop());
//        System.out.println(st);
    }
}
