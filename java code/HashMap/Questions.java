import java.util.HashMap;
import java.util.Map;

public class Questions {
    static int mostFrqEle(int[] arr){
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }
            else {
                mp.put(arr[i],1);
            }
        }
        int maxFreq=-1;
        int ans=-1;
//        for(var e:mp.keySet()){
//            if(mp.get(e)>maxFreq) {
//                maxFreq=mp.get(e);
//                ans=e;
//            }
//        }
        for(var e: mp.entrySet()){
            if(e.getValue()>maxFreq){
                maxFreq=e.getValue();
                ans=e.getKey();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,3,2,1,4,1};
        System.out.println(mostFrqEle(arr));
    }
}
