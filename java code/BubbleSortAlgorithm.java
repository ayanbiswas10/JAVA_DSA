public class BubbleSortAlgorithm {
    static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void optimizeBubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag=true;
                }
            }
            if(!flag) return;
        }
    }

    public static void main(String[] args) {
        int[] arr={6,2,4,0,1,5,3};
        bubbleSort(arr);
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }
}
