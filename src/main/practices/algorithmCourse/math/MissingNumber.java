package main.practices.algorithmCourse.math;

/**
 * @Description:
 *               Given an array containing n distinct numbers taken from 0,
 *               1, 2, ..., n, find the one that is missing from the array.
 *
 *               Example 1:
 *
 *               Input: [3,0,1]
 *               Output: 2
 *               Example 2:
 *
 *               Input: [9,6,4,2,3,5,7,0,1]
 *               Output: 8
 *               Note:
 *               Your algorithm should run in linear runtime complexity.
 *               Could you implement it using only constant extra space
 *               complexity?
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int numTotal = 0;
        int nTotal = nums.length;
        for (int i = 0; i < nums.length; i++) {
            numTotal += nums[i];
            nTotal += i;
        }
        return nTotal - numTotal;
    }
}
