package practices.algorithmCourse.heapstackqueue;

/**
 * @Description:
 *               Given an array nums, there is a sliding window of size k
 *               which is moving from the very left of the array to the
 *               very right. You can only see the k numbers in the window.
 *               Each time the sliding window moves right by one position.
 *               Return the max sliding window.
 *
 *               Example:
 *
 *               Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 *               Output: [3,3,5,5,6,7]
 *               Explanation:
 *
 *               Window position Max
 *               --------------- -----
 *               [1 3 -1] -3 5 3 6 7 3
 *               1 [3 -1 -3] 5 3 6 7 3
 *               1 3 [-1 -3 5] 3 6 7 5
 *               1 3 -1 [-3 5 3] 6 7 5
 *               1 3 -1 -3 [5 3 6] 7 6
 *               1 3 -1 -3 5 [3 6 7] 7
 *               Note:
 *               You may assume k is always valid, 1 ≤ k ≤ input array's
 *               size for non-empty array.
 *
 *               Follow up:
 *               Could you solve it in linear time?
 * 
 *               思路：这样dp其实还不如直接算，时间复杂度都是O(nk)...
 * 
 *               题解提供了一种巧妙的思路就是双向链表 时间复杂度O(n)
 * @Author: shenpeng
 * @Date: 2020-03-04
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        //        if (nums.length == 0) {
        //            return new int[0];
        //        }
        //        int[][] dp = new int[k][nums.length - k + 1];
        //        for (int i = 0; i < dp[0].length; i++) {
        //            dp[0][i] = nums[i];
        //        }
        //        for (int i = 1; i < k; i++) {
        //            for (int j = 0; j < dp[0].length; j++) {
        //                dp[i][j] = Math.max(dp[i - 1][j], nums[j + i]);
        //            }
        //        }
        //        return dp[k - 1];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                temp = Math.max(temp, nums[i + j]);
            }
            result[i] = temp;
        }
        return result;

    }
}
