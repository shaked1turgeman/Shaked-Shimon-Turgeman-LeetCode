import java.util.Deque;
import java.util.ArrayDeque;
public class MyQueue {
    private Deque<Integer> A;
    private Deque<Integer> B;

    public MyQueue() {
        A = new ArrayDeque<>();
        B = new ArrayDeque<>();
    }
    
    public void push(int x) {
        A.push(x);
    }
    
    public int pop() {
        if(B.isEmpty()) moveIfNeeded();
        return B.pop();
    }
    
    public int peek() {
        if(B.isEmpty()) moveIfNeeded();
        return B.peek();
    }
    
    public boolean empty() {
        return (A.isEmpty() && B.isEmpty());
    }

    private void moveIfNeeded(){
        while(!A.isEmpty()) B.push(A.pop());
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
