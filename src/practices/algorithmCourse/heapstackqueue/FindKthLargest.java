package practices.algorithmCourse.heapstackqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 *               Find the kth largest element in an unsorted array. Note
 *               that it is the kth largest element in the sorted order,
 *               not the kth distinct element.
 *
 *               Example 1:
 *
 *               Input: [3,2,1,5,6,4] and k = 2
 *               Output: 5
 *               Example 2:
 *
 *               Input: [3,2,3,1,2,4,5,5,6] and k = 4
 *               Output: 4
 *               Note:
 *               You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 *               思路：
 *               寻找第K大的数,也就是说只有最大的K个数是有价值的,所以,构建一个大小为K的有序数列,每次有新元素加入时,
 *               删除对小的哪个,遍历一遍之后,最小的元素就是第K大的了.
 *               自己用2分插入法构建了一个序列,看了题解才知道原来可以直接用大根堆......
 * @Author: shenpeng
 * @Date: 2020-03-03
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (list.size() >= k) {
                break;
            }
            insert(list, nums[i]);
            index = i + 1;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > list.get(0)) {
                list.remove(0);
                insert(list, nums[i]);
            }
        }
        return list.get(0);

    }

    public void insert(List<Integer> list, int num) {
        int left = 0;
        int right = list.size();
        int mid;
        while (right > left) {
            mid = (left + right) / 2;
            if (list.get(mid) > num) {
                right = mid;
            } else if (list.get(mid) == num) {
                left = mid;
                break;
            } else {
                left = mid + 1;
            }
        }
        list.add(left, num);
    }
}
