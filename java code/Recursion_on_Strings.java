import java.util.*;
public class Recursion_on_Strings {
    static String removeOccurrences1(String s, char ch, int idx){
        if(idx>=s.length()) return " ";
        String smallAns=removeOccurrences1(s,ch,idx+1);
        char curChar=s.charAt(idx);
        if(curChar!=ch) return curChar+smallAns;
        else return smallAns;
    }

    static String removeOccurrences2(String s, char ch){
        if(s.length()==0) return " ";
        String smallAns=removeOccurrences2(s.substring(1),ch);
        char curChar=s.charAt(0);
        if(curChar!=ch) return curChar+smallAns;
        else return smallAns;
    }

    static String reverse(String s,int idx){
        if(idx==s.length()) return "";
        String smallAns=reverse(s,idx+1);
        return smallAns+s.charAt(idx);
    }

    static boolean isPalindrome(String s,int l,int r){
        if(l>=r) return true;
        return (s.charAt(l)==s.charAt(r) && isPalindrome(s,l+1,r-1));
    }

//    Q1. Write a program to merge 2 strings alternately using recursion starting from the first input string.
//
//    Input 1:  abcd
//              efgh
//    Output :  aebfcgdh
//
//    Input 2:  abet
//              po
//    Output 2: apboet

    static String mergeStrings(String s1,String s2){
        String ans="";
        if(s1.length()==0) return s2;
        if(s2.length()==0) return s1;
        ans+=s1.substring(0,1);
        ans+=s2.substring(0,1);
        ans+=mergeStrings(s1.substring(1,s1.length()),s2.substring(1,s2.length()));
        return ans;
    }
//    Q2. Given a string, find its first uppercase letter and return the remaining substring, starting from
//    the uppercase letter.
//
//    Input 1:        collegeWallah
//    Output 1:       Wallah
//
//    Input 2:        Coding
//    Output 2:       Coding

    static String upToRemSubStr(String s,int idx){
        if(idx>=s.length()) return "";
        char ch=s.charAt(idx);
        if(Character.isUpperCase(s.charAt(idx))) return s.substring(idx);
        return upToRemSubStr(s,idx+1);
    }

//    Q3. Given a string, count total number of consonants in it. A consonant is an English alphabet
//    character that is not vowel (a, e, i, o and u). Examples of constants are b, c, d, f, and g.
//
//    Input 1: pwskills
//    Output 1: 7
//
//    Input 2: codIng
//    Output 2: 4

    static int countConsonants(String s,int idx){
        if(idx>=s.length()) return 0;
        if(checkConsonant(s.charAt(idx))) return countConsonants(s,idx+1)+ 1;
        return countConsonants(s,idx+1);
    }
    static boolean checkConsonant(char ch){
        if(ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U' && ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u'){
            return true;
        }
        return false;
    }

//    Q4. Given a string, return the number of lowercase characters in it using recursion.
//        Input 1: CollegeWallah
//        Output 1: 11
//
//        input 2: pwskiLLS
//        Output 2: 5

    static int countLowerCase(String s,int idx){
        if(idx>=s.length()) return 0;
        if(Character.isLowerCase(s.charAt(idx))) return countLowerCase(s,idx+1)+1;
        return countLowerCase(s,idx+1);
    }

//    Q5. Given a string, recursively implement atoi() or Integer.parseInt() method on it without actually
//    using the method.
//
//        Input 1: 298
//        Output 1: 298
//
//        Input 2: 011
//        Output 2: 11

    static int rec(String str, int n) {
        if (n == 0) {
            return str.charAt(0) - '0';
        }
        return (rec(str, n - 1)*10 + str.charAt(n) - '0');
    }
    public static void main(String[] args) {
//        String s="ayan";
//        System.out.println(removeOccurrences1(s,'a',0));
//        System.out.println(removeOccurrences2(s,'a'));
//        System.out.println(reverse(s,0));

        //Checking Palindrome
//        String s="level";
//        String rev=reverse(s,0);
//        if(rev.equals(s)) System.out.println(s+" is Palindrome.");
//        else System.out.println(s+" is not a Palindrome.");
//        System.out.println(isPalindrome(s,0,s.length()-1));;

        //Q1
//        String s1="abcd";
//        String s2="efgh";
//        System.out.println(mergeStrings(s1,s2));

        //Q2
//        String s="ayanBiswas";
//        System.out.println(upToRemSubStr(s,0));

        //Q3
//        String s="pwskills";
//        System.out.println(checkConsonant('b'));
//        System.out.println(countConsonants(s,0));

        //Q4
//        String s="AyAnbIswas";
//        System.out.println(countLowerCase(s,0));

        //Q4
        String s="1234";
        System.out.println(rec(s,s.length()-1));
    }
}
