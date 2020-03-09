package main.practices.algorithmCourse.dynamicprograming;

/**
 * @Description:
 *               Given an unsorted array of integers, find the length of
 *               longest increasing subsequence.
 *
 *               Example:
 *
 *               Input: [10,9,2,5,3,7,101,18]
 *               Output: 4
 *               Explanation: The longest increasing subsequence is
 *               [2,3,7,101], therefore the length is 4.
 *               Note:
 *
 *               There may be more than one LIS combination, it is only
 *               necessary for you to return the length.
 *               Your algorithm should run in O(n2) complexity.
 *               Follow up: Could you improve it to O(n log n) time
 *               complexity?
 * 
 *               思路1：动态规划
 *               对于每一个nums中的第n+1个数,如果生序序列要包含当前的数，那么l等于加上前面的数中结尾是小于nums[n]的最大长度加一。
 *               可以用一个map来存之前以x为结尾的序列的长度，往后遍历。由于要遍历n次，每次还得遍历map找出l最大的并且小于nums[n]的x，
 *               所以时间复杂度O(n^2)
 * 
 *               思路2：动态规划加二分法
 *               上一种方法在找出合适的以x为结尾的序列长度x时，遍历了很多没必要的数据，比如(2，1,...)这种序列，前面的2是没必要保存的。
 *               我们可以保存用一个数组，保存长度为i时，最小尾数是多少。这样，对于后面的每个值，我们只需要用二分法找到，尾数小于nums[n]的最大的i
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-03-01
 */
public class LenOfLIS {

    //        public int lengthOfLIS(int[] nums) {
    //            Map<Integer, Integer> dp = new HashMap<>();
    //            int temp;
    //            int result = 0;
    //            for (int i = 0; i < nums.length; i++) {
    //                temp = 0;
    //                for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
    //                    if (entry.getKey() < nums[i]) {
    //                        temp = temp > entry.getValue() ? temp : entry.getValue();
    //                    }
    //                }
    //                dp.put(nums[i], temp);
    //                result = result > temp ? result : temp;
    //            }
    //            return result;
    //        }

    public int lengthOfLIS(int[] nums) {
        int[] helper = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = result, mid;
            while (left < right) {
                mid = (left + right) / 2;
                if (helper[mid] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            helper[left] = nums[i];
            if (left == result) {
                result++;
            }
        }
        return result;
    }

}
