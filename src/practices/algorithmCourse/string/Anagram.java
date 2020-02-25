package practices.algorithmCourse.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 
 *               Given two strings s and t , write a function to determine
 *               if t is an anagram of s.
 *
 *               Example 1:
 *
 *               Input: s = "anagram", t = "nagaram"
 *               Output: true
 *               Example 2:
 *
 *               Input: s = "rat", t = "car"
 *               Output: false
 *               Note:
 *               You may assume the string contains only lowercase
 *               alphabets.
 *
 *               Follow up:
 *               What if the inputs contain unicode characters? How would
 *               you adapt your solution to such case?
 * 
 * @Author: shenpeng
 * @Date: 2020-02-25
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        //        int[] sNum = new int[26];
        //        int l1 = s.length();
        //        int l2 = t.length();
        //        if (l1 != l2) {
        //            return false;
        //        }
        //
        //        for (int i = 0; i < l1; i++) {
        //            sNum[s.charAt(i) - 'a']++;
        //        }
        //        //        int[] tNum = new int[26];
        //        for (int i = 0; i < l2; i++) {
        //            sNum[t.charAt(i) - 'a']--;
        //        }
        //        for (int i = 0; i < sNum.length; i++) {
        //            if (sNum[i] != 0) {
        //                return false;
        //            }
        //        }
        //        return true;

        Map<Character, Integer> map = new HashMap<>();
        int l1 = s.length();
        int l2 = t.length();
        if (l1 != l2) {
            return false;
        }
        for (int i = 0; i < l1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < l2; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
