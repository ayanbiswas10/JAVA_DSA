public class SelectionSortAlgorithm {
    static void selectionSort(int[] arr){
        int n=arr.length;

        for(int i=0;i<n-1;i++){
            int min_idx=i;
            for (int j=i+1;j<n;j++){
                if(arr[min_idx]>arr[j]){
                    min_idx=j;
                }
            }
            if(min_idx!=i) {
                int temp = arr[i];
                arr[i] = arr[min_idx];
                arr[min_idx] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={5,0,8,1,4,3,65,6780,565,6431,96,98};
        selectionSort(arr);
        for (int i :
                arr) {
            System.out.print(i+" ");
        }
    }
}
