import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Linear_Search_using_Recursion {
//    Problem 1 Given an array of n integers and a target value x. Print whether x exists in the array or not.
//            Input1 : n = 8 , x = 14 , array = [4 , 12 , 54 , 14 , 3 , 8 , 6 , 1]
//    Output1 : Yes
//    Input2 : n = 1 , x = 9 , array = [2]
//    Output2 : No
    static boolean LinearSearch(int[] arr,int idx,int target){
        if(idx>=arr.length) return false;
        if(arr[idx]==target) return  true;
        return LinearSearch(arr,idx+1,target);
    }

    static int find_first_idx(int[] arr,int idx,int target){
        if(idx>=arr.length) return -1;
        if(arr[idx]==target) return  idx;
        return find_first_idx(arr,idx+1,target);
    }
    static void find_all_idx(int[] arr,int idx,int target){
        if(idx>=arr.length) return;
        if(arr[idx]==target) System.out.print(idx+" ");;
        find_all_idx(arr,idx+1,target);
    }

    static ArrayList<Integer> all_Idx(int[] arr, int idx, int target){
        //base case
        if(idx>=arr.length) return new ArrayList<Integer>();  //return new arraylist.
        //self work
        ArrayList<Integer> ans=new ArrayList<>();
        if(arr[idx]==target) ans.add(idx);
        //recursive work
        ArrayList<Integer> smallAns= all_Idx(arr,idx+1,target);
        ans.addAll(smallAns);
        return ans;
    }
//    Q1 - Count all the possible paths on an m x n grid from top left (grid[0][0]) to bottom right (grid[m-1][n-1]) having constraints that from each cell you can either move only to right or down. (Easy)
//    Input1: m = 2, n = 3
//    Output1: 3
//
//    Input2: m = 3, n = 3
//    Output2: 3

    static int numberOfPath(int m, int n,int i, int j){
        if(i==m-1 &&j==n-1) return 1;
        if (i>=m || j>=n) return 0;
        return numberOfPath(m,n,i+1,j)+numberOfPath(m,n,i,j+1);
    }

//    Q2 - Given an array of integers, print a sum triangle from it such that the first level(the bottom
//level in triangular fashion) has all array elements. From then, at each level, the number of
//    elements is one less than the previous level and elements at the level is the sum of
//    consecutive two elements in the previous level.
//
//            (Medium)
//
//    Input1 : n = 5
//    arr = {1, 2, 3, 4, 5}
//    Output1 : [48]
//            [20, 28]
//            [8, 12, 16]
//            [3, 5, 7, 9]
//            [1, 2, 3, 4, 5]

    static void sumTriangle(int arr[]){
        //base case
        if (arr.length<1) return;
        //self work
        int[] temp = new int[arr.length - 1];
        for (int i=0;i<arr.length-1;i++){
            temp[i]=arr[i]+arr[i+1];
        }
        //recursive work
        sumTriangle(temp);
        System.out.println(Arrays.toString(arr));
    }

//    Q3 - Given an array of size n, generate and print all possible combinations of r elements in array. (Hard)
//    Input1:
//    n = 4
//    {1, 2, 3, 4}
//    r = 2
//    Output1:
//    {1, 2}
//    {1, 3}
//    {1, 4}
//    {2, 3}
//    {2, 4}
//    {3, 4}
//    Input2:
//    n = 5
//    {1, 2, 3, 4, 5}
//    r = 3
//    Output2:
//    {1, 2, 3}
//    {1, 2, 4}
//    {1, 2, 5}
//    {1, 3, 4}
//    {1, 3, 5}
//    {1, 4, 5}
//    {2, 3, 4}
//    {2, 3, 5}
//    {2, 4, 5}
//    {3, 4, 5}


    public static void printCombination(int[] arr, int n, int r) {
        // A temporary array to store all combination one by one
        int data[]=new int[r];
        // Print all combination using temporary array 'data[]'
        combination(arr, n, r, 0, data, 0);
    }
    public static void combination(int[] arr, int n, int r, int index, int[] data, int i) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
        // When no more elements are there to put in data[]
        if (i >= n)
            return;
        // current is included, put next at next location
        data[index] = arr[i];
        combination(arr, n, r, index+1, data, i+1);
        // current is excluded, replace it with next (Note that i+1 is passed, but index is not changed)
        combination(arr, n, r, index, data, i+1);
    }

//    Q4 - Given two sorted arrays A and B of length m and n respectively, generate all possible arrays
//    such that the first element is taken from A then from B then from A, and so on in increasing order
//    till the arrays are exhausted. The generated arrays should end with an element from B.
//
//            (Hard)
//
//    Input1:
//    m = 3
//    n = 4
//    A = {10, 15, 25}
//    B = {1, 5, 20, 30}
//    Output1:
//            10 20
//            10 20 25 30
//            10 30
//            15 20
//            15 20 25 30
//            15 30
//            25 30
//    Input2:
//    m = 2
//    n = 1
//    A = {5, 7}
//    B = {10}
//    Output2:
//            5 10
//            7 10

    static void generate(int[] A,int[] B,int []C,int i,int j,int m,int n,int len,boolean flag){
        if (flag) {
            // Include valid element from A
            // Print output if there is at least one 'B' in output array 'C'
            if (len != 0) {
                printArr(C, len + 1);
            }
            // Recur for all elements of A after current index
            for (int k = i; k < m; k++) {
                if (len == 0) {     //this block works for the very first call to include the first element in the output array
                    C[len] = A[k];
                    // don't increment len as B is included
                    generate(A, B, C, k + 1, j, m, n, len, !flag);
                } else if (A[k] > C[len]) { // include valid element from A and recur
                    C[len + 1] = A[k];
                    generate(A, B, C, k + 1, j, m, n, len + 1, !flag);
                }
            }
        }
        else {  //Include valid element from B and recur
            for (int l = j; l < n; l++) {
                if (B[l] > C[len]) {
                    C[len + 1] = B[l];
                    generate(A, B, C, i, l + 1, m, n, len + 1, !flag);
                }
            }
        }
    }

    public static void printArr(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
//        int[] arr={1,2,3,3,4,5,6,33,3,7,3};
//        if(LinearSearch(arr,0,33)) System.out.println("Yes");
//        else System.out.println("False");
//        System.out.println(find_first_idx(arr,0,3));
//        find_all_idx(arr,0,3);
//        ArrayList<Integer> ans=all_Idx(arr,0,3);
//        for (Integer i : ans) {
//            System.out.println(i);
//        }
//        System.out.println(numberOfPath(2,3,0,0));

//        int[] arr={1,2,3,4,5};
//        sumTriangle(arr);
//
//        printCombination(arr,arr.length,2);

        int []arr1={10,15,25};
        int []arr2={1,5,20,30};
        int [] ext=new int[arr1.length+arr2.length];
        generate(arr1,arr2,ext,0,0,arr1.length,arr2.length,0,true);
    }
}
