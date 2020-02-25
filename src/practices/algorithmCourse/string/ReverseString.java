package practices.algorithmCourse.string;

/**
 * @Description:
 *               Write a function that reverses a string. The input string
 *               is given as an array of characters char[].
 *
 *               Do not allocate extra space for another array, you must do
 *               this by modifying the input array in-place with O(1) extra
 *               memory.
 *
 *               You may assume all the characters consist of printable
 *               ascii characters.
 *
 *
 *
 *               Example 1:
 *
 *               Input: ["h","e","l","l","o"]
 *               Output: ["o","l","l","e","h"]
 *               Example 2:
 *
 *               Input: ["H","a","n","n","a","h"]
 *               Output: ["h","a","n","n","a","H"]
 * @Author: shenpeng
 * @Date: 2020-02-25
 */
public class ReverseString {

    public void reverseString(char[] s) {
        char c;
        int l = s.length;
        int halfL = l / 2;
        int l2 = l - 1;
        int endIndex;
        for (int i = 0; i < halfL; i++) {
            endIndex = l2 - i;
            c = s[endIndex];
            s[endIndex] = s[i];
            s[i] = c;
        }
    }
}
