package main.practices.algorithmCourse.mockinterview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *               Write a program that outputs the string representation of
 *               numbers from 1 to n.
 *
 *               But for multiples of three it should output “Fizz” instead
 *               of the number and for the multiples of five output “Buzz”.
 *               For numbers which are multiples of both three and five
 *               output “FizzBuzz”.
 *
 *               Example:
 *
 *               n = 15,
 *
 *               Return:
 *               [
 *               "1",
 *               "2",
 *               "Fizz",
 *               "4",
 *               "Buzz",
 *               "Fizz",
 *               "7",
 *               "8",
 *               "Fizz",
 *               "Buzz",
 *               "11",
 *               "Fizz",
 *               "13",
 *               "14",
 *               "FizzBuzz"
 *               ]
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s;
            if (i % 15 == 0) {
                s = "FizzBuzz";
            } else if (i % 3 == 0) {
                s = "Fizz";
            } else if (i % 5 == 0) {
                s = "Buzz";
            } else {
                s = String.valueOf(i);
            }
            result.add(s);
        }
        return result;
    }
}
