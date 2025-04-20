public class Radix_Sort {
    static int findMAX(int[] arr){
        int MAX=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if (arr[i]>MAX) MAX=arr[i];
        }
        return MAX;
    }
    static void countSort(int[] arr,int place){
        int[] output=new int[arr.length];
        int[] count=new int[10];
        for(int i=0;i<arr.length;i++){
            count[(arr[i]/place)%10]++;
        }
        for (int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        for(int i=arr.length-1;i>=0;i--){
            int idx=count[(arr[i]/place)%10]-1;
            output[idx]=arr[i];
            count[(arr[i]/place)%10]--;
        }
        for(int i=0;i<output.length;i++){
            arr[i]=output[i];
        }
    }
    static void radixSort(int[] arr){
        int MAX=findMAX(arr);
        for(int place=1;MAX/place>0;place*=10){
            countSort(arr,place);
        }
    }

    public static void main(String[] args) {
        int[] arr={0,2,95,69,8,109,573,239,690,4,85};
        radixSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
