package main.practices.algorithmCourse.string;

/**
 * @Description:
 *               The string "PAYPALISHIRING" is written in a zigzag pattern
 *               on a given number of rows like this: (you may want to
 *               display this pattern in a fixed font for better
 *               legibility)
 *
 *               P A H N
 *               A P L S I I G
 *               Y I R
 *               And then read line by line: "PAHNAPLSIIGYIR"
 *
 *               Write the code that will take a string and make this
 *               conversion given a number of rows:
 *
 *               string convert(string s, int numRows);
 *               Example 1:
 *
 *               Input: s = "PAYPALISHIRING", numRows = 3
 *               Output: "PAHNAPLSIIGYIR"
 *               Example 2:
 *
 *               Input: s = "PAYPALISHIRING", numRows = 4
 *               Output: "PINALSIGYAHRPI"
 *               Explanation:
 *
 *               P I N
 *               A L S I G
 *               Y A H R
 *               P I
 *
 *               来源：力扣（LeetCode）
 *               链接：https://leetcode-cn.com/problems/zigzag-conversion
 *               著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: shenpeng
 * @Date: 2020-04-07
 */
public class ZigTagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int step = 0;; step += 2) {
            index = step * numRows - step;
            if (index < s.length()) {
                sb.append(s.charAt(index));
            } else {
                break;
            }
        }
        for (int i = 1; i < numRows - 1; i++) {
            int step = 0;
            index = step * numRows - step + i;
            if (index < s.length()) {
                sb.append(index);
            }
            while (true) {
                step += 2;
                index = step * numRows - step - i;
                if (index >= s.length()) {
                    break;
                } else {
                    sb.append(index);
                }
                index = step * numRows - step + i;
                if (index >= s.length()) {
                    break;
                } else {
                    sb.append(index);
                }
            }
        }
        for (int step = 1;; step += 2) {
            index = step * numRows - step;
            if (index < s.length()) {
                sb.append(s.charAt(index));
            } else {
                break;
            }
        }
        return s;
    }
}
