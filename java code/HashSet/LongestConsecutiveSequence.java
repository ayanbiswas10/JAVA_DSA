import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(var i:nums) st.add(i);

        int maxSeq=0;
        for(var i:st){
            if(!st.contains(i-1)){
                int currNum=i;
                int currSeq=1;
                while(st.contains(currNum+1)){
                    currNum++;
                    currSeq++;
                }
                maxSeq=Math.max(maxSeq,currSeq);
            }
        }
        return maxSeq;
    }

    public static void main(String[] args) {
        int[] arr={100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));

    }
}
