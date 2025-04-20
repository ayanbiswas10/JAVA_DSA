public class Recursion_on_Arrays {
    public static void ArrayRecursion(int []arr,int idx){
        //base case
        if(idx==arr.length){
            return;
        }
        //self work
        System.out.print(arr[idx]+" ");
        //recursive work
        ArrayRecursion(arr,idx+1);
    }
    public static int MaxValue(int[] arr,int idx){
        //base case
        if(idx==arr.length-1) return arr[idx];

        //recursive work/ small problem
        int smallAns=MaxValue(arr,idx+1);

        //self work
        return Math.max(arr[idx],smallAns);
    }
    public static int SumArray(int[] arr,int idx){
        if(idx== arr.length-1) return arr[idx];
//        if(idx==arr.length) return 0;

        return arr[idx]+SumArray(arr,idx+1);
    }

//    Q1 - Count all the possible paths on an m x n grid from top left (grid[0][0]) to bottom right (grid[m-1][n-1]) having constraints that from each cell you can either move only to right or down. (Easy)
//    Input1: m = 2, n = 3
//    Output1: 3
//
//    Input2: m = 3, n = 3
//    Output2: 6
    public static int Q1(int arr[][],int i,int j){
        if(i==arr.length-1 && j==arr[0].length-1) return 1;

        if(i>= arr.length || j>=arr[0].length) return 0;

        int rightPath=Q1(arr,i+1,j);
        int downPath=Q1(arr,i,j+1);
        return rightPath+downPath;
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
//    Explanation :
//    Here, Level-5: [48]
//    Level-4: [20, 28] -->(20 + 28 = 48)
//    Level-3: [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
//    Level-2: [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
//    Level-1: [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
//    Input2 : n = 3
//    arr = {8, 2, 0}
//    Output2 : [12]
//            [10, 2]
//            [8, 2, 0]
    public static void main(String[] args) {
//       int[] arr={7,4,1,1,5,5};
//       ArrayRecursion(arr,0);
//        System.out.println("");
//        System.out.println("Maximum element in the Array: "+MaxValue(arr,0));
//        System.out.println("Sum of all element of the Array: "+SumArray(arr,0));

        int [][]arr=new int[3][3];
        System.out.println(Q1(arr,0,0));
    }
}
