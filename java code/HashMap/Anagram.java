import java.util.HashMap;

public class Anagram {
    static HashMap<Character,Integer> makeFreqMap(String st){
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<st.length();i++){
            Character ch = st.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch,1);
            }
            else {
                int currFrq=mp.get(ch);
                mp.put(ch,currFrq+1);
            }
        }
        return mp;
    }
    public static boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp1=makeFreqMap(s);
        HashMap<Character,Integer> mp2=makeFreqMap(t);
        return mp1.equals(mp2);
    }
    public static boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> mp=makeFreqMap(s);
        for(int i=0;i<t.length();i++){
            Character ch=t.charAt(i);
            if(!mp.containsKey(ch)) return false;
            else{
                int currFrq=mp.get(ch);
                if(currFrq-1<0) return false;
                mp.put(ch,currFrq-1);
            }
        }
        for(Integer i:mp.values()){
            if(i!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str1="aacc";
        String str2="ccac";
//        System.out.println(isAnagram1(str1,str2));
                System.out.println(isAnagram2(str1,str2));
    }
}
