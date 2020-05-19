package main.com.exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-04-26
 */
public class LinkedListSort {

    private void sortName(LinkedList<Data> linkedList) {
        Collections.sort(linkedList, new Comparator<Data>() {

            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }

    private void sortScore(LinkedList<Data> linkedList) {
        Collections.sort(linkedList, new Comparator<Data>() {

            @Override
            public int compare(Data o1, Data o2) {
                return o1.score - o2.score;
            }
        });
    }

    private void swap(LinkedList<Data> linkedList, int index1, int index2) {
        Data data1 = linkedList.get(index1);
        Data data2 = linkedList.get(index2);
        linkedList.remove(index1);
        linkedList.add(index1, data2);
        linkedList.remove(index2);
        linkedList.add(index2, data1);
    }

    public static void main(String[] args) {
        LinkedList<Data> list = new LinkedList<>();
        list.add(new Data("", 0));
        list.add(new Data("", 1));
        list.add(new Data("", 2));
        LinkedListSort linkedListSort = new LinkedListSort();
        linkedListSort.swap(list, 0, 2);
        System.out.println(list.get(0).score);
        System.out.println(list.get(1).score);
        System.out.println(list.get(2).score);

    }

}

class Data {

    String name;

    int score;

    public Data(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
