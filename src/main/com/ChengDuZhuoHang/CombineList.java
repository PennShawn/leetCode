package main.com.ChengDuZhuoHang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-04-15
 */
public class CombineList {

    List<Stat> list = new ArrayList<>();

    public void combineStat(List<Stat> list) {
        Stat preStat = new Stat();
        Iterator<Stat> it = list.iterator();
        while (it.hasNext()) {
            Stat curStat = it.next();
            if (curStat.getDate().equals(preStat.getDate())) {
                preStat.setRegisterUserDount(
                        preStat.getRegisterUserDount() + curStat.getRegisterUserDount());
                preStat.setActiveUserCount(
                        preStat.getActiveUserCount() + curStat.getActiveUserCount());
                it.remove();
            } else {
                preStat = curStat;
            }
        }
    }

    public static void main(String[] args) {
        List<Stat> list = new ArrayList<>();
        list.add(new Stat("1", 1, 1));
        list.add(new Stat("1", 1, 2));
        list.add(new Stat("2", 1, 2));
        list.add(new Stat("2", 1, 2));
        list.add(new Stat("3", 1, 2));
        CombineList combineList = new CombineList();
        combineList.combineStat(list);
        for (Stat stat : list) {
            System.out.println(stat.getDate() + "  " + stat.getRegisterUserDount() + " "
                    + stat.getActiveUserCount() + " ");
        }
    }
}

class Stat {

    public Stat() {
    }

    private String date;

    private int registerUserDount;

    private int activeUserCount;

    public String getDate() {
        return date;
    }

    public Stat(String date, int registerUserDount, int activeUserCount) {
        this.date = date;
        this.registerUserDount = registerUserDount;
        this.activeUserCount = activeUserCount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRegisterUserDount() {
        return registerUserDount;
    }

    public void setRegisterUserDount(int registerUserDount) {
        this.registerUserDount = registerUserDount;
    }

    public int getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(int activeUserCount) {
        this.activeUserCount = activeUserCount;
    }
}
