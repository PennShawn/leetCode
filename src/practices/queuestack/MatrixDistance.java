package practices.queuestack;

/**
 * @Description:
 * 
 *               Given a matrix consists of 0 and 1, find the distance of
 *               the nearest 0 for each cell.
 *
 *               The distance between two adjacent cells is 1.
 *
 *
 *
 *               Example 1:
 *
 *               Input:
 *               [[0,0,0],
 *               [0,1,0],
 *               [0,0,0]]
 *
 *               Output:
 *               [[0,0,0],
 *               [0,1,0],
 *               [0,0,0]]
 *               Example 2:
 *
 *               Input:
 *               [[0,0,0],
 *               [0,1,0],
 *               [1,1,1]]
 *
 *               Output:
 *               [[0,0,0],
 *               [0,1,0],
 *               [1,2,1]]
 *
 *
 *               Note:
 *
 *               The number of elements of the given matrix will not exceed
 *               10,000.
 *               There are at least one 0 in the given matrix.
 *               The cells are adjacent in only four directions: up, down,
 *               left and right.
 * 
 *               思路：一开始想的是，从0开始向四周扩散，最多扩散l1+l2次就可以，耗时792ms
 *               后来看了题解，没必要遍历这么多次，每次遍历有很多元素都是直接跳过的，太费了，
 *               只需要从左上往右下遍历一次，再从右下往左上遍历一次就行了。耗时13ms
 * 
 * @Author: shenpeng
 * @Date: 2020-02-03
 */
public class MatrixDistance {

    public int[][] updateMatrix(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;
        int max = Integer.MAX_VALUE - l1 - l2;
        // int l, r, u, d;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = max;
                }
            }
        }

        //        //从0开始向四周扩散，最多扩散l1+l2次就可以
        //        for (int m = 0; m < l1 + l2; m++) {
        //            int n = m + 1;
        //            for (int i = 0; i < l1; i++) {
        //                for (int j = 0; j < l2; j++) {
        //                    if (matrix[i][j] == m) {
        //
        //                        if (j > 0) {
        //                            matrix[i][j - 1] = Math.min(n, matrix[i][j - 1]);
        //                        }
        //                        if (j < l2 - 1) {
        //                            matrix[i][j + 1] = Math.min(n, matrix[i][j + 1]);
        //                        }
        //                        if (i > 0) {
        //                            matrix[i - 1][j] = Math.min(n, matrix[i - 1][j]);
        //                        }
        //                        if (i < l1 - 1) {
        //                            matrix[i + 1][j] = Math.min(n, matrix[i + 1][j]);
        //                        }
        //                    }
        //                }
        //            }
        //        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (j < l2 - 1) {
                    matrix[i][j + 1] = Math.min(matrix[i][j] + 1, matrix[i][j + 1]);
                }
                if (i < l1 - 1) {
                    matrix[i + 1][j] = Math.min(matrix[i][j] + 1, matrix[i + 1][j]);
                }

            }
        }

        for (int i = l2 - 1; i >= 0; i--) {
            for (int j = l1 - 1; j >= 0; j--) {
                if (j > 0) {
                    matrix[i][j - 1] = Math.min(matrix[i][j] + 1, matrix[i][j - 1]);
                }
                if (i > 0) {
                    matrix[i - 1][j] = Math.min(matrix[i][j] + 1, matrix[i - 1][j]);
                }
            }
        }
        return matrix;
    }
}
