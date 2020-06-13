package main.newcoder;

/**
 * @Description: 剪绳子
 *               给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记
 *               为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，
 *               我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *               输入描述:
 *               输入一个数n，意义见题面。（2 <= n <= 60）
 *               输出描述:
 *               输出答案。
 *               示例1
 *               输入
 *               复制
 *               8
 *               输出
 *               复制
 *               18
 * 
 * 
 * 
 *               思路:
 *               链接：https://www.nowcoder.com/questionTerminal/57d85990ba5b440ab888fc72b0751bf8?toCommentId=6307499
 *               来源：牛客网
 *
 *               数字敏感性问题,一根绳子可能被分成长度为x1,x2...的n段,最后的结果是x1*x2*...*xn;当长度x大于等于4时,
 *               很显然x被分成2和3组成的一组数比较大.至于3的优先级比2大随便找几个数试一下就可以看出来了,
 *               比如6分成3*3就比2*2*2好.所以最终的思路就是优先分成长度3,最后分成2.当然有种特殊情况就是
 *               4分成2*2比3*1要好，1是最没用的:(.
 *               注意题目说明最少分成两段.所以初始长度为2和3的时候也得分.
 * @Author: shenpeng
 * @Date: 2020-06-13
 */
public class CutRope {

    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        int times3 = target / 3;
        int last = target % 3;
        int result = 1;
        if (last == 0) {
            for (int i = 0; i < times3; i++) {
                result *= 3;
            }
        } else if (last == 1) {
            for (int i = 0; i < times3 - 1; i++) {
                result *= 3;
            }
            result *= 4;
        } else {
            for (int i = 0; i < times3; i++) {
                result *= 3;
            }
            result *= 2;
        }
        return result;
    }
}
