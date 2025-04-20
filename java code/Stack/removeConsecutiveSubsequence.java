import java.util.Stack;

public class removeConsecutiveSubsequence {
    public static int[] remove(int[] arr){
        Stack<Integer> st=new Stack();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty() || st.peek()!=arr[i]) st.push(arr[i]);
            else if (st.peek()==arr[i]) {
                if(i==arr.length-1 || arr[i]!=arr[i+1]) st.pop();
            }
        }
        int[] res=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3,4,4,4,5,5,6,7,7,7,1,4};
        int[] res=remove(arr);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
