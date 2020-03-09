package main.weeklycontest179;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-08
 */
public class FrogJump {

    public double frogPosition(int n, int[][] edges, int t, int target) {

        int[] sonNums = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean leaf = true;
        for (int i = 0; i < edges.length; i++) {

            if (edges[i][0] > edges[i][1]) {
                sonNums[edges[i][1]]++;
                parent[edges[i][0]] = edges[i][1];
                if (edges[i][1] == target) {
                    leaf = false;
                }
            } else {
                sonNums[edges[i][0]]++;
                parent[edges[i][1]] = edges[i][0];
                if (edges[i][0] == target) {
                    leaf = false;
                }
            }

        }
        List<Integer> path = new ArrayList<>();
        while (target != 1) {
            path.add(parent[target]);
            target = parent[target];
        }

        if (path.size() == t || (path.size() < t && leaf)) {
            double rate = 1.0;
            for (Integer pos : path) {
                rate /= sonNums[pos];
            }
            return rate;
        } else {
            return 0;
        }

    }
}
