package main.practices.algorithmCourse.mockinterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *               There are N gas stations along a circular route, where the
 *               amount of gas at station i is gas[i].
 *
 *               You have a car with an unlimited gas tank and it costs
 *               cost[i] of gas to travel from station i to its next
 *               station (i+1). You begin the journey with an empty tank at
 *               one of the gas stations.
 *
 *               Return the starting gas station's index if you can travel
 *               around the circuit once in the clockwise direction,
 *               otherwise return -1.
 *
 *               Note:
 *
 *               If there exists a solution, it is guaranteed to be unique.
 *               Both input arrays are non-empty and have the same length.
 *               Each element in the input arrays is a non-negative
 *               integer.
 *               Example 1:
 *
 *               Input:
 *               gas = [1,2,3,4,5]
 *               cost = [3,4,5,1,2]
 *
 *               Output: 3
 *
 *               Explanation:
 *               Start at station 3 (index 3) and fill up with 4 unit of
 *               gas. Your tank = 0 + 4 = 4
 *               Travel to station 4. Your tank = 4 - 1 + 5 = 8
 *               Travel to station 0. Your tank = 8 - 2 + 1 = 7
 *               Travel to station 1. Your tank = 7 - 3 + 2 = 6
 *               Travel to station 2. Your tank = 6 - 4 + 3 = 5
 *               Travel to station 3. The cost is 5. Your gas is just
 *               enough to travel back to station 3.
 *               Therefore, return 3 as the starting index.
 *               Example 2:
 *
 *               Input:
 *               gas = [2,3,4]
 *               cost = [3,4,3]
 *
 *               Output: -1
 *
 *               Explanation:
 *               You can't start at station 0 or 1, as there is not enough
 *               gas to travel to the next station.
 *               Let's start at station 2 and fill up with 4 unit of gas.
 *               Your tank = 0 + 4 = 4
 *               Travel to station 0. Your tank = 4 - 3 + 2 = 3
 *               Travel to station 1. Your tank = 3 - 3 + 3 = 3
 *               You cannot travel back to station 2, as it requires 4 unit
 *               of gas but you only have 3.
 *               Therefore, you can't travel around the circuit once no
 *               matter where you start.
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class GasStations {

    class Node {

        int index;

        int gas;

        int cost;

        Node next;

        public Node(int index, int gas, int cost) {
            this.index = index;
            this.gas = gas;
            this.cost = cost;
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node root = new Node(0, gas[0], cost[0]);
        nodeMap.put(0, root);
        Node preNode = root;
        for (int i = 1; i < gas.length; i++) {
            Node node = new Node(i, gas[i], cost[i]);
            nodeMap.put(i, node);
            preNode.next = node;
            preNode = node;
        }
        preNode.next = root;

        boolean[] circle = new boolean[1];
        int start = 0;
        while (!circle[0]) {
            int end = canCircuit(nodeMap.get(start), circle, gas.length);
            if (end == start) {
                return start;
            } else if (end == gas.length - 1) {
                return -1;
            } else {
                start = end + 1;
            }
        }
        return -1;
    }

    public int canCircuit(Node node, boolean[] circle, int l) {
        int begin = node.index;
        int curGas = node.gas - node.cost;
        while (curGas >= 0) {
            node = node.next;
            if (node.index == begin) {
                return begin;
            }
            if (node.index == l) {
                circle[0] = true;
            }
            curGas += node.gas - node.cost;
        }
        return node.index;
    }
}
