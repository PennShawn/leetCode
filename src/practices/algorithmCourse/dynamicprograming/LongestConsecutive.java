package practices.algorithmCourse.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *               Given an unsorted array of integers, find the length of
 *               the longest consecutive elements sequence.
 *
 *               Your algorithm should run in O(n) complexity.
 *
 *               Example:
 *
 *               Input: [100, 4, 200, 1, 3, 2]
 *               Output: 4
 *               Explanation: The longest consecutive elements sequence is
 *               [1, 2, 3, 4]. Therefore its length is 4.
 * 
 *               思路：对于nums中每一个值,我们要知道包含它的序列长度,l(n)=1+l(n-1)+l(n+1),用一个hashMap来存储结果即可.
 *               每次更新只需要更新当前序列的边界,如已经保存了(3,4)(6,7)两个序列,又来了一个5,我们只需要把5加进去,然后更新3,7的value为5就行了,因为如果后面有3/4//5/6/7都不影响当前序列的长度,只有来2/8才会用到3/7的长度,所以只有边界的长度是需要更新的.
 *
 *               作者：pennshawn
 *               链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/yong-hashmapbao-cun-zhi-qian-de-jie-guo-onfu-za-du/
 *               来源：力扣（LeetCode）
 *               著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-02-27
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        Map<Integer, Integer> numLen = new HashMap<>();
        int curLen;
        int curNum;
        int result = 0;
        for (int i = 0; i < l; i++) {
            curNum = nums[i];
            if (numLen.containsKey(curNum)) {
                continue;
            }
            int left = numLen.getOrDefault(curNum - 1, 0);
            int right = numLen.getOrDefault(curNum + 1, 0);
            curLen = left + right + 1;
            if (curLen > result) {
                result = curLen;
            }
            numLen.put(curNum, curLen);

            numLen.put(curNum - left, curLen);
            numLen.put(curNum + right, curLen);
            //下面是没必要把左边序列和右边序列的每一个点都记为curLen的，因为下次有用的，只有最左边和最右边的两个点
            //            while (numLen.containsKey(++curNum)) {
            //                numLen.put(curNum, curLen);
            //            }
            //            curNum = nums[i];
            //            while (numLen.containsKey(--curNum)) {
            //                numLen.put(curNum, curLen);
            //            }

        }
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> numLen = new HashMap<>();
        numLen.put(2, 2);
        try {
            Integer integer = numLen.get(1);
            System.out.println(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
