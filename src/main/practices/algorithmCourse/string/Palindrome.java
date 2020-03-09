package main.practices.algorithmCourse.string;

/**
 * @Description:
 *               Given a string, determine if it is a palindrome,
 *               considering only alphanumeric characters and ignoring
 *               cases.
 *
 *               Note: For the purpose of this problem, we define empty
 *               string as valid palindrome.
 *
 *               Example 1:
 *
 *               Input: "A man, a plan, a canal: Panama"
 *               Output: true
 *               Example 2:
 *
 *               Input: "race a car"
 *               Output: false
 * 
 * @Author: shenpeng
 * @Date: 2020-02-21
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if ((65 <= c && 90 >= c)) {
                sb.append((char) (c + 32));
            } else if ((97 <= c && 122 >= c) || (48 <= c && 57 >= c)) {
                sb.append(c);
            }
        }

        int halfL = sb.length() / 2;
        int end = sb.length() - 1;
        for (int i = 0; i < halfL; i++) {
            if (sb.charAt(i) != sb.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(0 + 'A');
        System.out.println(0 + 'a');
        System.out.println(0 + 'Z');
        System.out.println(0 + 'z');
        System.out.println(0 + ',');
        System.out.println(66 == 'B');
        StringBuffer sb = new StringBuffer();
        sb.append('a');
        sb.append(65);
        char a = 65;
        System.out.println(a);
        System.out.println(0 + '0');
        System.out.println(0 + '1');
        System.out.println(0 + '9');
        System.out.println(sb.toString());
        System.out.println(new Palindrome().isPalindrome("OP"));
    }
}
