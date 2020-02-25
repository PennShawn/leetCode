package practices.algorithmCourse.array;

/**
 * @Description:
 *               Given an integer array nums, find the contiguous subarray
 *               within an array (containing at least one number) which has
 *               the largest product.
 *
 *               Example 1:
 *
 *               Input: [2,3,-2,4]
 *               Output: 6
 *               Explanation: [2,3] has the largest product 6.
 *               Example 2:
 *
 *               Input: [-2,0,-1]
 *               Output: 0
 *               Explanation: The result cannot be 2, because [-2,-1] is
 *               not a subarray.
 * 
 *               思路1：一开始想着直接套动态规划，但是多了很多无用的计算，时间复杂度太高了
 *               思路2：从前向后遍历,对于每一个元素都有取或者不取两种选择,记录当前步骤的最大值,并且记下选取当前元素后的最大值和最小值防止后面出现变数.
 *               O(n)
 * @Author: shenpeng
 * @Date: 2020-02-25
 */
public class MaxProduct {

    //    public int maxProduct(int[] nums) {
    //        int l = nums.length;
    //        int[] dp = new int[l];
    //        int max = Integer.MIN_VALUE;
    //        for (int i = 0; i < l; i++) {
    //            dp[i] = nums[i];
    //            if (nums[i] > max) {
    //                max = nums[i];
    //            }
    //        }
    //        int cur;
    //        for (int i = 0; i < l; i++) {
    //            for (int j = 1; j < l - i; j++) {
    //                cur = dp[i] = dp[i] * nums[i + j];
    //                max = cur > max ? cur : max;
    //            }
    //        }
    //        return max;
    //    }

    public int maxProduct(int[] nums) {
        int l = nums.length;
        int max = nums[0];
        int min = nums[0];
        int preMax = nums[0];
        int temp;
        for (int i = 1; i < l; i++) {
            if (nums[i] > 0) {

                max = Math.max(nums[i] * max, nums[i]);
                min = Math.min(nums[i] * min, nums[i]);
            } else {
                temp = max;
                max = Math.max(nums[i] * min, nums[i]);
                min = Math.min(nums[i], nums[i] * temp);
            }
            preMax = Math.max(max, preMax);
        }
        return preMax;
    }

}
