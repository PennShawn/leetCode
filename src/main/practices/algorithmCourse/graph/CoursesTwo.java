package main.practices.algorithmCourse.graph;

import java.util.*;

/**
 * @Description:
 * 
 *               There are a total of n courses you have to take, labeled
 *               from 0 to n-1.
 *
 *               Some courses may have prerequisites, for example to take
 *               course 0 you have to first take course 1, which is
 *               expressed as a pair: [0,1]
 *
 *               Given the total number of courses and a list of
 *               prerequisite pairs, return the ordering of courses you
 *               should take to finish all courses.
 *
 *               There may be multiple correct orders, you just need to
 *               return one of them. If it is impossible to finish all
 *               courses, return an empty array.
 *
 *               Example 1:
 *
 *               Input: 2, [[1,0]]
 *               Output: [0,1]
 *               Explanation: There are a total of 2 courses to take. To
 *               take course 1 you should have finished
 *               course 0. So the correct course order is [0,1] .
 *               Example 2:
 *
 *               Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 *               Output: [0,1,2,3] or [0,2,1,3]
 *               Explanation: There are a total of 4 courses to take. To
 *               take course 3 you should have finished both
 *               courses 1 and 2. Both courses 1 and 2 should be taken
 *               after you finished course 0.
 *               So one correct course order is [0,1,2,3]. Another correct
 *               ordering is [0,2,1,3] .
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
public class CoursesTwo {

    class Node {

        Map<Integer, Node> next = new HashMap<>();

        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> visited2 = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }
            path = new HashSet<>();
            if (!check(nodes, i, path, visited, visited2)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < visited2.size(); i++) {
            result[i] = visited2.get(i);
        }
        return result;
    }

    public boolean check(Node[] nodes, int num, Set<Integer> path, Set<Integer> visited,
            List<Integer> visited2) {
        System.out.println(visited2.toString());
        if (visited.contains(num)) {
            return true;
        }
        if (path.contains(num)) {
            return false;
        }

        path.add(num);
        Node node = nodes[num];

        if (node.next.size() == 0) {
            visited.add(num);
            visited2.add(num);
            return true;
        }
        for (Map.Entry<Integer, Node> entry : node.next.entrySet()) {
            if (check(nodes, entry.getKey(), path, visited, visited2)) {
                visited.add(entry.getKey());
            } else {
                return false;
            }
        }
        if (!visited.contains(num)) {
            visited.add(num);
            visited2.add(num);
        }

        return true;
    }

    public static void main(String[] args) {
        CoursesTwo coursesTwo = new CoursesTwo();
        int[][] pre = new int[][] { { 1, 0 }, { 2, 1 } };
        coursesTwo.findOrder(3, pre);
    }

}
