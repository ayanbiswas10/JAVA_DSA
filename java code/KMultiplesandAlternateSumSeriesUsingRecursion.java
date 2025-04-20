public class KMultiplesandAlternateSumSeriesUsingRecursion {
//    Problem 1 : Given a number num and a value k. Print k multiples of num.
//            Constraints : k > 0
//    I/P : num = 12 , k = 5
//         O/P :   12 , 24 , 36 , 48 , 60
//    I/P : num = 3 , k = 8
//         O/P :   3 , 6 , 9 , 12 , 15 , 18 , 21 , 24.
    public static void Q1(int num,int k){
        //base case
        if(k==0){
            //System.out.println(num);
            return;
        }
        //recursive work
        Q1(num,k-1);
        //self work
        System.out.println(num*k);
    }

//    Problem 2 : Given a number n. Find the sum of natural numbers till n but with alternate signs.
//    That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your answer.
//            Constraints : 0<=n<=1e6
//    I/P : n = 10
//          O/P :  -5
//       Explanation : 1-2+3-4+5-6+7-8+9-10 = -5
//    I/P : n = 5
//          O/P :  3
    public static int Q2(int n){
        //base case
        if(n==1)
            return n;
        if(n%2==0) return Q2(n-1)-n;
        return Q2(n-1)+n;

    }
//    Q3 - Given a number n, print the following pattern without using any loop.                    //  (Easy)
//            n, n-5, n-10, ..., 0, 5, 10, ..., n-5, n
//    Input1: n = 16
//    Output1: 16, 11, 6, 1, -4, 1, 6, 11, 16
//    Input2: n = 10
//    Output2: 10, 5, 0, 5, 10
    public static void Q3(int n){
        //base case
        if(n<=0){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        Q3(n-5);
        System.out.print(n+" ");
    }

//    Q4 - Find m-th summation of first n natural numbers where m-th summation of first n natural       // (Medium)
//    numbers is defined as following:
//    If m > 1: SUM(n, m) = SUM(SUM(n, m - 1), 1)
//    Else :SUM(n, 1) = Sum of first n natural numbers.
//          Input1: n = 3, m = 2
//          Output1: SUM(3, 2) = 21
//          Explanation : SUM(3, 2)
//                      = SUM(SUM(3, 1), 1)
//                      = SUM(6, 1)
//                      = 21
//          Input2 : n = 4, m = 1
//          Output2 : SUM(4, 1) = 10
    public static int Q4(int n,int m){
        if(m==1){
            return sumof(n);
        }
        return sumof(Q4(n,m-1));
    }
    public static int sumof(int n){
        if(n==1) return 1;
        return n+sumof(n-1);
    }
    public static void main(String[] args) {
        // Q1(7,7);
        // System.out.println(Q2(10));
        //Q3(16);
        System.out.println(Q4(4,1));
    }
}
