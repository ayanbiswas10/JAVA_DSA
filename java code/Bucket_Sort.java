import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {
    static void bucketSort(float[] arr){
        int n=arr.length;
        ArrayList<Float>[] bucket=new ArrayList[n];
        for(int i=0;i<n;i++){
            bucket[i]=new ArrayList<Float>();
        }
        for (int i=0;i<n;i++){
            int bucketIdx=(int) arr[i]*n;
            bucket[bucketIdx].add(arr[i]);
        }
        for (int i=0;i< bucket.length;i++){
            Collections.sort(bucket[i]);
        }
        int idx=0;
        for(int i=0;i< bucket.length;i++){
            ArrayList<Float> currBucket=bucket[i];
            for (int j=0;j<currBucket.size();j++){
                arr[idx]=currBucket.get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.5f, 0.4f, 0.3f, 0.2f, 0.1f};
        bucketSort(arr);
        for(float val : arr){
            System.out.print(val + " ");
        }
    }
}
