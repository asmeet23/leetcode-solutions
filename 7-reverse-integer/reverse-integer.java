class Solution {
    public int reverse(int x) {
        long finalX = 0;

        while(x!=0){
            int lastDigit = x%10;
            finalX += lastDigit;
            finalX = 10*finalX;
            x = x/10;
        }
        finalX = finalX/10;
        if(finalX<Integer.MIN_VALUE||finalX>Integer.MAX_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*finalX);
        }
        return (int)finalX;
    }
}