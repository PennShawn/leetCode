package main.weeklycontest179;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-08
 */
public class InfoTime {

    class Node {

        List<Integer> son;

        int min;

        public Node(int min) {
            this.min = min;
            son = new ArrayList<>();
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node node;
        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }
            if (nodeMap.containsKey(manager[i])) {
                node = nodeMap.get(manager[i]);
            } else {
                node = new Node(informTime[manager[i]]);
            }
            node.son.add(i);
            nodeMap.put(manager[i], node);
        }
        node = nodeMap.get(headID);
        return information(node, 0, nodeMap);
    }

    public int information(Node node, int usedTime, Map<Integer, Node> nodeMap) {
        if (node == null) {
            return usedTime;
        } else {
            int temp = 0;
            if (node.son.size() > 0) {
                usedTime += node.min;
            }
            for (Integer integer : node.son) {
                Node sonNode = nodeMap.get(integer);
                int result = information(sonNode, usedTime, nodeMap);
                if (result > temp) {
                    temp = result;
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        //n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
        int headID = 2, n = 6;
        int[] manager = new int[] { 2, 2, -1, 2, 2, 2 };
        int[] informTime = new int[] { 0, 0, 1, 0, 0, 0 };
        InfoTime infoTime = new InfoTime();
        System.out.println(infoTime.numOfMinutes(n, headID, manager, informTime));
    }
}
