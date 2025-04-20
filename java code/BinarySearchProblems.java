public class BinarySearchProblems {

    //2D Array Problems
//    Problem 1: Search the ‘target’ value in a 2d integer matrix of dimensions n x m and return true if found, else
//            return false.
//    This matrix has the following properties:
//    1) Integers in each row are sorted from left to right.
//    2) The first integer of each row is greater than the last integer of the previous row.
//
//    Input :
//    Matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//    Output :
//            true
    static boolean problem1(int[][] arr,int target) {
        int n = arr.length;
        int m = arr[0].length;
        int st = 0, end = n * m - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            int midElement = arr[mid / m][mid % m];
            if (midElement == target) return true;
            else if (midElement > target) end = mid - 1;
            else st = mid + 1;
        }
        return false;
    }
//    Problem 2: Search the ‘target’ value in a 2d integer matrix of dimensions n x m and return true if found, else
//            return false.
//    This matrix has the following properties:
//    1) Integers in each row are sorted from left to right.
//    2) Integers in each row are sorted from left to right.
//
//    Input :
//    Matrix = [[1,4,7,10],[2,5,8,11],[3,6,9,12]], target = 3
//    Output :
//            true
    static boolean problem2(int[][] arr,int target){
        int n=arr.length;
        int m=arr[0].length;
        int i=0;
        int j=n-1;
        while (i<n && j>=0){
            if(arr[i][j]==target) return true;
            else if(target>arr[i][j]) i++;
            else j--;
        }
        return false;
    }

    //Binary Search to find Peak Element

//    Problem 3: Given a mountain array ‘a’ of length greater than 3, return the index ‘i’ such that arr[0] < arr[1] < ... <
//               arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]. This index is known as the peak index.
//    Input :
//    Array = [0,4,1,0]
//    Output :
//            1
    static int problem3(int[] arr){
        int st=0,end=arr.length-1;
        int ans=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]<arr[mid+1]){
                ans=mid+1;
                st=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }

//    Problem 4: A peak element is an element that is strictly greater than its neighbors.
//    Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple
//    peaks, return the index to any of the peaks.
//    You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
//    greater than a neighbor that is outside the array.
//    Input :
//    Array = [1,2,1,2,6,10,3]
//    Output :
//    Either index 1 or index 5 are the correct output. At index 1, 2 is the peak element and at
//    index 5, 10 is the peak element.
    static int problem4(int[] arr){
        int st=0,end=arr.length-1;
        int ans=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if((mid==0 || arr[mid]>arr[mid-1]) &&(mid==arr.length-1 || arr[mid]>arr[mid+1])) return mid;
            else if(arr[mid]<arr[mid+1]) st=mid+1;
            else end=mid-1;
        }
        return -1;
    }

//    Q1. Given a non-negative integer c, decide whether there are two integers a and b such that a2 + b2 = c.
//    Example 1:
//    Input:
//          5
//    Output:
//          YES
//    Explanation
//           2^2 + 1^2 = 5
//    Example 2:
//    Input:
//          10
//    Output:
//            NO
public static boolean binary_search(int low, int high, int n) {
    if(low>high) return false;
    int mid=low+(high-low)/2;
    if(mid*mid==n) return true;
    if(mid*mid>n) return binary_search(low,mid-1,n);
    return binary_search(mid+1,high,n);
}

    public static boolean judgeSquareSum(int c) {
        for (int a=0;a*a<=c;a++){
            int b=c- (int)(a*a);
            if(binary_search(0,b,b)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Problem 1
//        int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        System.out.println(problem1(arr,3));
//        System.out.println(problem1(arr,16));
//        System.out.println(problem1(arr,18));
//        System.out.println(problem1(arr,34));

        //Problem 2
//        int[][] arr={{2,4,6,8},{5,6,7,20},{7,11,13,25},{12,14,17,30}};
//        System.out.println(problem2(arr,25));

        //Problem 3
//        int[] arr={0,4,1,0};
//        System.out.println(problem3(arr));

        //Problem 4
//        int arr[]={1,2,1,2,6,10,3};
//        System.out.println(problem4(arr));

        //Question 1
        System.out.print((judgeSquareSum(10) ? "YES\n" : "NO\n"));
    }
}
