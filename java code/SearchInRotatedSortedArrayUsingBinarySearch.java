public class SearchInRotatedSortedArrayUsingBinarySearch {
//    Problem 1: A rotated sorted array array is a sorted array on which rotation operation has been performed some
//    number of times. Given a rotated sorted array, find the index of the minimum element in the array. Follow 0-
//    based indexing.
//    It is guaranteed that all the elements in the array are unique.
//    Input :
//    Array = [5, 6, 7, 8, 9, 10, 1, 2, 3, 4]
//    Output: 6
    static int findMin(int[] arr){
        int n=arr.length;
        int st=0,end=n-1;
        int ans=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]<=arr[n-1]){
                ans=mid;
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
//    Problem 2: Given the rotated sorted array of integers, which contains distinct elements, and an integer target,
//            return the index of target if it is in the array. Otherwise return -1.
//    Input:
//    Array = [3, 4, 5, 1, 2] , target = 4
//    Output: 1
    static int search(int[] arr,int target){
        int n= arr.length;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<arr[end]){
                if(arr[mid]<target && arr[end]>=target) st=mid+1;
                else end=mid-1;
            }
            else {
                if(arr[st]<=target && arr[mid]>target) end=mid-1;
                else st=mid+1;
            }
        }
        return -1;
    }
//    Problem 3: Search element in rotated sorted array with duplicate elements. Return true if the element is found,
//    else return false.
//    Input :
//    [0,0,0,1,1,1,2,0,0,0], target = 2
//    Output : true
    static boolean searchInDUParr(int[] arr,int target){
        int n= arr.length;
        int st=0,end=n-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==target) return true;
            else if(arr[st]==arr[mid] && arr[mid]==arr[end]){
                st++;
                end--;
            }
            else if(arr[mid]<=arr[end]){
                if(arr[mid]<target && arr[end]>=target) st=mid+1;
                else end=mid-1;
            }
            else {
                if(arr[st]<=target && arr[mid]>target) end=mid-1;
                else st=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        int[] arr={5,6,7,8,1,2,3,4};
//        System.out.println(findMin(arr));
//        System.out.println(search(arr,7));

        int[] arr={0,0,0,1,1,1,2,0,0,0};
        System.out.println(searchInDUParr(arr,2));
    }
}
