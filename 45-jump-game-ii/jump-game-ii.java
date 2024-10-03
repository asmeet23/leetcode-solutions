class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int current=0;
        int far=0;
        int jumped=0;
        if(n<=1){
            return 0;
        }
        for(int i=0;i<n;i++){
            far=Math.max(far,i+nums[i]);

            if(i==current){
                jumped++;
                current=far;
                if(current>=n-1){
                    break;
                    }
            }
            
        }
        return jumped;
    }
}