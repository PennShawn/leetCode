package main.practices.algorithmCourse.heapstackqueue;

import java.util.PriorityQueue;

/**
 * @Description:
 *               Given a n x n matrix where each of the rows and columns
 *               are sorted in ascending order, find the kth smallest
 *               element in the matrix.
 *
 *               Note that it is the kth smallest element in the sorted
 *               order, not the kth distinct element.
 *
 *               Example:
 *
 *               matrix = [
 *               [ 1, 5, 9],
 *               [10, 11, 13],
 *               [12, 13, 15]
 *               ],
 *               k = 8,
 *
 *               return 13.
 *               Note:
 *               You may assume k is always valid, 1 ≤ k ≤ n2.
 * @Author: shenpeng
 * @Date: 2020-03-04
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int l0 = matrix.length;
        int l1 = Math.min(l0, k);
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l1 && i * j < k; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
