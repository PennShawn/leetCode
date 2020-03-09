package main.weeklycontest179;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-08
 */
public class GenerateTheString {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder("a");
        if (n == 1) {
            return sb.toString();
        }
        if (n % 2 == 0) {
            for (int i = 1; i < n; i++) {
                sb.append("b");
            }
        } else {
            for (int i = 1; i < n - 1; i++) {
                sb.append("b");
            }
            sb.append("c");
        }
        return sb.toString();
    }
}
