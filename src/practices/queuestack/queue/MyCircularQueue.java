package practices.queuestack.queue;

/**
 * @Description: 实现一个循环队列
 * 
 * @Author: shenpeng
 * @Date: 2020-01-28
 */
public class MyCircularQueue {

    int[] elements;

    /**
     * 头部结点的位置
     */
    int head = -1;

    /**
     * 尾结点的位置
     */
    int tail = -1;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        elements = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation
     * is successful.
     */
    public boolean enQueue(int value) {
        if (head == tail) {
            if (head == -1) {
                head = 0;
                tail = 0;
            } else {
                tail = (tail + 1) % elements.length;
            }
            elements[tail] = value;
            return true;
        } else {
            if (tail == (head + elements.length - 1) % elements.length) {
                return false;
            } else {
                tail = (tail + 1) % elements.length;
                elements[tail] = value;
                return true;
            }
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation
     * is successful.
     */
    public boolean deQueue() {
        int result;
        if (head == tail) {
            if (head == -1) {
                return false;
            } else {
                head = -1;
                tail = -1;
                return true;
            }
        } else {
            head = (head + 1) % elements.length;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return 0;
        }
        return elements[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return 0;
        }
        return elements[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail && head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (isEmpty()) {
            return false;
        }
        return (tail + 1) % elements.length == head;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        myCircularQueue.enQueue(6);
        myCircularQueue.Rear();
        myCircularQueue.Rear();
        myCircularQueue.deQueue();
        myCircularQueue.enQueue(5);
        myCircularQueue.Rear();
        myCircularQueue.deQueue();

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
