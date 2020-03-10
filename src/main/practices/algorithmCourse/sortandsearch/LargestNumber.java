package main.practices.algorithmCourse.sortandsearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 *               Given a list of non negative integers, arrange them such
 *               that they form the largest number.
 *
 *               Example 1:
 *
 *               Input: [10,2]
 *               Output: "210"
 *               Example 2:
 *
 *               Input: [3,30,34,5,9]
 *               Output: "9534330"
 *               Note: The result may be very large, so you need to return
 *               a string instead of an integer.
 * @Author: shenpeng
 * @Date: 2020-03-10
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < numStrs.length; i++) {
            if (!flag) {
                if ("0".equals(numStrs[i])) {
                    continue;
                } else {
                    flag = true;
                }
            }
            sb.append(numStrs[i]);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
