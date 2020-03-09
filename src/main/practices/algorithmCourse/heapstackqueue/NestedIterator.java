package main.practices.algorithmCourse.heapstackqueue;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-05
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 **/

class NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 1;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return new ArrayList<NestedInteger>();
    }
}

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new ArrayList<>();

    int cur = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = getIntegers(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur < list.size();
    }

    public List<Integer> getIntegers(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger obj : nestedList) {
            if (obj.isInteger()) {
                result.add(obj.getInteger());
            } else {
                result.addAll(getIntegers(obj.getList()));
            }
        }
        return result;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
