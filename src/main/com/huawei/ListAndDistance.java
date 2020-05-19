package main.com.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *               A={1,3,5},B={2,4,6},R=1
 * 
 *               (1,2)(3,4)(5,6)
 * 
 * @Author: shenpeng
 * @Date: 2020-04-22
 */
public class ListAndDistance {

    public static void main(String[] args) {

        //                Scanner sc = new Scanner(System.in);
        //                String input = sc.next();
        String input = "A={1,32312,5},B={223,4,6},R=1";

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int r = 0;

        List<Integer> temp = a;

        String[] in = input.split(",");
        a.add(Integer.valueOf(in[0].substring(3)));
        for (int i = 1; i < in.length; i++) {
            if (in[i].contains("B")) {
                temp = b;
                temp.add(Integer.valueOf(in[i].substring(3)));
            } else if (in[i].contains("R")) {
                r = Integer.valueOf(in[i].substring(2));
            } else {
                if (in[i].contains("}")) {
                    temp.add(Integer.valueOf(in[i].substring(0, in[i].length() - 1)));
                } else {
                    temp.add(Integer.valueOf(in[i]));

                }
            }
        }
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(r);

        //        for (int i = 3; i < input.length(); i += 2) {
        //            char c = input.charAt(i);
        //            if (',' != c && '=' != c) {
        //                temp.add(Integer.valueOf(String.valueOf(input.charAt(i))));
        //            } else {
        //                i += 2;
        //                if (temp == b) {
        //                    i++;
        //                    r = Integer.valueOf(String.valueOf(input.charAt(i)));
        //                } else {
        //                    temp = b;
        //                }
        //            }
        //        }

        int l1 = a.size();
        int l2 = b.size();
        int j = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < l1; i++) {
            if (j >= l2) {
                break;
            }
            if (a.get(i) <= b.get(j)) {
                if (a.get(i) + r <= b.get(j)) {
                    append(result, a.get(i), b.get(j));
                    j++;
                } else {
                    continue;
                }
            } else {
                j++;
            }
        }
        System.out.println(result.toString());

    }

    private static void append(StringBuilder sb, int a, int b) {
        sb.append("(").append(a).append(",").append(b).append(")");
    }
}
