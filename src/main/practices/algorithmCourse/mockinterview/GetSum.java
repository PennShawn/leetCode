package main.practices.algorithmCourse.mockinterview;

/**
 * @Description:
 *               Calculate the sum of two integers a and b, but you are not
 *               allowed to use the operator + and -.
 *
 *               Example 1:
 *
 *               Input: a = 1, b = 2
 *               Output: 3
 *               Example 2:
 *
 *               Input: a = -2, b = 3
 *               Output: 1
 * 
 *               思路：^ 和 & 和 <<
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class GetSum {

    public int getSum(int a, int b) {
        int res = a ^ b;
        int next = (a & b) << 1;
        while (next != 0) {
            int temp = (res & next) << 1;
            res = res ^ next;
            next = temp;
        }
        return res;
    }
}
