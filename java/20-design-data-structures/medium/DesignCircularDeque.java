public class DesignCircularDeque {
    private int[] queue;
    private int front, rear, size;

    public MyCircularDeque(int k) {
        queue = new int[k];
        front=0;
        rear=0;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        queue[(front-1+queue.length)%queue.length] = value;
        front=(front-1+queue.length)%queue.length;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
        return true;

    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % queue.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear-1+queue.length)%queue.length;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size==0) return -1;
        return queue[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return queue[(rear-1+queue.length)%queue.length];
    }
    
    public boolean isEmpty() {return size==0;}
    
    public boolean isFull() {return size==queue.length;}
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
