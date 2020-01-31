package practices.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 *               Given a string containing just the characters '(', ')',
 *               '{', '}', '[' and ']', determine if the input string is
 *               valid.
 *
 *               An input string is valid if:
 *
 *               Open brackets must be closed by the same type of brackets.
 *               Open brackets must be closed in the correct order.
 *               Note that an empty string is also considered valid.
 * 
 *               Example 1:
 *
 *               Input: "()"
 *               Output: true
 *               Example 2:
 *
 *               Input: "()[]{}"
 *               Output: true
 *               Example 3:
 *
 *               Input: "(]"
 *               Output: false
 *               Example 4:
 *
 *               Input: "([)]"
 *               Output: false
 *               Example 5:
 *
 *               Input: "{[]}"
 *               Output: true
 * 
 * @Author: shenpeng
 * @Date: 2020-01-31
 */
public class ValidString {

    public boolean isValid(String s) {
        Map<String, Integer> bracketValues = new HashMap<>();
        bracketValues.put("(", 1);
        bracketValues.put("[", 2);
        bracketValues.put("{", 3);
        bracketValues.put(")", -1);
        bracketValues.put("]", -2);
        bracketValues.put("}", -3);

        char[] chars = s.toCharArray();
        Stack<String> charStack = new Stack<>();
        int l = chars.length;
        if (l == 0) {
            return true;
        }
        for (int i = 0; i < l; i++) {
            String curChar = String.valueOf(chars[i]);
            int curValue = bracketValues.get(curChar);
            if (curValue > 0) {
                charStack.push(curChar);
            } else {
                if (charStack.empty()) {
                    return false;
                }
                String lastChar = charStack.pop();
                if (bracketValues.get(lastChar) + curValue != 0) {
                    return false;
                }
            }
        }
        if (charStack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
