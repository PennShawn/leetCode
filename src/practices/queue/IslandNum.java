package practices.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Description:
 * 
 *               Given a 2d grid map of '1's (land) and '0's (water), count
 *               the number of islands. An island is surrounded by water
 *               and is formed by connecting adjacent lands horizontally or
 *               vertically. You may assume all four edges of the grid are
 *               all surrounded by water.
 *
 *               Example 1:
 *
 *               Input:
 *               11110
 *               11010
 *               11000
 *               00000
 *
 *               Output: 1
 *               Example 2:
 *
 *               Input:
 *               11000
 *               11000
 *               00100
 *               00011
 *
 *               Output: 3
 *               我的解法：1：遍历，用一个新的对象pos表示每个点，如果一个点的值是1，就递归判断他的上下左右4个临近点，如果遍历过则跳过。
 *               这种方法在算pos的hashCode的时候可能慢一点 40ms
 *               2：用字符串拼起坐标而不是用对象表示，结果更慢了 60ms
 *               参考答案的解法：遍历过的点设为0
 *               如果一个点是1递归遍历上下左右，如果是0直接返回，喵啊，不用单独记是否遍历过，直接取值，是0就返回，节省了很多时间和空间
 *
 * @Author: shenpeng
 * @Date: 2020-01-29
 */
public class IslandNum {

    public int numIslands(char[][] grid) {

        int num = 0;
        Set<String> usedPoses = new HashSet<>();
        Queue<String> posQueue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String curpos = i + "_" + j;
                if (usedPoses.contains(curpos)) {
                    continue;
                }
                if (grid[i][j] == 49) {
                    num++;
                    String newPox1 = i + 1 + "_" + j;
                    String newPox2 = i + "_" + (j + 1);
                    if (i > 0) {
                        String newPox3 = i - 1 + "_" + j;
                        addToQueueIfNotUsed(usedPoses, posQueue, newPox3);
                    }
                    if (j > 0) {
                        String newPox4 = i + "_" + (j - 1);
                        addToQueueIfNotUsed(usedPoses, posQueue, newPox4);
                    }
                    addToQueueIfNotUsed(usedPoses, posQueue, newPox1);
                    addToQueueIfNotUsed(usedPoses, posQueue, newPox2);
                }
                usedPoses.add(curpos);
                while (!posQueue.isEmpty()) {
                    String pos = ((LinkedList<String>) posQueue).pop();
                    if (usedPoses.contains(pos)) {
                        continue;
                    } else {
                        usedPoses.add(pos);
                    }

                    if (getPosValue(grid, pos) == 49) {
                        addToQueueIfNotUsed(usedPoses, posQueue, getsX(pos) + (getY(pos) + 1));
                        addToQueueIfNotUsed(usedPoses, posQueue, getX(pos) + 1 + getsY(pos));
                        int x = getX(pos);
                        if (x > 0) {
                            addToQueueIfNotUsed(usedPoses, posQueue, x - 1 + getsY(pos));
                        }

                        int y = getY(pos);
                        if (y > 0) {
                            addToQueueIfNotUsed(usedPoses, posQueue, getsX(pos) + (y - 1));
                        }
                    }
                }
            }
        }
        return num;
    }

    private void addToQueueIfNotUsed(Set<String> usesPos, Queue<String> queue, String pos) {
        if (!usesPos.contains(pos) && !queue.contains(pos)) {
            queue.add(pos);
        }
    }

    private int getPosValue(char[][] grid, String pos) {
        int x = Integer.valueOf(pos.substring(0, pos.indexOf("_")));
        int y = Integer.valueOf(pos.substring(pos.indexOf("_") + 1));
        if (grid.length <= x) {
            return 0;
        } else if (grid[x].length <= y) {
            return 0;
        } else {
            return grid[x][y];
        }
    }

    private int getX(String pos) {
        return Integer.valueOf(pos.substring(0, pos.indexOf("_")));
    }

    private int getY(String pos) {
        return Integer.valueOf(pos.substring(pos.indexOf("_") + 1));
    }

    private String getsX(String pos) {
        return pos.substring(0, pos.indexOf("_") + 1);
    }

    private String getsY(String pos) {
        return pos.substring(pos.indexOf("_"));
    }

    public static void main(String[] args) {
        int[][] array = new int[3][3];
        System.out.println(array.length);
        System.out.println(1 + 1 + "_" + 1);
        System.out.println(2);

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            if (1 != 2) {
                continue;
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        for (int i = 0; i < 10000000; i++) {
            if (1 == 1) {
                continue;
            }
        }
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);
    }

    public int numIslands3(char[][] grid) {
        int num = 0;
        int l1 = grid.length;
        if (l1 == 0) {
            return 0;
        }
        int l2 = grid[0].length;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(grid, i, j - 1, l1, l2);
                    bfs(grid, i, j + 1, l1, l2);
                    bfs(grid, i - 1, j, l1, l2);
                    bfs(grid, i + 1, j, l1, l2);
                }
            }
        }

        return num;
    }

    private void bfs(char[][] grid, int x, int y, int l1, int l2) {
        if (x < 0 || y < 0 || x >= l1 || y >= l2 || grid[x][y] != '1') {
            return;
        } else {
            grid[x][y] = '0';
            bfs(grid, x, y - 1, l1, l2);
            bfs(grid, x, y + 1, l1, l2);
            bfs(grid, x - 1, y, l1, l2);
            bfs(grid, x + 1, y, l1, l2);
        }
    }

}

//class Pos {
//
//    int x = -1, y = -1;
//
//    public Pos(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Pos pos = (Pos) o;
//        return x == pos.x && y == pos.y;
//    }
//}
