package practices.queuestack.stack;

import java.util.Stack;

/**
 * @Description:
 * 
 *               Given a list of daily temperatures T, return a list such
 *               that, for each day in the input, tells you how many days
 *               you would have to wait until a warmer temperature. If
 *               there is no future day for which this is possible, put 0
 *               instead.
 *
 *               For example, given the list of temperatures T = [73, 74,
 *               75, 71, 69, 72, 76, 73], your output should be [1, 1, 4,
 *               2, 1, 1, 0, 0].
 *
 *               Note: The length of temperatures will be in the range [1,
 *               30000]. Each temperature will be an integer in the range
 *               [30, 100].
 * 
 * @Author: shenpeng
 * @Date: 2020-01-31
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.push(temps[0]);
        //记录每个元素的位置，由于每次都是拿tempStack最新的元素和当前元素比较，如果当前元素大，说明找到了更高的温度，
        // 那么天数的差值就是当前的天数i - tempStack里最新元素的天数index.pop() 
        Stack<Integer> indexs = new Stack<>();
        indexs.push(0);
        int l = temps.length;
        int[] result = new int[l];
        for (int i = 1; i < l; i++) {
            while (!tempStack.empty() && tempStack.peek() < temps[i]) {
                tempStack.pop();
                int index = indexs.pop();
                result[index] = i - index;
            }
            tempStack.push(temps[i]);
            indexs.push(i);
        }
        return result;
    }
}
