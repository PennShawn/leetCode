package main.practices.algorithmCourse.array;

/**
 * @Description:
 *               Given an array nums of n integers where n > 1, return an
 *               array output such that output[i] is equal to the product
 *               of all the elements of nums except nums[i].
 *
 *               Example:
 *
 *               Input: [1,2,3,4]
 *               Output: [24,12,8,6]
 *               Note: Please solve it without division and in O(n).
 *
 *               Follow up:
 *               Could you solve it with constant space complexity? (The
 *               output array does not count as extra space for the purpose
 *               of space complexity analysis.)
 * @Author: shenpeng
 * @Date: 2020-03-03
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return new int[1];
        }
        int[] result1 = new int[nums.length];
        int[] result2 = new int[nums.length];
        result1[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result1[i] = result1[i - 1] * nums[i];
        }
        result2[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result2[i] = result2[i + 1] * nums[i];
        }
        int[] finResult = new int[nums.length];
        for (int i = 1; i < nums.length - 1; i++) {
            finResult[i] = result1[i - 1] * result2[i + 1];
        }
        finResult[0] = result2[1];
        finResult[nums.length - 1] = result1[nums.length - 2];
        return finResult;
    }
}
