class Solution {
    public int minSwaps(String s) {
        
        int balanced = 0, imbalance = 0;
        for(char c : s.toCharArray()){
            if(c=='['){
                balanced++;
            }else{
                balanced--;
            }

            if(balanced<0){
                imbalance++;
                balanced = 0;
            }
        }

        return (imbalance + 1) / 2;
    }
}