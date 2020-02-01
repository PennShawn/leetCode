package practices.queuestack;

import java.util.Stack;

/**
 * @Description:
 * 
 *               Implement the following operations of a queue using
 *               stacks.
 *
 *               push(x) -- Push element x to the back of queue.
 *               pop() -- Removes the element from in front of queue.
 *               peek() -- Get the front element.
 *               empty() -- Return whether the queue is empty.
 *               Example:
 *
 *               MyQueue queue = new MyQueue();
 *
 *               queue.push(1);
 *               queue.push(2);
 *               queue.peek(); // returns 1
 *               queue.pop(); // returns 1
 *               queue.empty(); // returns false
 *               Notes:
 *
 *               You must use only standard operations of a stack -- which
 *               means only push to top, peek/pop from top, size, and is
 *               empty operations are valid.
 *               Depending on your language, stack may not be supported
 *               natively. You may simulate a stack by using a list or
 *               deque (double-ended queue), as long as you use only
 *               standard operations of a stack.
 *               You may assume that all operations are valid (for example,
 *               no pop or peek operations will be called on an empty
 *               queue).
 * 
 *               思路：我一开始的想法就是两个栈来回倒腾，时间复杂度O(n),空间复杂度O(n)
 * 
 *               官方题解提供了另一种思路：将整个数据分成两部分，往s1里入，从s2里出，用一个front字段保存中元素外，最先的元素。
 * 
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-02-01
 */
public class StackImplQueue {

}

class MyQueue {

    /**
     * 记录旧数据的stack,实际上数据存在outStack里，只有在push的时候用inStack坐下临时缓存
     */
    Stack<Integer> inStack = new Stack<>();

    /**
     * 获取数据时的stack
     */
    Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        outStack.push(x);
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return outStack.pop();
        //        inStack.clear();
        //        while (!outStack.empty()) {
        //            inStack.push(outStack.pop());
        //        }
    }

    /** Get the front element. */
    public int peek() {
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.isEmpty();
    }
}

class MyQueue2 {

    /**
     * 入队的stack
     */
    Stack<Integer> inStack = new Stack<>();

    /**
     * 出队的stack
     */
    Stack<Integer> outStack = new Stack<>();

    /**
     * 除outStack中元素外，最先的元素
     */
    int front;

    /** Initialize your data structure here. */
    public MyQueue2() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (inStack.isEmpty()) {
            front = x;
        }
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            return front;
        } else {
            return outStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outStack.isEmpty() && inStack.empty();
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
