package main.newcoder;

import java.util.Scanner;

/**
 * @Description:
 *               题目描述
 *               一条直线上等距离放置了n台路由器。路由器自左向右从1到n编号。第i台路由器到第j台路由器的距离为| i-j |。
 *               每台路由器都有自己的信号强度，第i台路由器的信号强度为ai。所有与第i台路由器距离不超过ai的路由器可以收到第i台路由器的信号（注意，每台路由器都能收到自己的信号）。问一共有多少台路由器可以收到至少k台不同路由器的信号。
 *               输入描述:
 *               输入第一行两个数n , k（1≤n , k≤10^5）
 *
 *               第二行n个数, a1 , a2 , a3……… , an（0≤ai≤10^9）
 *               输出描述:
 *               输出一个数，一共有多少台路由器可以收到至少k台不同路由器的信号。
 *               示例1
 *               输入
 *               复制
 *               4 4
 *               3 3 3 3
 *               输出
 *               复制
 *               4
 * 
 * 
 *               思路：
 *               首先得明白差分数组的概念。
 *               差分数组：对于数组[a1,a2,a3,a4...],其查分数组[a1,a2-a1,a3-a2,a4-a3...]。第i项的值等于查分数组前i项的和。
 * 
 *               这个概念有什么用呢？加入我们需要在[i,j)范围内都进行+1操作，对于原数组，可以遍历第i到j项都进行+1，但这样时间复杂度有点大。
 *               如果用了差分数组，就可以在第i项+1，第j+1项-1就行了。只需操作两个地方。
 * 
 *               对于这题，某一个路由器ax，其辐射的范围从i到j，我们如果遍历每个x，再从对应的i到j都+1操作，时间复杂度太大。那么就可以用差分数组。
 *               用一个数组dp[]表示第i个路由器能接受到多少个信号,都是从0开始,遍历路由器数组arr[],计算出每一个路由器辐射的范围,start到end,然后对差分数组进行dp[start]++,dp[end+1]--操作,即表示对结果数组从start到end进行+1操作.
 *               最后,累加遍历dp数组,就能得到每一个路由器能接收的到信号数.
 * 
 * @Author: shenpeng
 * @Date: 2020-06-07
 */
public class RouteDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //差分数组
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int start = i - arr[i];
            start = start > 0 ? start : 0;
            int end = i + arr[i];
            end = end < n ? end : n - 1;
            dp[start]++;
            dp[end + 1]--;
        }
        int result = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += dp[i];
            if (num >= k) {
                result++;
            }
        }
        System.out.println(result);

        //        int[] access = new int[n];
        //        for (int i = 0; i < n; i++) {
        //            int start = i - arr[i];
        //            start = start >= 0 ? start : 0;
        //            int end = i + arr[i];
        //            end = end >= n ? n - 1 : end;
        //            for (int j = start; j <= end; j++) {
        //                access[j]++;
        //            }
        //        }
        //        int result = 0;
        //        for (int i = 0; i < n; i++) {
        //            if (access[i] >= k) {
        //                System.out.println(result);
        //            }
        //        }
    }
}
