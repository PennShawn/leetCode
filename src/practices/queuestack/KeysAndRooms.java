package practices.queuestack;

import java.util.*;

/**
 * @Description:
 * 
 *               There are N rooms and you start in room 0. Each room has a
 *               distinct number in 0, 1, 2, ..., N-1, and each room may
 *               have some keys to access the next room.
 *
 *               Formally, each room i has a list of keys rooms[i], and
 *               each key rooms[i][j] is an integer in [0, 1, ..., N-1]
 *               where N = rooms.length. A key rooms[i][j] = v opens the
 *               room with number v.
 *
 *               Initially, all the rooms start locked (except for room 0).
 *
 *               You can walk back and forth between rooms freely.
 *
 *               Return true if and only if you can enter every room.
 *
 *               Example 1:
 *
 *               Input: [[1],[2],[3],[]]
 *               Output: true
 *               Explanation:
 *               We start in room 0, and pick up key 1.
 *               We then go to room 1, and pick up key 2.
 *               We then go to room 2, and pick up key 3.
 *               We then go to room 3. Since we were able to go to every
 *               room, we return true.
 *               Example 2:
 *
 *               Input: [[1,3],[3,0,1],[2],[0]]
 *               Output: false
 *               Explanation: We can't enter the room with number 2.
 *               Note:
 *
 *               1 <= rooms.length <= 1000
 *               0 <= rooms[i].length <= 1000
 *               The number of keys in all rooms combined is at most 3000.
 * 
 * 
 * 
 *               思路：可以用队列或者栈来存钥匙，用数组记录房间开启状态。4ms
 *               也可以用递归的方法不存钥匙，有钥匙就开门拿钥匙。1ms
 *               递归消耗的内存会大一点
 * 
 * @Author: shenpeng
 * @Date: 2020-02-15
 */
public class KeysAndRooms {

    boolean[] visitedRooms;

    int open = 1;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Set<Integer> visitedRooms = new HashSet<>();
        //        visitedRooms.add(0);
        // LinkedList<Integer> keys = new LinkedList<>();
        int n = rooms.size();
        visitedRooms = new boolean[n];
        visitedRooms[0] = true;
        if (n <= 1) {
            return true;
        }
        for (Integer key : rooms.get(0)) {
            openRoom(key, rooms);
        }
        if (open >= n) {
            return true;
        } else {
            return false;
        }
    }

    private void openRoom(int room, List<List<Integer>> rooms) {
        if (!visitedRooms[room]) {
            visitedRooms[room] = true;

            open++;

            for (Integer key : rooms.get(room)) {
                openRoom(key, rooms);
            }
        }
    }
}
