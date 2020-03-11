package main.practices.algorithmCourse.sortandsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *               You are given an integer array nums and you have to return
 *               a new counts array. The counts array has the property
 *               where counts[i] is the number of smaller elements to the
 *               right of nums[i].
 *
 *               Example:
 *
 *               Input: [5,2,6,1]
 *               Output: [2,1,1,0]
 *               Explanation:
 *               To the right of 5 there are 2 smaller elements (2 and 1).
 *               To the right of 2 there is only 1 smaller element (1).
 *               To the right of 6 there is 1 smaller element (1).
 *               To the right of 1 there is 0 smaller element.
 * @Author: shenpeng
 * @Date: 2020-03-11
 */
public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(0, insertNum(sorted, nums[i]));
        }
        return result;
    }

    public int insertNum(List<Integer> sorted, int num) {
        int l = 0;
        int r = sorted.size() - 1;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (sorted.get(mid) >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        sorted.add(l, num);
        return l;
    }
}
