package practices.algorithmCourse;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 *               Write an efficient algorithm that searches for a value in
 *               an m x n matrix. This matrix has the following properties:
 *
 *               Integers in each row are sorted in ascending from left to
 *               right.
 *               Integers in each column are sorted in ascending from top
 *               to bottom.
 *               Example:
 *
 *               Consider the following matrix:
 *
 *               [
 *               [1, 4, 7, 11, 15],
 *               [2, 5, 8, 12, 19],
 *               [3, 6, 9, 16, 22],
 *               [10, 13, 14, 17, 24],
 *               [18, 21, 23, 26, 30]
 *               ]
 *               Given target = 5, return true.
 *
 *               Given target = 20, return false.
 * @Author: shenpeng
 * @Date: 2020-02-19
 */
public class SearchMatrix {

    Set<Integer> visited = new HashSet<>();

    int step;

    int m, n;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        if (m == 0) {
            return false;
        } else {
            n = matrix[0].length;
            if (n == 0) {
                return false;
            } else {
                step = Math.max(m, n);
                return search(matrix, target, 0, 0);
            }
        }
    }

    public boolean search(int[][] matrix, int target, int x, int y) {
        if (x >= m || x < 0 || y >= n || y < 0) {
            return false;
        } else if (visited.contains(x * step + y)) {
            return false;
        } else {
            visited.add(x * step + y);
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                return search(matrix, target, x + 1, y) || search(matrix, target, x, y + 1);
            } else {
                return search(matrix, target, x - 1, y);
            }
        }
    }
}
