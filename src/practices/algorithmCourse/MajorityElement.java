package practices.algorithmCourse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *               Given an array of size n, find the majority element. The
 *               majority element is the element that appears more than ⌊
 *               n/2 ⌋ times.
 *
 *               You may assume that the array is non-empty and the
 *               majority element always exist in the array.
 *
 *               Example 1:
 *
 *               Input: [3,2,3]
 *               Output: 3
 *               Example 2:
 *
 *               Input: [2,2,1,1,1,2,2]
 *               Output: 2
 * 
 *               思路：
 *               1。 easy题，直接遍历，记下每个数出现的次数，次数大于n/2时，就是结果 21ms
 * 
 *               2。1980 年由 Boyer 和 Moore 两个人提出来的算法，英文是 Boyer-Moore Majority
 *               Vote Algorithm。
 *
 *               算法思想很简单，但第一个想出来的人是真的强。
 *
 *               我们假设这样一个场景，在一个游戏中，分了若干个队伍，有一个队伍的人数超过了半数。所有人的战力都相同，不同队伍的两个人遇到就是同归于尽，同一个队伍的人遇到当然互不伤害。
 *
 *               这样经过充分时间的游戏后，最后的结果是确定的，一定是超过半数的那个队伍留在了最后。
 *
 *               而对于这道题，我们只需要利用上边的思想，把数组的每个数都看做队伍编号，然后模拟游戏过程即可。
 *
 *               group 记录当前队伍的人数，count 记录当前队伍剩余的人数。如果当前队伍剩余人数为
 *               0，记录下次遇到的人的所在队伍号。
 *
 *               作者：windliang
 *               链接：https://leetcode-cn.com/problems/majority-element/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-2/
 *               来源：力扣（LeetCode）
 *               著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * @Author: shenpeng
 * @Date: 2020-02-18
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numTimes = new HashMap<>();
        int l = nums.length;
        int halfL = l / 2;
        int times;
        for (int i = 0; i < l; i++) {
            times = numTimes.getOrDefault(nums[i], 0) + 1;
            if (times > halfL) {
                return nums[i];
            } else {
                numTimes.put(nums[i], times);
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int count = 1;
        int group = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //当前队伍人数为零，记录现在遇到的人的队伍号
            if (count == 0) {
                count = 1;
                group = nums[i];
                continue;
            }
            //现在遇到的人和当前队伍同组，人数加 1
            if (nums[i] == group) {
                count++;
                //遇到了其他队伍的人，人数减 1
            } else {
                count--;
            }
        }
        return group;
    }
}
