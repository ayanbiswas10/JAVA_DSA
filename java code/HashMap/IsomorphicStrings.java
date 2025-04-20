import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character sCh=s.charAt(i);
            Character tCh=t.charAt(i);
            if(map.containsKey(sCh)){
                if(map.get(sCh)!=tCh) return false;
            }
            else if(map.containsValue(tCh)){
                return false;
            }
            else{
                map.put(sCh,tCh);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="egg" ;
        String t="add";
        System.out.println(isIsomorphic(s,t));
    }
}
