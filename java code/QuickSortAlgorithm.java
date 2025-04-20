public class QuickSortAlgorithm {
    static void swapArr(int[] arr,int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    static int partition(int[] arr,int srt,int end){
        int pivot=arr[srt];
        int count=0;
        for (int i=srt+1;i<=end;i++){
            if(arr[i]<=pivot) count++;
        }
        int pivotIdx=srt+count;
        swapArr(arr,srt,pivotIdx);
        int i=srt;
        int j=end;
        while (i<pivotIdx && j>pivotIdx){
            while (arr[i]<=pivot) i++;
            while (arr[j]>pivot) j--;
            if(i<pivotIdx && j>pivotIdx){
                swapArr(arr,i,j);
                i++;
                j--;
            }
        }
        return pivotIdx;
    }
    static void quickSort(int[] arr, int st, int end){
        if(st >= end) return;
        int pi = partition(arr, st, end);
        quickSort(arr, st, pi-1);
        quickSort(arr, pi+1, end);
    }
    public static void main(String[] args) {
        int []arr={5,2,7,8,3,4,2,1,0,7,6};
        quickSort(arr,0, arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
