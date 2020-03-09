package main.practices.queuestack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 *               Implement the following operations of a stack using
 *               queues.
 *
 *               push(x) -- Push element x onto stack.
 *               pop() -- Removes the element on top of the stack.
 *               top() -- Get the top element.
 *               empty() -- Return whether the stack is empty.
 *               Example:
 *
 *               MyStack stack = new MyStack();
 *
 *               stack.push(1);
 *               stack.push(2);
 *               stack.top(); // returns 2
 *               stack.pop(); // returns 2
 *               stack.empty(); // returns false
 *               Notes:
 *
 *               You must use only standard operations of a queue -- which
 *               means only push to back, peek/pop from front, size, and is
 *               empty operations are valid.
 *               Depending on your language, queue may not be supported
 *               natively. You may simulate a queue by using a list or
 *               deque (double-ended queue), as long as you use only
 *               standard operations of a queue.
 *               You may assume that all operations are valid (for example,
 *               no pop or top operations will be called on an empty
 *               stack).
 * 
 *               思路：用两个queue，一个queue存当前的所有元素，在pop的时候把n-1个元素依次存到另一个queue里，返回最后一个元素，用一个front字段记录最旧的元素peek时用
 *               官方解答中，可以用一个queue实现，每当push元素的时候，将之前的元素push依次取出来到新元素的后面，这样这个队列始终是倒着的
 *               喵啊
 * 
 * @Author: shenpeng
 * @Date: 2020-02-01
 */
public class QueueImplStack {

}

class MyStack1 {

    Queue<Integer> queue1 = new LinkedList<>();

    Queue<Integer> queue2 = new LinkedList<>();

    int front;

    /** Initialize your data structure here. */
    public MyStack1() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        front = x;
        if (queue2.isEmpty()) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = 0;
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty()) {
                x = queue2.poll();
                if (queue2.isEmpty()) {
                    return x;
                } else {
                    queue1.add(x);
                    front = x;
                }
            }
        } else {
            while (!queue1.isEmpty()) {
                x = queue1.poll();
                if (queue1.isEmpty()) {
                    return x;
                } else {
                    queue2.add(x);
                    front = x;
                }
            }
        }
        return x;
    }

    /** Get the top element. */
    public int top() {
        return front;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty() && queue1.isEmpty();
    }
}

class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            //把新元素之前的元素取出来放到新元素后面，这样每次push之后得到的队列都是反的，其他操作都可以直接用
            queue.add(queue.poll());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
