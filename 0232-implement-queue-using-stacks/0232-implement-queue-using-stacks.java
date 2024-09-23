class MyQueue {
    private static Stack<Integer> fStack;
    private static Stack<Integer> sStack;
    public MyQueue() {
        fStack = new Stack<>();
        sStack = new Stack<>();
    }
    
    public void push(int x) {
        while(!fStack.isEmpty()){
            sStack.add(fStack.pop());
        }
        fStack.add(x);
        while(!sStack.isEmpty()){
            fStack.add(sStack.pop());
        }
    }
    
    public int pop() {
        return fStack.pop();
    }
    
    public int peek() {
        return fStack.peek();
    }
    
    public boolean empty() {
        return fStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */