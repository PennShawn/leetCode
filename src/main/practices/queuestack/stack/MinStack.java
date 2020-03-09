package main.practices.queuestack.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 
 *               Design a stack that supports push, pop, top, and
 *               retrieving the minimum element in constant time.
 *
 *               push(x) -- Push element x onto stack.
 *               pop() -- Removes the element on top of the stack.
 *               top() -- Get the top element.
 *               getMin() -- Retrieve the minimum element in the stack.
 *
 *
 *               Example:
 *
 *               MinStack minStack = new MinStack();
 *               minStack.push(-2);
 *               minStack.push(0);
 *               minStack.push(-3);
 *               minStack.getMin(); --> Returns -3.
 *               minStack.pop();
 *               minStack.top(); --> Returns 0.
 *               minStack.getMin(); --> Returns -2.
 * 
 * @Author: shenpeng
 * @Date: 2020-01-31
 */
public class MinStack {

    List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(0, x);
    }

    public void pop() {
        stack.remove(0);
    }

    public int top() {
        return stack.get(0);
    }

    public int getMin() {
        int num = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer < num) {
                num = integer;
            }
        }
        return num;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
