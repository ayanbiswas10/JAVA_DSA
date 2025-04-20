import  java.util.*;
import java.util.Scanner;
public class GCD_and_Euclid_Algorithm_using_Recursion {
       public static int GCD(int a, int b) {
//           if (b < a) {
//               // Swap a and b if needed
//               int temp = a;
//               a = b;
//               b = temp;
//           }
//            for (int i = a; i>0; i--) {
//                if (a % i == 0 && b % i == 0) return i;
//            }
//        return 1;
           while (b != 0) {
               int temp = b;
               b = a % b;
               a = temp;
           }
           return a;
    }

//    Euclid_Algorithm
    public static int GCD_Recursion(int a,int b){
           if(b==0) return a;
           return GCD_Recursion(b,a%b);
    }
//    Q1 - Given a number n. Print if it is an armstrong number or not.
//    An armstrong number is a number if the sum of every digit in that number raised to the power
//    of total digits in that number is equal to the number.
//            Example : 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 hence 153 is an armstrong number.//    Input1 : 153
//    Output1 : Yes
//    Input 2 : 134
//    Output2 : No

    public static int Armstrong(int a,int b){
           if(a==0) return 0;
           return pow(a%10,b)+Armstrong(a/10,b);
    }
    public static int pow(int x,int p){
           int s=1;
           for(int i=0;i<p;i++){
               s*=x;
           }
           return s;
    }
//
//    Q2 - Given two number x and y find product using recursion.
//
//    Input1 : x = 5, y = 2
//    Output1 : 10
//    Input2 : x = 100, y = 5
//    Output2 : 500

    public static int Product(int a,int b){
           if(b==1) return a;
           return a+Product(a,b-1);
    }
//    Q3 - Given a number n, check whether it's a prime number or not using recursion.
//
//    Input1 : n = 11
//    Output1 : Yes
//    Input2 : n = 15
//    Output2 : No
    public static boolean isPrime(int a,int i){
           if(a<=2) return (a==2) ? true:false;
           if(a%i==0) return false;
           if(i*i>a) return true;
           return isPrime(a,i+1);
    }
//    Q4 - Given a decimal number as input, we need to write a program to convert the given
//    decimal number into its equivalent binary number.
//
//    Input1 : 7
//    Output1 : 111
//    Input2 : 10
//    Output2 : 1010

    public static void DesiToBool(int a){
           if(a==0) {
               return;
           }

           DesiToBool(a/2);
           System.out.print(a%2);
    }
//            Q5 - Given the Binary code of a number as a decimal number, we need to convert this into its
//    equivalent Gray Code. In gray code, only one bit is changed in 2 consecutive numbers.
//    Hint: The Most Significant Bit (MSB) of the gray code is always equal to the MSB of the given
//    binary code and other bits of the output gray code can be obtained by XORing binary code bit
//    at that index and previous index.
//    Input1: 1001
//    Output1: 1101
//    Input2: 11
//    Output2: 10
    public static int binary_to_gray(int n, int i) {
        int a, b;
        int result = 0;
        if (n != 0) {
            // Taking last digit
            a = n % 10;
            n = n / 10;
            // Taking second last digit
            b = n % 10;
            if ((a & ~b) == 1 || (~a & b) == 1) {
                result = (int)(result + Math.pow(10, i));
            }
            return binary_to_gray(n, ++i) + result;
        }
        return 0;
    }


    public static void main(String[] args) {
        //System.out.println(GCD(12,24));
        //System.out.println(GCD_Recursion(12,24));

//        int arm=153;
//        int temp=arm;
//        int count=0;
//        while (temp!=0){
//            temp/=10;
//            count++;
//        }
//        if(arm==Armstrong(arm,count)) System.out.println("True");
//        else System.out.println("False");

//        System.out.println(Product(7,9));

//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter the number n: ");
//        int n = scn.nextInt();
//        if (isPrime(n, 2))
//            System.out.println("Yes");
//        else
//            System.out.println("No");

//        DesiToBool(10);
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the binary number n: ");
        int n = scn.nextInt();
        System.out.println(binary_to_gray(n, 0));

    }
}
