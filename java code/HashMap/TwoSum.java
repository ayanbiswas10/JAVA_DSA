import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        //     int[] ans=new int[2];
        //    for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             ans[0]=i;
        //             ans[1]=j;
        //         }
        //     }
        //    }
        //    return ans;

        //Using HashMap for less time complexity
        int n=nums.length;
        int[] ans={-1};
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int partner=target-nums[i];
            if(mp.containsKey(partner)){
                ans=new int[]{i,mp.get(partner)};
                return ans;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []arr={2,7,11,15};
        int[] ans=twoSum(arr,9);
        for (
                var i:ans
        )
            System.out.println(i);
    }
}
