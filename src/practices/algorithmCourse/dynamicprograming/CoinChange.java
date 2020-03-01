package practices.algorithmCourse.dynamicprograming;

/**
 * @Description:
 * 
 *               You are given coins of different denominations and a total
 *               amount of money amount. Write a function to compute the
 *               fewest number of coins that you need to make up that
 *               amount. If that amount of money cannot be made up by any
 *               combination of the coins, return -1.
 *
 *               Example 1:
 *
 *               Input: coins = [1, 2, 5], amount = 11
 *               Output: 3
 *               Explanation: 11 = 5 + 5 + 1
 *               Example 2:
 *
 *               Input: coins = [2], amount = 3
 *               Output: -1
 *               Note:
 *               You may assume that you have an infinite number of each
 *               kind of coin.
 * 
 *               有下面两种思路。
 * 
 *               两种动态规划的方法时间复杂度是一样的,但是自上而下的动态规划耗时42ms,自下而上的动态规划耗时15ms,
 *               明显比上一种方法快很多,可能是取之前的结果的时候,直接从dp[]里面取了,而不用多调用一层getNum()方法.
 * 
 * @Author: shenpeng
 * @Date: 2020-03-01
 */
public class CoinChange {

    //    ---------------------思路1：自上而下的动态规划---------------------
    //    
    //    已知我们有coins这些种类的硬币硬币,要组成amount的总值,我们转换成从coins里一个个取硬币,每一次都可以取不大于剩余amount
    //    的面额的硬币,还剩amount-coin需要取,如此递归,然后对每一层的递归结果取最小值,就是最终的最小数量了

    //    int[][] dp;
    //
    //    public int coinChange(int[] coins, int amount) {
    //        if (coins.length == 0) {
    //            return -1;
    //        }
    //        if (amount == 0) {
    //            return 0;
    //        }
    //        Arrays.sort(coins);
    //        dp = new int[coins.length][amount + 1];
    //        for (int i = 1; i <= amount; i++) {
    //            if (i % coins[0] == 0) {
    //                dp[0][i] = i / coins[0];
    //            } else {
    //                dp[0][i] = -1;
    //            }
    //        }
    //
    //        return getNums(coins, coins.length - 1, amount);
    //    }
    //
    //    public int getNums(int[] coins, int end, int amount) {
    //        if (amount <= 0) {
    //            return amount;
    //        }
    //        if (dp[end][amount] == 0) {
    //            int temp = Integer.MAX_VALUE;
    //            int num = amount / coins[end];
    //            if (amount % coins[end] == 0) {
    //                temp = num;
    //            } else {
    //
    //                for (int i = num; i >= 0; i--) {
    //                    int result = getNums(coins, end - 1, amount - coins[end] * i);
    //                    if (result < 0) {
    //                        continue;
    //                    } else {
    //                        result = result + i;
    //                        if (result < temp) {
    //                            temp = result;
    //                        }
    //                    }
    //                }
    //            }
    //            if (temp == Integer.MAX_VALUE) {
    //
    //                dp[end][amount] = -1;
    //            } else {
    //                dp[end][amount] = temp;
    //            }
    //        }
    //        return dp[end][amount];
    //    }

    //      ---------------------思路2：自下而上的动态规划---------------------
    //    
    //    可以看到,再上一步里面,我们要考虑所有的组成情况,然后拿来比较,那么,我们也可以计算amount从小到大的最优解,每一步的结果保存在dp[]中.这样,每一步都可以利用之前算出的结果了.还可以进行显式的递归,而不是隐式的递归了.
    //
    //    int dp[];
    //
    //    public int coinChange(int[] coins, int amount) {
    //        dp = new int[amount + 1];
    //        return getNum(coins, amount);
    //    }
    //
    //    public int getNum(int[] coins, int amount) {
    //        if (amount == 0) {
    //            return 0;
    //        }
    //        if (dp[amount] == 0) {
    //            int temp = Integer.MAX_VALUE;
    //            for (int coin : coins) {
    //                if (coin <= amount) {
    //                    int result = getNum(coins, amount - coin) + 1;
    //                    if (result > 0 && result < temp) {
    //                        temp = result;
    //                    }
    //                }
    //            }
    //            if (temp == Integer.MAX_VALUE) {
    //                dp[amount] = -1;
    //            } else {
    //                dp[amount] = temp;
    //            }
    //        }
    //        return dp[amount];
    //
    //    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int result = dp[i - coins[j]] + 1;
                    if (result > 0 && result < temp) {
                        temp = result;
                    }
                }
            }
            if (temp == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = temp;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 5 };
        int amount = 11;
        CoinChange coinChange = new CoinChange();

        System.out.println(coinChange.coinChange(coins, amount));
        //        for (int i : coinChange.dp) {
        //            System.out.println(i);
        //        }

    }
}
