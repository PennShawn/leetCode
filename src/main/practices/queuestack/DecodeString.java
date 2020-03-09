package main.practices.queuestack;

/**
 * @Description:
 *               Given an encoded string, return its decoded string.
 *
 *               The encoding rule is: k[encoded_string], where the
 *               encoded_string inside the square brackets is being
 *               repeated exactly k times. Note that k is guaranteed to be
 *               a positive integer.
 *
 *               You may assume that the input string is always valid; No
 *               extra white spaces, square brackets are well-formed, etc.
 *
 *               Furthermore, you may assume that the original data does
 *               not contain any digits and that digits are only for those
 *               repeat numbers, k. For example, there won't be input like
 *               3a or 2[4].
 *
 *               Examples:
 *
 *               s = "3[a]2[bc]", return "aaabcbc".
 *               s = "3[a2[c]]", return "accaccacc".
 *               s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * 
 * @Author: shenpeng
 * @Date: 2020-02-01
 */
public class DecodeString {

    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        return String.valueOf(decode(s, 1, chars, 0, chars.length));
    }

    private StringBuffer decode(String s, int repeatTimes, char[] chars, int start, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i < end; i++) {
            if (Integer.valueOf(chars[i]) > 57) {
                sb.append(chars[i]);
            } else {
                int numEndIndex = s.indexOf("[", i);
                int times = Integer.parseInt(s.substring(i, numEndIndex));
                int bracketEndIndex = findCloseIndex(chars, numEndIndex + 1);
                sb.append(decode(s, times, chars, numEndIndex + 1, bracketEndIndex));
                i = bracketEndIndex;
            }
        }
        StringBuffer sbTemp = new StringBuffer(sb);
        for (int i = 1; i < repeatTimes; i++) {
            sb.append(sbTemp);
        }
        return sb;
    }

    private int findCloseIndex(char[] chars, int begin) {
        int left = 0;
        for (int i = begin; i < chars.length; i++) {
            if (chars[i] == ']') {
                if (left == 0) {
                    return i;
                } else {
                    left--;
                }
            }
            if (chars[i] == '[') {
                left++;
            }
        }
        return 0;
    }
}
