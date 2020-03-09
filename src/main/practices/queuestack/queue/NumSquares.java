package main.practices.queuestack.queue;

/**
 * @Description:
 * 
 *               Given a positive integer n, find the least number of
 *               perfect square numbers (for example, 1, 4, 9, 16, ...)
 *               which sum to n.
 *
 *               Example 1:
 *
 *               Input: n = 12
 *               Output: 3
 *               Explanation: 12 = 4 + 4 + 4.
 *               Example 2:
 *
 *               Input: n = 13
 *               Output: 2
 *               Explanation: 13 = 4 + 9.
 *
 *               这题的解法思路是动态规划，计算出下一步的最优解，然后+1，就是这一步的最优解。
 *               如输入 12 这一步可以是 9/4/1，选9，那么计算12-9=3 ，3 的最优解+1 = 4就是这一步的最优解，
 *               同理，如果选4，那么8的最有解（2）+1 =3 就是选4的最有解
 *               最后得到n的最优解
 *               因为最终要先遍历1～n-1的所有情况，所以可以把他们的结果记录下来
 *               时间和内存：我一开始用map来记录，耗时500ms，但是用数组就只耗时35ms，内存消耗也少一些
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-01-31
 */
public class NumSquares {

    public int numSquares(int n) {
        //        Map<Integer, Integer> numResults = new HashMap<>();
        //        numResults.put(0, 0);

        int[] results = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            results[i] = i;
            //            numResults.put(i, i);
            numSquares(results, i);
        }
        //        return numResults.get(n);
        return results[n];
    }

    public int numSquares(int[] results, int n) {
        //        double pow = Math.pow(n, 0.5);
        //        if (Math.ceil(pow) == pow) {
        //            return 1;
        //        }
        for (int i = 1; n - i * i >= 0; i++) {
            //            numResults.put(n, Math.min(numResults.get(n), numResults.get(n - i * i) + 1));
            results[n] = Math.min(results[n - i * i] + 1, results[n]);
        }
        //        return numResults.get(n);
        return results[n];
    }

}
