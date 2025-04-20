import java.util.ArrayList;
import java.util.List;

public class PrintPermutation {
    public static void main(String[] args) {
        String s="abc";
        List<String> str=new ArrayList<>();
        printP(s,"",str);
        for (String i :
                str) {
            System.out.println(i);        }
    }

    private static void printP(String s, String t, List<String> str) {
        if(s.equals("")){
            str.add(t);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            String left=s.substring(0,i);
            String right=s.substring(i+1);
            String rem=left+right;
            printP(rem,t+ch,str);
        }
    }
}
