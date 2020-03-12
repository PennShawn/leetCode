package main.practices.algorithmCourse.mockinterview;

import java.util.*;

/**
 * @Description:
 *               Design and implement a data structure for Least Recently
 *               Used (LRU) cache. It should support the following
 *               operations: get and put.
 *
 *               get(key) - Get the value (will always be positive) of the
 *               key if the key exists in the cache, otherwise return -1.
 *               put(key, value) - Set or insert the value if the key is
 *               not already present. When the cache reached its capacity,
 *               it should invalidate the least recently used item before
 *               inserting a new item.
 *
 *               The cache is initialized with a positive capacity.
 *
 *               Follow up:
 *               Could you do both operations in O(1) time complexity?
 *
 *               Example:
 *
 *               LRUCache cache = new LRUCache( 2);
 * 
 *               cache.put(1, 1);
 *               cache.put(2, 2);
 *               cache.get(1); // returns 1
 *               cache.put(3, 3); // evicts key 2
 *               cache.get(2); // returns -1 (not found)
 *               cache.put(4, 4); // evicts key 1
 *               cache.get(1); // returns -1 (not found)
 *               cache.get(3); // returns 3
 *               cache.get(4); // returns 4
 * 
 * 
 * 
 *               思路：用双向链表，map储存node对象，移除时间复杂度就是O(1)了
 *               queue的remove不是O(1)
 *               LinkedHashMap天然支持这个
 * @Author: shenpeng
 * @Date: 2020-03-12
 */
public class LRUCache {

    /**
     * key的顺序
     */
    Queue<Integer> orders = new ArrayDeque<>();

    /**
     * 容量
     */
    int capacity;

    /**
     * 数据
     */
    Map<Integer, Integer> datas = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (datas.containsKey(key)) {
            update(key);
            return datas.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        datas.put(key, value);
        if (datas.size() > capacity) {
            removeExpired();
        }
        update(key);
    }

    private void update(int key) {
        orders.remove(key);
        orders.add(key);
    }

    private void removeExpired() {
        int removedKey = orders.poll();
        datas.remove(removedKey);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
