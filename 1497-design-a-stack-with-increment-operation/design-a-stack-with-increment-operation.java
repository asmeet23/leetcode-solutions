class CustomStack {
    private int[] arr;
    private int maxSize;
    private int top;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.top = -1;

    }
    
    public void push(int x) {
        if (top < maxSize - 1) { // Check if the stack is not full
            top++;
            arr[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1; // Stack is empty
        }
        return arr[top--]; // Pop the top element
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, top + 1); i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */