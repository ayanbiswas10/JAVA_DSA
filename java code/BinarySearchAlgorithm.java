public class BinarySearchAlgorithm {
    static boolean binarySearch(int[] arr,int target){
        int st=0,end=arr.length-1;
        while (st<=end){
            int mid=st+ (end-st)/2;
            if(target==arr[mid]){
                return true;
            }
            else if(target<arr[mid]){
                end=mid-1;
            }
            else {
                st=mid+1;
            }
        }
        return false;
    }

    static boolean recursiveBinarySearch(int[] arr,int st,int end,int target) {
        if(st>end) {
            return false;
        }
        int mid = st+ (end-st)/2;
        if (arr[mid] == target) {
            return true;
        } else if (target < arr[mid]) {
            return recursiveBinarySearch(arr, st, mid - 1, target);
        } else {
            return recursiveBinarySearch(arr, mid + 1, end, target);
        }
    }

//    Problem 1: Find the index of the first occurrence of a given element x in an array. It is given that the array is
//    sorted. If no occurrence of x is found then return -1.
//    Input
//    arr = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
//    x = 5
//    Output
//    1

    static int firstOccurrence(int[] arr,int x){
        int st=0,end=arr.length-1;
        int fo=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==x) {
                fo=mid;
                end=mid-1;
            }
            else if(arr[mid]>x) end=mid-1;
            else st=mid+1;
        }
        return fo;
    }
    static int lastOccurrence(int[] arr,int x){
        int st=0,end=arr.length-1;
        int lo=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==x){
                lo=mid;
                st=mid+1;
            }
            else if (x<arr[mid]) end=mid-1;
            else st=mid+1;
        }
        return lo;
    }
    static void allOccurrence(int[] arr,int x){
        int fo=firstOccurrence(arr,x);
        int lo=lastOccurrence(arr,x);
        for (int i=fo;i<=lo;i++){
            System.out.print(i+" ");
        }
    }

//    Problem 2: Find the square root of the given non negative value x. Round it off to the nearest floor integer value.
//    Input: x = 4
//    Output: 2
//    Input: x = 11
//    Output: 3

    static int sqrt(int x){
        int st=0,end=x;
        int ans=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            int val=mid*mid;
            if(val==x) return mid;
            else if(val<x) {
                ans=mid;
                st=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
//        int[] arr={1,2,3,4,5};
//        System.out.println(binarySearch(arr,3));
//        System.out.println(binarySearch(arr,8));
//        System.out.println(recursiveBinarySearch(arr,0,arr.length-1,4));
//        System.out.println(recursiveBinarySearch(arr,0,arr.length-1,9));

        //Problem 1
//        int[] arr={2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
//        System.out.println(firstOccurrence(arr,5));
//        System.out.println(lastOccurrence(arr,5));

        //Problem 2
        System.out.println(sqrt(39));

    }
}
