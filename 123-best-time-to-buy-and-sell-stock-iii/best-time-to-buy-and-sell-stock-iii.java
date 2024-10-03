class Solution {
    int [][][] dp;
    public int maxProfit(int[] prices) {
        dp=new int [prices.length+1][2][3];
        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<=1;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0,1,prices,2);
    }
    // buy -> 0 i.e nope cant buy
    // buy -> 1 i.e yes can buy
    public int solve(int index,int buy,int[] prices,int cap){
        if(index==prices.length || cap ==0){
            return 0;
        }
        if(dp[index][buy][cap]!=-1){
            return dp[index][buy][cap];
        }
        if(buy==1){
            return dp[index][buy][cap]=Math.max(-prices[index]+solve(index+1,0,prices,cap),solve(index+1,1,prices,cap));
        }
        else{
            return dp[index][buy][cap]=Math.max(prices[index]+solve(index+1,1,prices,cap-1),solve(index+1,0,prices,cap));
        }
    }
}