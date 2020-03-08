package practices.algorithmCourse.sort;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-07
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[] { 6, 4, 3, 6, 3, 67, 4, 74, 53, 32, 4, 5, 75, 34, 23 };
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start;
        int r = end;
        int temp = array[l];
        while (l < r) {
            while (l < r && array[r] >= temp) {
                r--;
            }
            array[l] = array[r];
            while (l < r && array[l] <= temp) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = temp;
        quickSort(array, start, l - 1);
        quickSort(array, l + 1, end);
    }

}
