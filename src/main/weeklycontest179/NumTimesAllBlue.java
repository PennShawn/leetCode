package main.weeklycontest179;

import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-03-08
 */
public class NumTimesAllBlue {

    public int numTimesAllBlue(int[] light) {
        int dark = 1;
        int count = 0;
        int l = light.length;
        PriorityQueue<Integer> lightQueue = new PriorityQueue<>();
        for (int i = 0; i < l; i++) {
            if (light[i] == dark) {
                dark++;
                while (!lightQueue.isEmpty()) {
                    if (lightQueue.peek() == dark) {
                        dark++;
                        lightQueue.poll();
                    } else {
                        break;
                    }
                }
                if (lightQueue.isEmpty()) {
                    count++;
                }
            } else {
                lightQueue.add(light[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] light = new int[] { 2, 1, 4, 3, 6, 5 };
        NumTimesAllBlue numTimesAllBlue = new NumTimesAllBlue();
        System.out.println(numTimesAllBlue.numTimesAllBlue(light));
    }
}
