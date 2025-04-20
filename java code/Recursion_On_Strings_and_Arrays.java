import java.util.ArrayList;
import java.util.Arrays;

public class Recursion_On_Strings_and_Arrays {
//    Problem 1 There are N stones, numbered 1,2,...,N. For each i (1≤i≤N), the height of Stone i is hi. There is a frog who
//    is initially on Stone 1. He will repeat the following action some number of times to reach Stone N:
//    If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2. Here, a cost of |hi - hj| is incurred, where j is the
//    stone to land on.
//    Find the minimum possible total cost incurred before the frog reaches Stone N.
//    Input :
//    n= 4
//    arr[]=10 30 40 20
//    Output:
//    30
//    Explanation:
//    If we follow the path 1 → 2 → 4, the total cost incurred would be ∣ |10−30|∣ +∣ |30−20| =30.

    static int FrogJump(int[] arr,int n,int idx){
        if(idx==n-1) return 0;
        int c1=Math.abs(arr[idx]-arr[idx+1])+FrogJump(arr,n,idx+1);
        if(idx==n-2) return c1;
        int c2=Math.abs(arr[idx]-arr[idx+2])+FrogJump(arr,n,idx+2);
        return Math.min(c1,c2);
    }
//
//    Problem 2 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the
//    number could represent. Return the answer in any order.
//    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to
//    any letters.
//
//    Example 1:
//    Input: digits = "23"
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    Example 2:
//    Input: digits = ""
//    Output: []
//    Example 3:
//    Input: digits = "2"
//    Output: ["a","b","c"]

    static void DialPad(String dig,String[] kp,String ans){
        if(dig.length()==0) {
            System.out.print(ans+" ");
            return;
        }
        int CurrNum=dig.charAt(0)-'0';
        String currChoice=kp[CurrNum];
        for(int i=0;i<currChoice.length();i++){
            DialPad(dig.substring(1),kp,ans+currChoice.charAt(i));
        }
    }

//    Q1 - You are given a string. Your task is to divide the string into palindromic substrings. Print all such
//    partitions.
//            Example:
//    Input:
//            banana
//    Output:
//            [b, a, n, a, n, a]
//            [b, a, n, ana]
//            [b, a, nan, a]
//            [b, ana, n, a]
//            [b, anana]
// Input:   farm
// Output:  [f, a, r, m]

    public static void palindromicSubStr(String s, ArrayList<String> ans, int start) {
        if (start == s.length()) {
            System.out.println(ans);
            return;
        }
        String curr = "";
        for (int end = start; end < s.length(); end++) {
            curr += s.charAt(end);
            if (isPalindrome(curr)) {
                ans.add(curr);
                palindromicSubStr(s, ans, end + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

//    Q2 - A string is called beautiful if is an even length string consisting of only stars(‘*’) and dashes(‘-’). Further
//    the number of stars in the first half of the string should be equal to the number of stars in the second half of
//    the string. Given a number n, print all the beautiful strings of length 2 * n.
//    Example:
//  Input :2
// Output:
//        ----
//        *-*-
//        *--*
//        -**-
//        -*-*
//        ****
//  Input: 1
// Output:
//        --
//        **

    static void Q2(int remChar,ArrayList<ArrayList<String>> ans,int numOfStar,String curr){
        if(remChar==0){
            ans.get(numOfStar).add(curr);
            return;
        }
        Q2(remChar-1,ans,numOfStar+1,curr+"*");
        Q2(remChar-1,ans,numOfStar,curr+'_');
    }
    static void printCombinations(ArrayList<String> ans){
        for (String ans1 : ans) {
            for(String ans2:ans){
                System.out.println(ans1+ans2);
            }
        }
    }
//    Q3 - A string is called beautiful if it consists of only stars(‘*’) and dashes(‘-’). Further the number of stars in
//    the first half of the string should be equal to the number of stars in the second half of the string. Given a
//    number n, print all the beautiful strings of length n. If the value of n is odd, the middle value can be either
//'*' or '-'
//    Example
// Input :2
// Output:
//        --
//        **
// Input: 3
// Output:
//        -*-
//        ---
//        ***
//        *-*

    public static void printCombinationsOdd(ArrayList<String> nums) {
        for (String num1 : nums) {
            for (String num2 : nums) {
                System.out.println(num1 + "*" + num2);
                System.out.println(num1 + "-" + num2);
            }
        }
    }

    public static void printCombinationsEven(ArrayList<String> nums) {
        for (String num1 : nums) {
            for (String num2 : nums) {
                System.out.println(num1 + num2);
            }
        }
    }
    public static void generateStrings(int remainingBits, ArrayList<ArrayList<String>> nums, int numberOfStars, String curr) {
        if (remainingBits == 0) {
            nums.get(numberOfStars).add(curr);
            return;
        }
        generateStrings(remainingBits - 1, nums, numberOfStars + 1, curr + "*");
        generateStrings(remainingBits - 1, nums, numberOfStars, curr + "-");
    }

//    Q4 - Problem Count the number of substrings having same first and last characters
//
//    Input :    s = "pqrpq"
//    Output :      7
//    Explanation:
//    There are 15 substrings of "pqrpq"
//    p, pq, pqr, pqrp, pqrpq, q, qr, qrp
//            qrpq, r, rp, rpq, p, pq, q
//    Out of the above substrings, there
//    are 7 substrings which have same first and last character: p, pqrp, q, qrpq,
//    r, p and q.
//    Input : s = "sss"
//    Output : 6

    public static int count(String s, int i, int j, int n) {
        // base cases
        if (n == 1)
            return 1;
        if (n <= 0)
            return 0;

        int ans = count(s, i + 1, j, n - 1) +
                count(s, i, j - 1, n - 1) -
                count(s, i + 1, j - 1, n - 2);

        if (s.charAt(i) == s.charAt(j))
            ans++;

        return ans;
    }


//    Q5 - You are given a string s. All the characters in s are distinct. Your task is to generate all the strings that
//    contain the characters of ‘s’ in increasing order.

//    Example
//  Input:
//         sam
//  Output :  a
//            am
//            ams
//            as
//            m
//            ms
//            s
//
// Input: fa
// Output:a
//        af
//        f
public static void generateSubstrings(String str, int n, int index, String curr) {
    if (index == n) {
        return;
    }
    System.out.println(curr);
    for (int i = index + 1; i < n; i++) {
        curr += str.charAt(i);
        generateSubstrings(str, n, i, curr);
        curr = curr.substring(0, curr.length() - 1);
    }
    return;
}

    public static String sort(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    public static void main(String[] args) {
//        int[] arr={10,30,40,20};
//        System.out.println(FrogJump(arr, 4, 0));

//        String dig="23";
//        String[] kp={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        DialPad(dig,kp,"");

        //Q1
//        String s="banana";
//        ArrayList<String> ans= new ArrayList<>();
//        palindromicSubStr(s,ans,0);

        //Q2
//        int n=2;
//        ArrayList<ArrayList<String>> nums = new ArrayList<ArrayList<String>>();
//        for (int i = 0; i <= n; i++) {
//            nums.add(new ArrayList<String>());
//        }
//        Q2(n, nums, 0, "");
//        for (int s = 0; s <= n; s++) {
//            printCombinations(nums.get(s));
//        }

        //Q3
//        int n=3;
//        ArrayList<ArrayList<String>> nums = new ArrayList<ArrayList<String>>();
//        for (int i = 0; i <= n; i++) {
//            nums.add(new ArrayList<String>());
//        }
//        generateStrings(n / 2, nums, 0, "");
//        if (n % 2 == 1)
//            for (int s = 0; s <= n; s++)
//                printCombinationsOdd(nums.get(s));
//        else
//            for (int s = 0; s <= n; s++)
//                printCombinationsEven(nums.get(s));

        //Q4
//        String s="pqrpq";
//        int n=s.length();
//        System.out.println(count(s, 0, n - 1, n));

        //Q5
        String s = "sam";
        s = sort(s);
        generateSubstrings(s, s.length(), -1, "");

    }
}
