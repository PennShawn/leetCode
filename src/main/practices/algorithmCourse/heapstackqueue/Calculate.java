package main.practices.algorithmCourse.heapstackqueue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 *               Implement a basic calculator to evaluate a simple
 *               expression string.
 *
 *               The expression string contains only non-negative integers,
 *               +, -, *, / operators and empty spaces . The integer
 *               division should truncate toward zero.
 *
 *               Example 1:
 *
 *               Input: "3+2*2"
 *               Output: 7
 *               Example 2:
 *
 *               Input: " 3/2 "
 *               Output: 1
 *               Example 3:
 *
 *               Input: " 3+5 / 2 "
 *               Output: 5
 *               Note:
 *
 *               You may assume that the given expression is always valid.
 *               Do not use the eval built-in library function.
 * @Author: shenpeng
 * @Date: 2020-03-04
 */
public class Calculate {

    public int calculate(String s) {
        Set<Character> opChars = new HashSet<>();
        opChars.add('+');
        opChars.add('-');
        opChars.add('*');
        opChars.add('/');
        int first, second, third;
        char op1, op2;
        int start = 0;
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (start == i) {
                    start++;
                } else {
                    nums.add(Integer.valueOf(s.substring(start, i)));
                    start = i + 1;
                }
                continue;

            }

            if (opChars.contains(s.charAt(i))) {
                ops.add(s.charAt(i));
                if (start == i) {
                    start++;
                } else {

                    nums.add(Integer.valueOf(s.substring(start, i)));
                    start = i + 1;
                }
            }
        }
        int end = s.length();
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == ' ') {
                end--;
            } else {
                break;
            }
        }
        if (end > start) {
            nums.add(Integer.valueOf(s.substring(start, end)));
        }

        if (nums.size() == 1) {
            return nums.get(0);
        }
        if (nums.size() == 2) {
            return cal(nums.get(0), nums.get(1), ops.get(0));
        }
        first = nums.get(0);
        second = nums.get(1);
        third = nums.get(2);
        op1 = ops.get(0);
        op2 = ops.get(1);
        for (int i = 3; i < nums.size(); i++) {
            if (('*' == op2 || '/' == op2) && ('+' == op1 || '-' == op1)) {
                second = cal(second, third, op2);
                third = nums.get(i);
                op2 = ops.get(i - 1);
            } else {
                first = cal(first, second, op1);
                second = third;
                third = nums.get(i);
                op1 = op2;
                op2 = ops.get(i - 1);
            }
            System.out.println(first + "   " + op1 + "  " + second + "   " + op2 + "  " + third);
        }
        if (('*' == op2 || '/' == op2) && ('+' == op1 || '-' == op1)) {
            second = cal(second, third, op2);
            return cal(first, second, op1);
        } else {
            first = cal(first, second, op1);
            return cal(first, third, op2);
        }

    }

    private int cal(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s = "1*2+3*4";
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate(s));
    }
}
