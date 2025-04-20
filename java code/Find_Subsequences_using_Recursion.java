import java.util.ArrayList;

public class Find_Subsequences_using_Recursion {
    static ArrayList<String> SSQ(String s){
        ArrayList<String> ans=new ArrayList<>();
        //base case
        if(s.length()==0){
            ans.add("");
            return ans;
        }
        ArrayList<String> smallAns=new ArrayList<>();
        char curChar=s.charAt(0);
        smallAns=SSQ(s.substring(1));
        for (String ss :
                smallAns) {
            ans.add(ss);
            ans.add(curChar+ss);
        }
        return ans;
    }

    static void printSSQ(String s,String curAns){
        if(s.length()==0){
            System.out.println(curAns);
            return;
        }
        char curChar=s.charAt(0);
        String rem=s.substring(1);
        printSSQ(rem,curAns+curChar);
        printSSQ(rem,curAns);
    }

    static void subsetSum(int[] a,int idx,int sum){
        if(idx>=a.length){
            System.out.print(sum+" ");
            return;
        }
        subsetSum(a,idx+1,sum+a[idx]);
        subsetSum(a,idx+1,sum);
    }

//    Q1. Given the number of digits n in a number, print all n-digit numbers whose digits are strictly
//    increasing from left to right.
//           Input 1: n = 2
//           Output 1: 01 02 03 04 05 06 07 08 09 12 13 14 15 16 17 18 19 23 24 25 26 27 28
//            29 34 35 36 37 38 39 45 46 47 48 49 56 57 58 59 67 68 69 78 79 89
//           Input 2 : n = 3
//           Output 2: 012 013 014 015 016 017 018 019 023 024 025 026 027 028 029 034
//            035 036 037 038 039 045 046 047 048 049 056 057 058 059 067 068
//            069 078 079 089 123 124 125 126 127 128 129 134 135 136 137 138
//            139 145 146 147 148 149 156 157 158 159 167 168 169 178 179 189
//            234 235 236 237 238 239 245 246 247 248 249 256 257 258 259 267
//            268 269 278 279 289 345 346 347 348 349 356 357 358 359 367 368
//            369 378 379 389 456 457 458 459 467 468 469 478 479 489 567 568
//            569 578 579 589 678 679 689 789

    static void Q1(int n,String s,int start){
        if(n==0){
            System.out.print(s+" ");
            return;
        }
        for(int i=start;i<=9;i++){
            String s1= s+String.valueOf(i);
            Q1(n-1,s1,i+1);
        }
    }

//    Q2. A string is called special if it consists of only stars(‘*’) and dashes(‘-’), and the number of
//    stars is more than the number of dashes for any prefix of the string. Given a positive integer n,
//    print all the special strings of size n.
//    Input 1:n = 1
//     Output 1:*
//    Input 2:n = 3
//   Output 2:***
//            **-
//            *-*
    static void Q2(int remChar,String ans,int numOfDash,int numOfStar){
        if(remChar==0){
            System.out.println(ans+"");
            return;
        }
        Q2(remChar-1,ans+"*",numOfDash,numOfStar+1);
        if(numOfDash+1<=numOfStar){
            Q2(remChar-1,ans+"_",numOfDash+1,numOfStar);
        }
    }

//    Q3. Given a set of characters and a positive integer k, print all possible strings of length k that
//    can be formed from the given set.
//            Examples:
//
//    Input 1: Size of set = 2
//             Set = {x, y}
//             k = 2
//
//    Output 1: xx
//              xy
//              yx
//              yy
//        Input 2: Size of set = 2
//                 Set = {a, b}
//                 k = 3
//
//    Output 2: aaa
//              aab
//              aba
//              abb
//              baa
//              bab
//              bba
//              bbb

    static void Q3(char[] ch,String ans, int remChar){
        if(remChar==0){
            System.out.println(ans);
            return;
        }
        for (int i=0;i<ch.length;i++){
            Q3(ch,ans+ch[i],remChar-1);
        }
    }

//    Q4. Given an input string of digits, find all combinations of numbers that can be formed using
//    digits in the same order.
//            Examples :
//   Input 1: 123
//   Output 1:1 2 3
//            1 23
//            12 3
//            123
//   Input 2: 1234
//   Output 2:1 2 3 4
//            1 2 34
//            1 23 4
//            1 234
//            12 3 4
//            12 34
//            123 4
//            1234

    static void Q4(String arr,int idx,String ans){
        if(idx>=arr.length()){
            System.out.println(ans);
            return;
        }
        Q4(arr,idx+1,ans+arr.charAt(idx));
        if(idx!=arr.length()-1)
        Q4(arr,idx+1,ans+arr.charAt(idx)+" ");
    }

//    Q5. A string is called special if it consists of only stars(‘*’) and dashes(‘-’), and there are no
//    consecutive stars in the string. Given a positive integer k, print all the special strings of size k.
//    Examples:
//    Input 1: K = 3
//    Output 1: ---
//              --*
//              -*-
//              *--
//              *-*
//    Input 2 :    K = 4
//    Output 2:
//            ----
//            ---*
//            --*-
//            -*--
//            -*-*
//            *---
//            *--*
//            *-*-

    static void Q5(int remChar,String ans){
        if(remChar==0){
            System.out.println(ans);
            return;
        }
        Q5(remChar-1,ans+"_");
        if(ans.length()==0||ans.charAt(ans.length()-1)=='_'){
            Q5(remChar-1,ans+"*");
        }
    }

    public static void main(String[] args) {
        String s="abc";
//        ArrayList<String> ans=SSQ(s);
//        for (String i :
//                ans) {
//            System.out.print(i+" ");
//        }

//        printSSQ(s,"");
//
//        int[] a={1,2,3,4};
//        subsetSum(a,0,0);

//        Q1(2,"",0);

//        Q2(3,"",0,0);

//        char[] ch={'a','b'};
//        Q3(ch,"",3);

//        String arr="123";
//        Q4(arr,0,"");

        Q5(3,"");
    }
}
