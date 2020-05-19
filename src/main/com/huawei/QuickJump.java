package main.com.huawei;

import java.util.*;

/**
 * @Description:
 *               7
 *               2
 *               3
 *               2
 *               1
 *               2
 *               1
 *               5
 * @Author: shenpeng
 * @Date: 2020-04-22
 */
public class QuickJump {

    public static void main(String[] args) {
        //        Scanner sc = new Scanner(System.in);
        //        int n = sc.nextInt();
        //        List<Integer> jump = new ArrayList<>();
        //        for (int i = 0; i < n; i++) {
        //            jump.add(sc.nextInt());
        //        }

        int n = 7;
        List<Integer> jump = new ArrayList<>();
        jump.add(2);
        jump.add(3);
        jump.add(2);
        jump.add(1);
        jump.add(2);
        jump.add(1);
        jump.add(5);
        int pos = n - 1;
        Set<Integer> usedPoses = new HashSet<>();
        int minNextPos = Integer.MAX_VALUE;
        System.out.println(jump(jump, pos, usedPoses, minNextPos));
    }

    private static int jump(List<Integer> jump, int pos, Set<Integer> usedPoses, int minNextPos) {
        if (pos == 0) {
            System.out.println(0);
            return 0;
        }
        int cur = Integer.MAX_VALUE;
        int nextPos = pos - 1;
        while (nextPos >= 0) {
            if (pos - nextPos >= jump.get(nextPos) && !usedPoses.contains(nextPos)) {
                usedPoses.add(nextPos);
                //  minNextPos = nextPos;
                int result = jump(jump, nextPos, usedPoses, minNextPos);
                if (result < cur) {
                    cur = result;
                }
            }
            nextPos--;
        }
        if (cur == Integer.MAX_VALUE) {
            System.out.println(pos + "  " + cur);
            return Integer.MAX_VALUE;
        } else {
            System.out.println(pos + "  " + cur);
            return cur + 1;
        }
    }
}
