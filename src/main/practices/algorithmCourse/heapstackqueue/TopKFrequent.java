package main.practices.algorithmCourse.heapstackqueue;

import java.util.*;

/**
 * @Description:
 *               Given a non-empty array of integers, return the k most
 *               frequent elements.
 *
 *               Example 1:
 *
 *               Input: nums = [1,1,1,2,2,3], k = 2
 *               Output: [1,2]
 *               Example 2:
 *
 *               Input: nums = [1], k = 1
 *               Output: [1]
 *               Note:
 *
 *               You may assume k is always valid, 1 ≤ k ≤ number of unique
 *               elements.
 *               Your algorithm's time complexity must be better than O(n
 *               log n), where n is the array's size.
 *               思路：Map，PriorityQueue
 * @Author: shenpeng
 * @Date: 2020-03-04
 */
public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        Map<Integer, List<Integer>> countNums = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            List<Integer> list;
            if (countNums.containsKey(entry.getValue())) {
                countNums.get(entry.getValue()).add(entry.getKey());
            } else {
                list = new ArrayList<>();
                list.add(entry.getKey());
                countNums.put(entry.getValue(), list);
                maxHeap.offer(entry.getValue());
            }
        }
        List<Integer> result = new ArrayList<>();
        while (k > 0 && maxHeap.size() > 0) {
            int count = maxHeap.poll();
            for (Integer integer : countNums.get(count)) {
                result.add(integer);
                k--;
                if (k <= 0) {
                    break;
                }
            }
        }
        return result;
    }
}
