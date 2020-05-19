package main.com.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-04-26
 */
public class DataClean {

    private static final long MS = 1000L;

    void dataClean(List<Data2> dataList, int secondSection) {
        //当前时间的数据总值
        int curValue;
        //当前时间的数据量
        int curNum;
        //当前时间
        long curTime;
        Map<Long, Integer> time2Value = new HashMap<>();
        long smallTime = dataList.get(0).timeStamp / (secondSection * MS);
        long largestTime = 0;
        for (int i = 0; i < dataList.size(); i++) {
            curTime = dataList.get(i).timeStamp / (secondSection * MS);
            curValue = dataList.get(i).value;
            curNum = 1;
            while (i < dataList.size() - 1
                    && dataList.get(i + 1).timeStamp / (secondSection * MS) == curTime) {
                i++;
                curValue += dataList.get(i).value;
                curNum++;
            }
            time2Value.put(curTime, curValue / curNum);
            if (curTime > largestTime) {
                largestTime = curTime;
            }
        }
        for (long i = smallTime; i <= largestTime; i++) {
            if (time2Value.containsKey(i)) {
                System.out.println(time2Value.get(i));
            } else {
                //数据不存在时
                for (int j = 1; j < largestTime - i; j++) {
                    if (time2Value.containsKey(i + j)) {
                        for (int k = 0; k < j; k++) {
                            System.out.println(check(i - 1, i + j, k, time2Value));
                        }
                        i = i + j - 1;
                        break;
                    }
                }
            }
        }

    }

    private long check(long start, long end, long cur, Map<Long, Integer> time2Value) {
        return time2Value.get(start)
                + (time2Value.get(end) - time2Value.get(start)) * (cur + 1) / (end - start);
    }

    public static void main(String[] args) {
        List<Data2> data2List = new ArrayList<>();
        data2List.add(new Data2(1001, 1));
        data2List.add(new Data2(1020, 20));
        data2List.add(new Data2(1030, 30));
        data2List.add(new Data2(2030, 230));
        data2List.add(new Data2(4030, 430));
        DataClean dataClean = new DataClean();
        dataClean.dataClean(data2List, 1);

    }
}

class Data2 {

    long timeStamp;

    int value;

    public Data2(long timeStamp, int value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}
