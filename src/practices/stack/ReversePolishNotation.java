package practices.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Description:
 * 
 *               逆波兰表达式:
 * 
 *               Evaluate the value of an arithmetic expression in Reverse
 *               Polish Notation.
 *
 *               Valid operators are +, -, *, /. Each operand may be an
 *               integer or another expression.
 *
 *               Note:
 *
 *               Division between two integers should truncate toward zero.
 *               The given RPN expression is always valid. That means the
 *               expression would always evaluate to a result and there
 *               won't be any divide by zero operation.
 *               Example 1:
 *
 *               Input: ["2", "1", "+", "3", "*"]
 *               Output: 9
 *               Explanation: ((2 + 1) * 3) = 9
 *               Example 2:
 *
 *               Input: ["4", "13", "5", "/", "+"]
 *               Output: 6
 *               Explanation: (4 + (13 / 5)) = 6
 *               Example 3:
 *
 *               Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*",
 *               "17", "+", "5", "+"]
 *               Output: 22
 *               Explanation:
 *               ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *               = ((10 * (6 / (12 * -11))) + 17) + 5
 *               = ((10 * (6 / -132)) + 17) + 5
 *               = ((10 * 0) + 17) + 5
 *               = (0 + 17) + 5
 *               = 17 + 5
 *               = 22
 * 
 * @Author: shenpeng
 * @Date: 2020-01-31
 */
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<String> opts = new HashSet<>();
        opts.add("+");
        opts.add("-");
        opts.add("*");
        opts.add("/");
        Stack<Integer> elements = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (opts.contains(tokens[i])) {
                switch (tokens[i]) {
                    case "+":
                        elements.push(elements.pop() + elements.pop());
                        break;
                    case "-":
                        elements.push(-1 * (elements.pop() - elements.pop()));
                        break;
                    case "*":
                        elements.push(elements.pop() * elements.pop());
                        break;
                    case "/":
                        int after = elements.pop();
                        int before = elements.pop();
                        elements.push(before / after);
                        break;
                    default:
                        break;
                }
            } else {
                elements.push(Integer.valueOf(tokens[i]));
            }
        }
        return elements.pop();
    }
}
