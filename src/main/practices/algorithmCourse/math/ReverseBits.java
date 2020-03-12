package main.practices.algorithmCourse.math;

/**
 * @Description:
 *               Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 *               Example 1:
 *
 *               Input: 00000010100101000001111010011100
 *               Output: 00111001011110000010100101000000
 *               Explanation: The input binary string
 *               00000010100101000001111010011100 represents the unsigned
 *               integer 43261596, so return 964176192 which its binary
 *               representation is 00111001011110000010100101000000.
 *               Example 2:
 *
 *               Input: 11111111111111111111111111111101
 *               Output: 10111111111111111111111111111111
 *               Explanation: The input binary string
 *               11111111111111111111111111111101 represents the unsigned
 *               integer 4294967293, so return 3221225471 which its binary
 *               representation is 10111111111111111111111111111111.
 *
 *
 *               Note:
 *
 *               Note that in some languages such as Java, there is no
 *               unsigned integer type. In this case, both input and output
 *               will be given as signed integer type and should not affect
 *               your implementation, as the internal binary representation
 *               of the integer is the same whether it is signed or
 *               unsigned.
 *               In Java, the compiler represents the signed integers using
 *               2's complement notation. Therefore, in Example 2 above the
 *               input represents the signed integer -3 and the output
 *               represents the signed integer -1073741825.
 *
 *
 *               Follow up:
 *
 *               If this function is called many times, how would you
 *               optimize it?
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
        }
        return res;
    }
    //    // you need treat n as an unsigned value
    //    public int reverseBits(int n) {
    //        if (n == Integer.MIN_VALUE) {
    //            return 1;
    //        }
    //
    //        boolean flag = true;
    //        if (n < 0) {
    //            n = -n;
    //            flag = false;
    //        }
    //        StringBuilder sb = new StringBuilder();
    //        while (n != 0) {
    //            int num = n % 2;
    //            sb.append(num);
    //            n = n / 2;
    //        }
    //        while (sb.length() < 31) {
    //            sb.append(0);
    //        }
    //        sb.append(flag ? 0 : 1);
    //        flag = sb.charAt(0) == '0';
    //        System.out.println(sb.toString());
    //        int result = 0;
    //        for (int i = 1; i < 32; i++) {
    //            int num = Integer.valueOf(sb.substring(i, i + 1));
    //            result = result * 2 + num;
    //        }
    //        System.out.println(result);
    //        if (flag) {
    //            return result;
    //        } else {
    //            long a = result;
    //            a = -a;
    //            result = (int) a;
    //            return result;
    //        }
    //    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        int a = 1;
        //        for (int i = 0; i < 31; i++) {
        //            a *= 2;
        //            System.out.println(a);
        //        }

        int result = 715827882;
        System.out.println(-result);
        System.out.println(reverseBits.reverseBits(-3));
    }
}
