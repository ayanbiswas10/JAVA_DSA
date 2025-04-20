import java.util.Stack;
public class arrayImplementationOfStack {
    public static class Stack{
        int[] arr=new int[5];
        int idx=0;
        void push(int x){
            if(isFull()){
                System.out.println("Stack is Full!");
                return;
            }
            arr[idx]=x;
            idx++;
        }
        int pop(){
            if(idx==0){
                System.out.println("Stack is Empty!");
                return -1;
            }
            int top=arr[idx-1];
            idx--;
            return top;
        }
        int peek(){
            if (idx == 0) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            return arr[idx-1];
        }
        int size(){
            return idx;
        }
        void display(){
            for (int i=0;i<idx;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        boolean isEmpty(){
            if(idx==0) return true;
            return false;
        }
        boolean isFull(){
            if(idx==arr.length) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        Stack st=new Stack();
        st.pop();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.size());
        System.out.println(st.peek());
        st.display();
        System.out.println(st.isFull());
        st.pop();
        System.out.println(st.size());
        System.out.println(st.peek());
        st.display();
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
        st.push(7);
        st.push(7);
    }
}
