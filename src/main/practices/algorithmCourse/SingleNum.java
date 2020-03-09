package main.practices.algorithmCourse;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 *               Given a non-empty array of integers, every element appears
 *               twice except for one. Find that single one.
 *
 *               Note:
 *
 *               Your algorithm should have a linear runtime complexity.
 *               Could you implement it without using extra memory?
 *
 *               Example 1:
 *
 *               Input: [2,2,1]
 *               Output: 1
 *               Example 2:
 *
 *               Input: [4,1,2,1,2]
 *               Output: 4
 *               思路：直接暴力遍历了，反正时间复杂度O(n).空间复杂度O(n) 13ms
 *               看见题解的大佬思路，用"抑或"的方法，a^b^a = b; 空间复杂度O(1)！ 1ms
 * 
 * @Author: shenpeng
 * @Date: 2020-02-16
 */
public class SingleNum {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();

        //        int ans = nums[0];
        //        if (nums.length > 1) {
        //            for (int i = 1; i < nums.length; i++) {
        //                ans = ans ^ nums[i];
        //            }
        //        }
        //        return ans;
    }
}
