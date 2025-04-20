import java.util.Scanner;
import java.util.Stack;

public class balancedBrackets {
    public static boolean isBalanced(String s){
        Stack<Character> st=new Stack<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push('(');
            }
            else {
                if(st.size()==0) return false;
                if(s.charAt(i)==')') st.pop();
            }
        }
        if(st.size()>0) return false;
        return true;
    }
    public static int requiredBracket(String str){
        Stack<Character> st=new Stack<>();
        int count=0;
        for (int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') st.push('(');
            else if (str.charAt(i)==')'){
                if(st.size()>0) st.pop();
                else count++;
            }
        }
        return st.size()+count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String br=sc.nextLine();
        System.out.println(isBalanced(br));
        System.out.println(requiredBracket(br));
    }
}
