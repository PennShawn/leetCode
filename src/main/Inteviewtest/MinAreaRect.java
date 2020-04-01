package main.Inteviewtest;

import java.util.*;

/**
 * @Description:
 *               Given a set of points in the xy-plane, determine the
 *               minimum area of a rectangle formed from these points, with
 *               sides parallel to the x and y axes.
 *
 *               If there isn't any rectangle, return 0.
 *
 *
 *
 *               Example 1:
 *
 *               Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 *               Output: 4
 *               Example 2:
 *
 *               Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 *               Output: 2
 *
 *
 *               Note:
 *
 *               1 <= points.length <= 500
 *               0 <= points[i][0] <= 40000
 *               0 <= points[i][1] <= 40000
 *               All points are distinct.
 * @Author: shenpeng
 * @Date: 2020-03-31
 */
public class MinAreaRect {

    public int minAreaRect(int[][] points) {
        int curResult = Integer.MAX_VALUE;

        Map<Integer, Set<Integer>> poses = new HashMap<>();
        Map<Integer, List<Integer>> poses2 = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (poses.containsKey(points[i][0])) {
                poses.get(points[i][0]).add(points[i][1]);
                poses2.get(points[i][0]).add(points[i][1]);
            } else {
                Set<Integer> posY = new HashSet<>();
                posY.add(points[i][1]);
                poses.put(points[i][0], posY);
                List<Integer> posY2 = new ArrayList<>();
                posY2.add(points[i][1]);
                poses2.put(points[i][0], posY2);
            }
        }

        for (Integer x : poses.keySet()) {
            if (poses.get(x).size() >= 2) {
                List<Integer> posYs = poses2.get(x);
                for (int i = 0; i < posYs.size(); i++) {
                    int y1 = posYs.get(i);
                    for (int j = i + 1; j < posYs.size(); j++) {
                        int y2 = posYs.get(j);
                        int yL = Math.abs(y2 - y1);
                        int maxXL = curResult / yL;
                        for (Integer x2 : poses.keySet()) {
                            if (x2.equals(x)) {
                                continue;
                            }
                            int xL = Math.abs(x2 - x);
                            if (xL > maxXL) {
                                continue;
                            }
                            Set<Integer> x2Ys = poses.get(x2);
                            if (x2Ys.contains(y1) && x2Ys.contains(y2)) {
                                curResult = xL * yL;
                                maxXL = curResult / yL;
                            }
                        }
                    }
                }
            }
        }
        if (curResult == Integer.MAX_VALUE) {
            curResult = 0;
        }
        return curResult;
    }
}
