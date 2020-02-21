package practices.algorithmCourse;

/**
 * @Description:
 *               You are given K eggs, and you have access to a building
 *               with N floors from 1 to N.
 *
 *               Each egg is identical in function, and if an egg breaks,
 *               you cannot drop it again.
 *
 *               You know that there exists a floor F with 0 <= F <= N such
 *               that any egg dropped at a floor higher than F will break,
 *               and any egg dropped at or below floor F will not break.
 *
 *               Each move, you may take an egg (if you have an unbroken
 *               one) and drop it from any floor X (with 1 <= X <= N).
 *
 *               Your goal is to know with certainty what the value of F
 *               is.
 *
 *               What is the minimum number of moves that you need to know
 *               with certainty what F is, regardless of the initial value
 *               of F?
 *
 *
 *
 *               Example 1:
 *
 *               Input: K = 1, N = 2
 *               Output: 2
 *               Explanation:
 *               Drop the egg from floor 1. If it breaks, we know with
 *               certainty that F = 0.
 *               Otherwise, drop the egg from floor 2. If it breaks, we
 *               know with certainty that F = 1.
 *               If it didn't break, then we know with certainty F = 2.
 *               Hence, we needed 2 moves in the worst case to know what F
 *               is with certainty.
 * 
 *               Example 2:
 *
 *               Input: K = 2, N = 6
 *               Output: 3
 * 
 *               Example 3:
 *
 *               Input: K = 3, N = 14
 *               Output: 4
 *
 *
 *               Note:
 *
 *               1 <= K <= 100
 *               1 <= N <= 10000
 * 
 * @Author: shenpeng
 * @Date: 2020-02-20
 */
public class SuperEggDrop {

    //    static int[][] history;
    //
    //    static int n = 0;
    //
    //    public static int superEggDrop(int K, int N) {
    //        n++;
    //        //        if (K == 1) {
    //        //            return N;
    //        //        } else if (N <= 2) {
    //        //            return N;
    //        //        } else {
    //        if (history[K][N] != 0) {
    //            return history[K][N];
    //        }
    //        int nextSetp = Integer.MAX_VALUE;
    //        int temp = 0;
    //        for (int i = 2; i <= (N + 1) / 2; i++) {
    //            temp = Math.max(superEggDrop(K - 1, i - 1), superEggDrop(K, N - i));
    //            if (temp < nextSetp) {
    //                nextSetp = temp;
    //            }
    //        }
    //        history[K][N] = 1 + nextSetp;
    //        return 1 + nextSetp;
    //        //}
    //    }
    //
    //    public int superEggDrop2(int K, int N) {
    //        int[][] history = new int[K + 1][N + 1];
    //        for (int i = 1; i < history[1].length; i++) {
    //            history[1][i] = i;
    //        }
    //        for (int i = 1; i < history.length; i++) {
    //            history[i][1] = 1;
    //            history[i][2] = 2;
    //        }
    //        return superEggDrop(K, N);
    //    }
    //
    //    public static void main(String[] args) {
    //        history = new int[12][8178];
    //        for (int i = 1; i < history[1].length; i++) {
    //            history[i][i] = i;
    //        }
    //        for (int i = 1; i < history.length; i++) {
    //            history[i][1] = 1;
    //            history[i][2] = 2;
    //        }
    //        System.out.println(superEggDrop(11, 8177));
    //        System.out.println(n);
    //        //        for (int i = 0; i < history.length; i++) {
    //        //            for (int j = 0; j < history[i].length; j++) {
    //        //                System.out.print(history[i][j] + " ");
    //        //            }
    //        //            System.out.println(" ");
    //        //        }
    //    }

    int dp[][];

    public int superEggDrop(int K, int N) {
        dp = new int[K + 1][N + 1];
        for (int i = 1; i < dp[1].length; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = 1;
            if (N > 1) {
                dp[i][2] = 2;
            }

        }
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                int left = 1;
                int right = j;
                while (left + 1 < right) {
                    int mid = (left + right) / 2;
                    if (dp[i - 1][mid - 1] < dp[i][j - mid]) {
                        left = mid;
                    } else if (dp[i - 1][mid - 1] > dp[i][j - mid]) {
                        right = mid;
                    } else {
                        left = right = mid;
                    }
                }
                dp[i][j] = 1 + Math.min(Math.max(dp[i - 1][left - 1], dp[i][j - left]),
                        Math.max(dp[i - 1][right - 1], dp[i][j - right]));

            }
        }
        return dp[K][N];
    }

}
