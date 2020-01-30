package practices.queue;

import java.util.*;

/**
 * @Description:
 * 
 *               You have a lock in front of you with 4 circular wheels.
 *               Each wheel has 10 slots: '0', '1', '2', '3', '4', '5',
 *               '6', '7', '8', '9'. The wheels can rotate freely and wrap
 *               around: for example we can turn '9' to be '0', or '0' to
 *               be '9'. Each move consists of turning one wheel one slot.
 *
 *               The lock initially starts at '0000', a string representing
 *               the state of the 4 wheels.
 *
 *               You are given a list of deadends dead ends, meaning if the
 *               lock displays any of these codes, the wheels of the lock
 *               will stop turning and you will be unable to open it.
 *
 *               Given a target representing the value of the wheels that
 *               will unlock the lock, return the minimum total number of
 *               turns required to open the lock, or -1 if it is
 *               impossible.
 *
 *               Example 1:
 *               Input: deadends = ["0201","0101","0102","1212","2002"],
 *               target = "0202"
 *               Output: 6
 *               Explanation:
 *               A sequence of valid moves would be "0000" -> "1000" ->
 *               "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 *               Note that a sequence like "0000" -> "0001" -> "0002" ->
 *               "0102" -> "0202" would be invalid,
 *               because the wheels of the lock become stuck after the
 *               display becomes the dead end "0102".
 * 
 *               Example 2:
 *               Input: deadends = ["8888"], target = "0009"
 *               Output: 1
 *               Explanation:
 *               We can turn the last wheel in reverse to move from "0000"
 *               -> "0009".
 * 
 *               Example 3:
 *               Input: deadends =
 *               ["8887","8889","8878","8898","8788","8988","7888","9888"],
 *               target = "8888"
 *               Output: -1
 *               Explanation:
 *               We can't reach the target without getting stuck.
 * 
 *               Example 4:
 *               Input: deadends = ["0000"], target = "8888"
 *               Output: -1
 * 
 *               Note:
 *               1. The length of deadends will be in the range [1, 500].
 *               2. target will not be in the list deadends.
 *               3. Every string in deadends and the string target will be
 *               a string of 4 digits from the 10,000 possibilities '0000'
 *               to '9999'.
 * 
 *               思路就是广度优先遍历，因为总共也就10000中情况，第一步最多16种情况，如果都不符合，对于第一步的结果，递归遍历下一步
 *               题解的方法都差不多，时间差距主要是在对字符串的处理，"0000"变成"0001"等怎么变比较快，最后发现转换成char数组再转回去是最快的
 *               因为String本身就是用一个char【】来存数据的
 * 
 * 
 * @Author: shenpeng
 * @Date: 2020-01-30
 */
public class CircleLock {

    public int openLock(String[] deadends, String target) {
        Set<String> deadEnds = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadEnds.add(deadends[i]);
        }
        LinkedList<String> curStepStates = new LinkedList<>();

        String curState = "0000";
        if (curState.equals(target)) {
            return 0;
        }
        if (deadEnds.contains(curState)) {
            return -1;
        }
        int step = 0;
        Set<String> nextStates = new HashSet<>();
        //        if (nextStates.contains(target)) {
        //            return 1;
        //        }
        //        curStepStates.addAll(nextStates);
        curStepStates.add(curState);
        while (curStepStates.size() > 0) {
            step++;
            // Iterator<String> it = curStepStates.iterator();
            int size = curStepStates.size();
            for (int i = 0; i < size; i++) {
                curState = curStepStates.pop();
                nextStates = getNextStates(curStepStates, deadEnds, curState);
                if (nextStates.contains(target)) {
                    return step;
                }
                //                for (String nextState : nextStates) {
                //                    curStepStates.add(nextState);
                //                }
            }
        }
        return -1;
    }

    //150ms
    private Set<String> getNextStates(LinkedList<String> curStepStates, Set<String> deadEnds,
            String curState) {
        String nextState;
        Set<String> nextStates = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            String changeChar = curState.substring(i, i + 1);
            if ("0".equals(changeChar)) {
                nextState = curState.substring(0, i) + '9' + curState.substring(i + 1, 4);
                if (!deadEnds.contains(nextState)) {
                    nextStates.add(nextState);
                }
                nextState = curState.substring(0, i) + '1' + curState.substring(i + 1, 4);
                if (!deadEnds.contains(nextState)) {
                    nextStates.add(nextState);
                }
            } else if ("9".equals(changeChar)) {
                nextState = curState.substring(0, i) + '8' + curState.substring(i + 1, 4);
                if (!deadEnds.contains(nextState)) {
                    nextStates.add(nextState);
                }
                nextState = curState.substring(0, i) + '0' + curState.substring(i + 1, 4);
                if (!deadEnds.contains(nextState)) {
                    nextStates.add(nextState);
                }
            } else {
                int changeNum = Integer.valueOf(changeChar);
                nextState = curState.substring(0, i) + (changeNum + 1)
                        + curState.substring(i + 1, 4);
                if (!deadEnds.contains(nextState)) {
                    nextStates.add(nextState);
                }
                nextState = curState.substring(0, i) + (changeNum - 1)
                        + curState.substring(i + 1, 4);
                if (!deadEnds.contains(nextState)) {
                    nextStates.add(nextState);
                }
            }
        }
        deadEnds.addAll(nextStates);
        return nextStates;
    }

    //125ms
    private Set<String> getNextStates2(LinkedList<String> curStepStates, Set<String> deadEnds,
            String curState) {
        Set<String> nextStates = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int d = -1; d <= 1; d += 2) {
                int y = ((curState.charAt(i) - '0') + d + 10) % 10;
                String nei = curState.substring(0, i) + ("" + y) + curState.substring(i + 1);
                if (!deadEnds.contains(nei)) {
                    nextStates.add(nei);
                    deadEnds.add(nei);
                    curStepStates.add(nei);
                }
            }
        }
        return nextStates;
    }

    //65ms
    private Set<String> getNextStates3(LinkedList<String> curStepStates, Set<String> deadEnds,
            String curState) {
        Set<String> nextStates = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            char[] array = curState.toCharArray();
            char temp = array[i];
            array[i] = temp == '0' ? '9' : (char) (temp - 1);
            String next = String.valueOf(array);
            if (!deadEnds.contains(next)) {
                nextStates.add(next);
                deadEnds.add(next);
                curStepStates.add(next);
            }

            array[i] = temp == '9' ? '0' : (char) (temp + 1);
            next = String.valueOf(array);
            if (!deadEnds.contains(next)) {
                nextStates.add(next);
                deadEnds.add(next);
                curStepStates.add(next);
            }
        }
        return nextStates;
    }
}
