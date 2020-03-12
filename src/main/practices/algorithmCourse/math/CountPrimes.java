package main.practices.algorithmCourse.math;

import java.util.Arrays;

/**
 * @Description:
 *               Count the number of prime numbers less than a non-negative
 *               number, n.
 *
 *               Example:
 *
 *               Input: 10
 *               Output: 4
 *               Explanation: There are 4 prime numbers less than 10, they
 *               are 2, 3, 5, 7.
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int[] result = new int[n];
        Arrays.fill(result, 1);
        double end = Math.pow(n, 0.5);
        for (int i = 2; i <= end; i++) {
            if (result[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    result[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += result[i];
        }
        return count;
    }

    //    public int countPrimes(int n) {
    //        List<Integer> primes = new ArrayList<>();
    //        if (n < 3) {
    //            return 0;
    //        }
    //        primes.add(2);
    //        for (int i = 3; i < n; i += 2) {
    //            if (isPrime(i, primes)) {
    //                primes.add(i);
    //            }
    //        }
    //        return primes.size();
    //    }
    //
    //    public boolean isPrime(int n, List<Integer> primes) {
    //        for (Integer prime : primes) {
    //            if (n % prime == 0) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(499979));
    }

}
