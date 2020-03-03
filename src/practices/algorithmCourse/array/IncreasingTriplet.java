package practices.algorithmCourse.array;

/**
 * @Description:
 *               Given an unsorted array return whether an increasing
 *               subsequence of length 3 exists or not in the array.
 *
 *               Formally the function should:
 *
 *               Return true if there exists i, j, k
 *               such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤
 *               n-1 else return false.
 *               Note: Your algorithm should run in O(n) time complexity
 *               and O(1) space complexity.
 *
 *               Example 1:
 *
 *               Input: [1,2,3,4,5]
 *               Output: true
 *               Example 2:
 *
 *               Input: [5,4,3,2,1]
 *               Output: false
 * @Author: shenpeng
 * @Date: 2020-03-03
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > two) {
                return true;
            } else if (num > one) {
                two = num;
            } else {
                one = num;
            }
        }
        //        for (int i = 0; i < nums.length; i++) {
        //            if (nums[i] > two) {
        //                return true;
        //            } else if (nums[i] > one) {
        //                two = nums[i];
        //            } else if (nums[i] < one) {
        //                one = nums[i];
        //            }
        //        }
        return false;
    }
}
