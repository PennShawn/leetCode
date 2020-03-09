package main.practices.algorithmCourse.hash;

/**
 * @Description:
 *               Given a column title as appear in an Excel sheet, return
 *               its corresponding column number.
 *
 *               For example:
 *
 *               A -> 1
 *               B -> 2
 *               C -> 3
 *               ...
 *               Z -> 26
 *               AA -> 27
 *               AB -> 28
 *               ...
 *               Example 1:
 *
 *               Input: "A"
 *               Output: 1
 *               Example 2:
 *
 *               Input: "AB"
 *               Output: 28
 *               Example 3:
 *
 *               Input: "ZY"
 *               Output: 701
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += (s.charAt(i) - 'A' + 1) * square(26, s.length() - i - 1);
        }
        return result;
    }

    private int square(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}
