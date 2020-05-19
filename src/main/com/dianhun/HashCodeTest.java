package main.com.dianhun;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-04-25
 */
public class HashCodeTest {

    public static void main(String[] args) {
        HashCodeTest h1 = new HashCodeTest();
        HashCodeTest h2 = new HashCodeTest();
        System.out.println(h1.equals(h2)); //false 不重写的话实际比较的是 h1==h2
        System.out.println(h1 == h2); //false

    }

    @Override
    public int hashCode() {
        return 1;
    }

    //    @Override
    //    public boolean equals(Object obj) {
    //        return hashCode() == obj.hashCode();
    //    }
}
