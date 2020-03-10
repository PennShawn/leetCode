package main.practices.algorithmCourse.sortandsearch;

/**
 * @Description:
 *               Given an unsorted array nums, reorder it such that nums[0]
 *               < nums[1] > nums[2] < nums[3]....
 *
 *               Example 1:
 *
 *               Input: nums = [1, 5, 1, 1, 6, 4]
 *               Output: One possible answer is [1, 4, 1, 5, 1, 6].
 *               Example 2:
 *
 *               Input: nums = [1, 3, 2, 2, 3, 1]
 *               Output: One possible answer is [2, 3, 1, 3, 1, 2].
 *               Note:
 *               You may assume all input has valid answer.
 *
 *               Follow Up:
 *               Can you do it in O(n) time and/or in-place with O(1) extra
 *               space?
 * @Author: shenpeng
 * @Date: 2020-03-10
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int halfL = (nums.length + 1) / 2;
        int[] small = new int[halfL];
        for (int i = 0; i < halfL; i++) {
            small[i] = nums[i];
        }
        int[] big = new int[nums.length - halfL];
        for (int i = 0; i < big.length; i++) {
            big[i] = nums[i + halfL];
        }
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag) {
                nums[i] = small[small.length - 1 - i / 2];
            } else {
                nums[i] = big[big.length - 1 - i / 2];
            }
            flag = !flag;
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start + 1;
        int r = end;
        int temp = nums[start];
        while (r >= l) {
            while (l <= r && nums[l] <= temp) {
                l++;
            }
            while (r >= l && nums[r] >= temp) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, start, l - 1);
        quickSort(nums, start, l - 2);
        quickSort(nums, l, end);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 4, 5, 2, 3, 2, 1 };
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
