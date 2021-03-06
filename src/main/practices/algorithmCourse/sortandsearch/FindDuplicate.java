package main.practices.algorithmCourse.sortandsearch;

/**
 * @Description:
 *               Given an array nums containing n + 1 integers where each
 *               integer is between 1 and n (inclusive), prove that at
 *               least one duplicate number must exist. Assume that there
 *               is only one duplicate number, find the duplicate one.
 *
 *               Example 1:
 *
 *               Input: [1,3,4,2,2]
 *               Output: 2
 *               Example 2:
 *
 *               Input: [3,1,3,4,2]
 *               Output: 3
 *               Note:
 *
 *               You must not modify the array (assume the array is read
 *               only).
 *               You must use only constant, O(1) extra space.
 *               Your runtime complexity should be less than O(n2).
 *               There is only one duplicate number in the array, but it
 *               could be repeated more than once.
 * 
 *               思路：二分法牛逼 关键是在于找到要二分什么东西
 * @Author: shenpeng
 * @Date: 2020-03-10
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
