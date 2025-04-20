import java.util.Arrays;

public class Problems_on_Bubble_Selection_Sort {
//    Problem 1: Given an integer array arr, move all 0's to the end of it while maintaining the relative order of the
//    non-zero elements.
//    Note that you must do this in-place without making a copy of the array.
//            : arr = [0,5,0,3,42]
//            [5,3,42,0,0]

    static void problem1(int[] arr){
        for (int i=0;i<=arr.length-1;i++){
            boolean flag=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]==0&&arr[j+1]!=0){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag) return;
        }
    }

//    Problem 2: Give an array of names of the fruits; you are supposed to sort it in lexicographical order using the
//    selection sort.
//    Input: [“papaya”,“lime”,”watermelon”,“apple”,”mango”,”kiwi”]
//    Output:  [”apple”,”kiwi”,”lime”,”mango”,”papaya”,”watermelon”]

    static void problem2(String[] s){
        for (int i=0;i<s.length-1;i++){
            int min_idx=i;
            for (int j=i+1;j<s.length;j++){
                //String s1,s2;
                //s1.compareTo(s2);
                //if s1<s2 then it returns negative number
                //if s1>s2 then it returns positive number
                //if s1==s2 then it returns 0
                if(s[min_idx].compareTo(s[j])>0) min_idx=j;
            }
            String temp=s[min_idx];
            s[min_idx]=s[i];
            s[i]=temp;
        }
    }
//
//    Q1 - Given an array of strings arr[]. Sort given strings using Bubble Sort and display the sorted
//    array.
//    Input1:
//    n = 3
//    arr[] = [coding, is, fun]
//    Output1: Coding fun is
//    Input2:
//    n = 5
//    arr[] = [string, two, is, this]
//    Output2:
//    is string this two

    static void Q1(String[] s){
        for(int i=0;i<s.length-1;i++){
            boolean flag=false;
            for (int j=0;j<s.length-1-i;j++){
                if(s[j].compareTo(s[j+1])>0) {
                    String temp=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag) return;
        }
    }
//    Q2 - Given a string s, return the string which contains all characters of s in lexicographical
//    order.
//      Input1:coding
//      Output1:cdgino
//      Input2:abcde
//      Output2:abcde

    static void Q2(String s){
        char[] arr=s.toCharArray();
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                char temp= arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        String ans = "";
        for(int i = 0; i < arr.length; i++){
            ans += arr[i];
        }
        System.out.println(ans);
    }

//    Q3 - Given an integer array and an integer k where k<size of array, We need to return the kth smallest element of the array.
//      Input1:
//      n = 4
//      arr[] = [1,2,3,4]
//      k=4
//      Output1: 4
//      Input2:
//      n = 5
//      arr[] = [3,5,6,2,1]
//      k=3
//      Output2: 3

    static void Q3(int[] arr,int k){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        System.out.println(k-1);
    }

//    Q4 - Given an array of n elements, the task is to find the elements that are greater than half of elements in an
//    array. In case of odd elements, we need to print elements larger than floor(n/2) elements where n is the total
//    number of elements in the array.
//    Input1:
//    n = 4
//    arr[] = [1, 6, 3, 4]
//    Output1:  4 6
//    Input2:
//    n = 5
//    arr[] = [10, 4, 2, 8, 9]
//    Output2:
//            10 9 8

    static void Q4(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        int si;
        if(arr.length % 2 == 0){
            si = arr.length/2;
        }else{
            si = arr.length/2 + 1;
        }
        for (int i = si; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

//    Q5 - Given an array of digits (values are from 0 to 9), the task is to find the minimum possible sum of two numbers
//    formed from digits of the array. Please note that all digits of the given array must be used to form the two numbers.

//    Input1:
//    n = 6
//    arr[] = [6, 8, 4, 5, 2, 3]
//    Output1: 604

//    Input2:
//    n = 5
//    arr[] = [5, 3, 0, 7, 4]
//    Output2: 82

    static void Q5(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        int a=0;
        int b=0;
        for(int i=0;i<arr.length;i++){
            if((i+1)%2==0){
                a=a*10+arr[i];
            }
            else {
                b=b*10+arr[i];
            }
        }
        System.out.println(a+b);
    }

//    Q6 - Given an array with N distinct elements, convert the given array to a form where all elements are in the
//    range from 0 to N-1. The order of elements is the same, i.e., 0 is placed in the place of the smallest element,
//    1 is placed for the second smallest element, ... N-1 is placed for the largest element.
//    Input1:
//    n = 3
//    arr[] = {10, 40, 20}
//    Output1: 0 2 1
//    Input2:
//    n = 5
//    arr[] = {5, 10, 40, 30, 20}
//    Output2:  0 1 4 3 2

    static void Q6(int[] org){
        int[] arr=org.clone();
        for(int i=1;i<arr.length;i++){
            int j=i;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }

        for (int i=0;i<org.length;i++){
            for(int j=0;j< arr.length;j++) {
                if(org[i]==arr[j]) System.out.print(j+" ");
            }
        }
    }

//    Q7-Given an array, sort it using insertion sort recursively.
//    Input1:
//    n = 5
//    arr[] = [4,5,2,7,1]
//    Output1:  1 2 4 5 7
//    Input2:
//    n = 3
//    arr[] = [2,2,1]
//    Output2:  1 2 2

    static void recursiveInsertionSort(int arr[],int idx){
        if (idx== arr.length) return;
        recursiveInsertionSort(arr,idx+1);
            int j=idx;
            while (j>0 && arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
    }

    public static void main(String[] args) {
        //Problem 1
//        int[] arr={0,5,0,3,42};
//        problem1(arr);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }

        //Problem 2
//        String []s={"papaya","lime","watermelon","apple","mango","kiwi"};
//        problem2(s);
//        for (String i:
//             s) {
//            System.out.print(i+" ");
//        }

//        //Q1
//        String s[]={"string", "two", "is", "this"};
//        Q1(s);
//        for(String ch:s){
//            System.out.print(ch+" ");
//        }

        //Q2
//        String s="coding";
//        Q2(s);

        //Q3
//        int arr[] = {3,5,6,2,1};
//        int k=4;
//        Q3(arr,k);

        //Q4
//        int arr[]={1, 6, 3, 4};
//        int[] arr={10, 4, 2, 8, 9};
//        Q4(arr);

        //Q5
//        int[] arr={5, 3, 0, 7, 4};
//        Q5(arr);

        //Q6
//        int []arr={5, 10, 40, 30, 20};
//        Q6(arr);

        //Q7
        int[] arr={4,5,2,7,1};
        recursiveInsertionSort(arr,0);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
