public class Problems_on_Advanced_Sorting_Algorithms {
//    Problem 1 :
//    Given an array where all its elements are sorted in increasing order except two swapped elements, sort it in
//    linear time. Assume there are no duplicates in the array.
//    For example,
//    Input: A[] = [3, 8, 6, 7, 5, 9, 10]
//    Output: A[] = [3, 5, 6, 7, 8, 9, 10]
    static void problem1(int[] arr){
        if(arr.length<=1) return;
        int x=-1,y=-1;
        int prev=arr[0];
        for(int i=1;i<arr.length;i++){
            if(prev>arr[i]){
                if(x==-1){
                    x=i-1;
                    y=i;
                }
                else {
                    y=i;
                }
            }
            prev=arr[i];
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

//    Problem 2: Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
//    Input:
//    N = 6
//    arr[]= {0 2 1 2 0 0}
//    Output:
//            0 0 0 1 2 2

    static void problem2(int[] num){
        int i=0;
        int count0=0;
        int count1=0;
        int count2=0;
        for( i=0;i<num.length;i++) {
            switch (num[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }
            i=0;

                // Store all the 0s in the beginning
                while (count0 > 0) {
                    num[i++] = 0;
                    count0--;
                }

                // Then all the 1s
                while (count1 > 0) {
                    num[i++] = 1;
                    count1--;
                }

                // Finally all the 2s
                while (count2 > 0) {
                    num[i++] = 2;
                    count2--;
                }
    }

//    Problem 3: Given an array of positive and negative integers, segregate them in linear time and constant space.
//    The output should print all negative numbers, followed by all positive numbers.
//            For example,
//    Input: [ 19, -20, 7, -4, -13, 11, -5, 3 ]
//    Output: [ -20 -4 -13 -5 7 11 19 3 ];

    public static void partition(int[] arr, int s, int e){
        int pIndex= s;
        // each time we find a negative number, `pIndex` is incremented,
        // and that element would be placed before the pivot
        for (int j = s; j <= e; j++) {
            if (arr[j] < 0){    // pivot is 0
                int temp = arr[j];
                arr[j] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
    }

    public static void main(String[] args) {
//        int A[] = {3, 8, 6, 7, 5, 9, 10};
//        problem1(A);
//        for (int i:A){
//            System.out.print(i+" ");
//        }
//        int[] arr={0,2,1,2,0,0};
//        problem2(arr);

        //Problem 3
        int[] arr={19, -20, 7, -4, -13, 11, -5, 3};
        partition(arr,0,arr.length-1);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}
