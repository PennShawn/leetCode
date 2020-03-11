package main.practices.algorithmCourse.graph;

import java.util.*;

/**
 * @Description:
 *               There are a total of n courses you have to take, labeled
 *               from 0 to n-1.
 *
 *               Some courses may have prerequisites, for example to take
 *               course 0 you have to first take course 1, which is
 *               expressed as a pair: [0,1]
 *
 *               Given the total number of courses and a list of
 *               prerequisite pairs, is it possible for you to finish all
 *               courses?
 *
 *               Example 1:
 *
 *               Input: 2, [[1,0]]
 *               Output: true
 *               Explanation: There are a total of 2 courses to take.
 *               To take course 1 you should have finished course 0. So it
 *               is possible.
 *               Example 2:
 *
 *               Input: 2, [[1,0],[0,1]]
 *               Output: false
 *               Explanation: There are a total of 2 courses to take.
 *               To take course 1 you should have finished course 0, and to
 *               take course 0 you should
 *               also have finished course 1. So it is impossible.
 *               Note:
 *
 *               The input prerequisites is a graph represented by a list
 *               of edges, not adjacency matrices. Read more about how a
 *               graph is represented.
 *               You may assume that there are no duplicate edges in the
 *               input prerequisites.
 * @Author: shenpeng
 * @Date: 2020-03-11
 */
public class CoursesOne {

    class Node {

        Map<Integer, Node> next = new HashMap<>();

        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            Node node = nodes[prerequisites[i][0]];
            node.next.put(prerequisites[i][1], nodes[prerequisites[i][1]]);
        }

        Set<Integer> path;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }
            path = new HashSet<>();
            if (!check(nodes, i, path, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean check(Node[] nodes, int num, Set<Integer> path, Set<Integer> visited) {
        if (visited.contains(num)) {
            return true;
        }
        if (path.contains(num)) {
            return false;
        }
        path.add(num);
        Node node = nodes[num];
        for (Map.Entry<Integer, Node> entry : node.next.entrySet()) {
            if (check(nodes, entry.getKey(), path, visited)) {
                visited.add(entry.getKey());
            } else {
                return false;
            }
        }
        return true;
    }

}
