package main.practices.algorithmCourse.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 *               Shuffle a set of numbers without duplicates.
 *
 *               Example:
 *
 *               // Init an array with set 1, 2, and 3.
 *               int[] nums = {1,2,3};
 *               Solution solution = new Solution(nums);
 *
 *               // Shuffle the array [1,2,3] and return its result. Any
 *               permutation of [1,2,3] must equally likely to be returned.
 *               solution.shuffle();
 *
 *               // Resets the array back to its original configuration
 *               [1,2,3].
 *               solution.reset();
 *
 *               // Returns the random shuffling of array [1,2,3].
 *               solution.shuffle();
 * @Author: shenpeng
 * @Date: 2020-03-03
 */
public class Solution {

    int[] nums;

    int[] originNums;

    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.originNums = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (originNums.length == 0) {
            return originNums;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < originNums.length; i++) {
            list.add(originNums[i]);
        }
        for (int i = originNums.length - 1; i > 0; i--) {
            int pos = random.nextInt(i + 1);
            nums[i] = list.remove(pos);
        }
        nums[0] = list.get(0);
        return nums;
    }
}
