package main.practices.algorithmCourse.string;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 *               Given a string, find the first non-repeating character in
 *               it and return it's index. If it doesn't exist, return -1.
 *
 *               Examples:
 *
 *               s = "leetcode"
 *               return 0.
 *
 *               s = "loveleetcode",
 *               return 2.
 *               Note: You may assume the string contain only lowercase
 *               letters.
 * @Author: shenpeng
 * @Date: 2020-02-25
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] cNum = new int[26];
        Set<Character> cPos = new LinkedHashSet<>();
        Map<Character, Integer> cIndex = new HashMap<>();
        int l = s.length();
        char c;
        for (int i = 0; i < l; i++) {
            c = s.charAt(i);
            cNum[c - 'a']++;
            if (!cPos.contains(c)) {
                cPos.add(c);
                cIndex.put(c, i);
            }
        }
        for (Character cP : cPos) {
            if (cNum[cP - 'a'] == 1) {
                return cIndex.get(cP);
            }
        }
        return -1;
    }
}
