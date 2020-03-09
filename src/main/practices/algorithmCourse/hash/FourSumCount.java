package main.practices.algorithmCourse.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *               Given four lists A, B, C, D of integer values, compute how
 *               many tuples (i, j, k, l) there are such that A[i] + B[j] +
 *               C[k] + D[l] is zero.
 *
 *               To make problem a bit easier, all A, B, C, D have same
 *               length of N where 0 ≤ N ≤ 500. All integers are in the
 *               range of -228 to 228 - 1 and the result is guaranteed to
 *               be at most 231 - 1.
 *
 *               Example:
 *
 *               Input:
 *               A = [ 1, 2]
 *               B = [-2,-1]
 *               C = [-1, 2]
 *               D = [ 0, 2]
 *
 *               Output:
 *               2
 *
 *               Explanation:
 *               The two tuples are:
 *               1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) +
 *               (-1) + 2 = 0
 *               2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) +
 *               (-1) + 0 = 0
 * @Author: shenpeng
 * @Date: 2020-03-06
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> aNums = new HashMap<>();
        Map<Integer, Integer> bNums = new HashMap<>();
        Map<Integer, Integer> cNums = new HashMap<>();
        Map<Integer, Integer> dNums = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            aNums.put(A[i], aNums.getOrDefault(A[i], 0) + 1);
            bNums.put(B[i], bNums.getOrDefault(B[i], 0) + 1);
            cNums.put(C[i], cNums.getOrDefault(C[i], 0) + 1);
            dNums.put(D[i], dNums.getOrDefault(D[i], 0) + 1);
        }
        Map<Integer, Integer> abNums = new HashMap<>();
        Map<Integer, Integer> cdNums = new HashMap<>();
        for (Map.Entry<Integer, Integer> aEntry : aNums.entrySet()) {
            for (Map.Entry<Integer, Integer> bEntry : bNums.entrySet()) {
                int sum = aEntry.getKey() + bEntry.getKey();
                abNums.put(sum,
                        aEntry.getValue() * bEntry.getValue() + abNums.getOrDefault(sum, 0));
            }
        }
        for (Map.Entry<Integer, Integer> cEntry : cNums.entrySet()) {
            for (Map.Entry<Integer, Integer> dEntry : dNums.entrySet()) {
                int sum = cEntry.getKey() + dEntry.getKey();
                cdNums.put(sum,
                        cEntry.getValue() * dEntry.getValue() + cdNums.getOrDefault(sum, 0));
            }
        }

        int result = 0;
        int cd;
        for (Map.Entry<Integer, Integer> abEntry : abNums.entrySet()) {
            cd = 0 - abEntry.getKey();
            if (cdNums.containsKey(cd)) {
                result += cdNums.get(cd) * abEntry.getValue();
            }
        }

        return result;
    }
}
