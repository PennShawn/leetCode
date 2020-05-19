package main.com.dianhun;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-04-25
 */
public class FourThread {

    private static volatile int j = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable add1 = new Runnable() {

            @Override
            public void run() {
                j++;
            }
        };
        Runnable add2 = new Runnable() {

            @Override
            public void run() {
                j++;
            }
        };
        Runnable reduce1 = new Runnable() {

            @Override
            public void run() {
                j--;
            }
        };
        Runnable reduce2 = new Runnable() {

            @Override
            public void run() {
                j--;
            }
        };
        int N = 10;
        for (int i = 0; i < N; i++) {
            new Thread(add1).start();
            new Thread(add2).start();
            new Thread(reduce1).start();
            new Thread(reduce2).start();
        }
    }
}
