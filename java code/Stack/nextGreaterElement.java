import java.util.Stack;

public class nextGreaterElement {
    public static int[] nextGreater(int[] arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] res=new int[n];
        res[n-1]=-1;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            while (st.size()>0 && st.peek()<=arr[i] ) {
                st.pop();
            }
            if(st.size()==0) res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={1,5,3,2,3,1,6,3,4};
        int res[]=nextGreater(arr);
        for(int i:res) System.out.print(i+" ");
    }
}
