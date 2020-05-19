package main.com.dianhun;

/**
 * @Description:
 *               1. 三个同样的字母连在一起，去掉一个：比如 helllo -> hello
 *               2. 两对一样的字母（AABB型）连在一起，，去掉第二对的一个字母：比如 helloo -> hello
 *               3.
 *               上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *               输入例子1:
 *               helloo
 *               输出例子1:
 *               hello
 *               输入例子2:
 *               woooooooow
 *               输出例子2:
 *               Woow
 * @Author: shenpeng
 * @Date: 2020-04-25
 */
public class StringFilter {

    public static void main(String[] args) {
        StringFilter sf = new StringFilter();
        System.out.println(sf.check("helloo"));
        System.out.println(sf.check("woooooooow"));
    }

    public String check(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char pre = s.charAt(0);
        char cur;
        sb.append(pre);
        //当前元素的前面的元素的状态 1:A 2:AA 3:AAB
        int state = 1;
        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            if (cur == pre) {
                if (state == 1) {
                    sb.append(cur);
                    pre = cur;
                    state = 2;
                }
            } else {
                sb.append(cur);
                pre = cur;
                if (state == 2) {
                    state = 3;
                } else if (state == 3) {
                    state = 1;
                }
            }
        }
        return sb.toString();
    }
}
