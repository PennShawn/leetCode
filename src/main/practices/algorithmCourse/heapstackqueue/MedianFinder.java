package main.practices.algorithmCourse.heapstackqueue;

import java.util.PriorityQueue;

/**
 * @Description:
 *               Median is the middle value in an ordered integer list. If
 *               the size of the list is even, there is no middle value. So
 *               the median is the mean of the two middle value.
 *
 *               For example,
 *               [2,3,4], the median is 3
 *
 *               [2,3], the median is (2 + 3) / 2 = 2.5
 *
 *               Design a data structure that supports the following two
 *               operations:
 *
 *               void addNum(int num) - Add a integer number from the data
 *               stream to the data structure.
 *               double findMedian() - Return the median of all elements so
 *               far.
 *
 *
 *               Example:
 *
 *               addNum(1)
 *               addNum(2)
 *               findMedian() -> 1.5
 *               addNum(3)
 *               findMedian() -> 2
 *
 *
 *               Follow up:
 *
 *               If all integer numbers from the stream are between 0 and
 *               100, how would you optimize it?
 *               If 99% of all integer numbers from the stream are between
 *               0 and 100, how would you optimize it?
 * 
 *               思路：大根堆、小根堆。
 * @Author: shenpeng
 * @Date: 2020-03-03
 */
public class MedianFinder {

    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;

    private PriorityQueue<Integer> maxheap;

    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
        }
    }
}
