public class LinkedListImplementationOfStack {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    public static class Stack{
        Node head=null;
        int size=0;
        void push(int x){
            Node temp=new Node(x);
            temp.next=head;
            head=temp;
            size++;
        }
        void displayRec(Node he){
            if(he==null) return;
            displayRec(he.next);
            System.out.print(he.val+" ");
        }
        void display(){
            displayRec(head);
            System.out.println();
        }
        int pop(){
            if(size==0){
                System.out.println("Stack is Empty!");
                return -1;
            }
            int x= head.val;
            head=head.next;
            size--;
            return x;
        }
        int peek(){
            if(size==0){
                System.out.println("Stack is Empty!");
                return -1;
            }
            return head.val;
        }
        int size(){
            return size;
        }
        boolean isEmpty(){
            if(size==0) return true;
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
        st.pop();
        System.out.println(st.size());
        System.out.println(st.peek());
        st.display();
        System.out.println(st.isEmpty());
        st.push(7);
        st.push(7);
    }
}
