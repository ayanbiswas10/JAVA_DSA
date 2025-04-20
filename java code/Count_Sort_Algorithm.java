public class Count_Sort_Algorithm {
    static int findMAX(int[] arr){
        int MAX=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>MAX) MAX=arr[i];
        }
        return MAX;
    }

    static void basicCountSort(int[] arr){
        int MAX=findMAX(arr);
        int[] count=new int[MAX+1];
        for (int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int k=0;
        for (int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                arr[k++]=i;
            }
        }
    }

    static void countSort(int[] arr){
        int[] output=new int[arr.length];
        int MAX=findMAX(arr);
        int[] count=new int[MAX+1];
        for (int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        for(int i=arr.length-1;i>=0;i--){
            int idx=count[arr[i]]-1;
            output[idx]=arr[i];
            count[arr[i]]--;
        }
        for (int i=0;i<arr.length;i++){
            arr[i]=output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr={3,2,6,3,4,1,1,7,0,9,4,6,8};
//        basicCountSort(arr);
        countSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
