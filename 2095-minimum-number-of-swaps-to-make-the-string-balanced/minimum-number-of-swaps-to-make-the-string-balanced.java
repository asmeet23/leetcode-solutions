class Solution {
    public int minSwaps(String s) {
        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty() || stack.peek() == ']'){
                    stack.push(ch);
                }else{
                    stack.pop();
                }
            }
        }

        return (int)(((stack.size())/2+1)/2);
    }
}