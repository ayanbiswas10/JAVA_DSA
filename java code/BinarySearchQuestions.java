public class BinarySearchQuestions {
//    1. Given a sorted array of integers and a key element, you need to print the index where the element is
//    present. If the target element is not present in the array, print -1.
//    Input :
//    N=10, target= 5
//    Array = 1 3 3 4 5 8 9 11 15 15
//    Output:
//    Index found at 4
    static int Question1(int[] arr,int key){
        int st=0,end=arr.length-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==key) return mid;
            else if(arr[mid]<key) st=mid+1;
            else end=mid-1;
        }
        return -1;
    }
//    2. You are given a sorted array containing N integers and a number target. Implement the upper bound
//    function that returns the index of an element just greater than the target element. If there exists no such
//    element then return -1.
//    Note: The target may not be present in the array.
//    Input :
//    N=10, target= 3
//    Array = 1 3 3 4 5 8 9 11 15 15
//    Output:3
    static int UpperBound(int[] arr,int target){
        int st=0,end=arr.length-1;
        int ans=arr.length;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]>target){
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
//    3. You are given a sorted array containing N integers and a number target. Implement the lower bound
//    function that returns the index of the first element that is greater than or equal to the ‘target’ value. If there
//    exists no such element then return -1.
//    Note: The target may not be present in the array.
//        Input:
//        N=10, target= 3
//        Array = 1 3 3 4 5 8 9 11 15 15
//        Output :
//                 1
    static int lowerBound(int[] arr,int target){
        int st=0,end=arr.length-1;
        int ans=arr.length;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]>=target){
                ans=Math.min(mid,ans);
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
//    4. You are given a sorted array containing N integers and a number target, you have to find the number of
//    occurrences of the target in the given array.
//    Input:
//    N=10, target= 5
//    Array = 1 3 3 4 5 5 5 11 15 15
//    Output: 3 [number of occurrences of element with value 5 will be 3.]

    static int numberOfOccurrence(int[] arr, int target){
        int st=0,end=arr.length-1;
        int fo=-1;
        int lo=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==target){
                fo=mid;
                end=mid-1;
            }
            else if(arr[mid]>target) end=mid-1;
            else st=mid+1;
        }
        st=0;
        end=arr.length-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]==target){
                lo=mid;
                st=mid+1;
            }
            else if(arr[mid]>target) end=mid-1;
            else st=mid+1;
        }
        return (lo-fo+1);
    }
//    5. Given a sorted array of distinct integers that is rotated in nature, find the value of the maximum element in
//    the array.
//    Input:
//    N = 10
//    Array = 6 7 11 13 15 1 2 3 4 5
//    Output:
//    Maximum element found at index 4
//    Value of that element found 15
    static void maxElement(int[] arr){
        int n=arr.length;
        int st=0,end=n-1;
        int ans=-1;
        while (st<=end){
            int mid=st+(end-st)/2;
            if(arr[mid]>arr[n-1]){
                ans=Math.max(ans,mid);
                st=mid+1;
            }
            else end=mid-1;
        }
        System.out.println("Maximum element found at Index "+ans);
        System.out.println("Value of the element found "+arr[ans]);
    }
    public static void main(String[] args) {
        //Question 1
        int[] arr={1,3,3,4,5,8,9,11,15,15};
        System.out.println("Index found at "+Question1(arr,5));

        //Question 2
        System.out.println(UpperBound(arr,3));

        //Question3
        System.out.println(lowerBound(arr,3));

        //Question 4
        System.out.println(numberOfOccurrence(arr,5));

        //Question 5
        int[] arr1={6, 7, 11,13, 15, 1, 2, 3, 4, 5};
        maxElement(arr1);
    }
}
