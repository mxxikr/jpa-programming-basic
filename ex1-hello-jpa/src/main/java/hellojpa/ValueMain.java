package hellojpa;

import java.util.Objects;

public class ValueMain {

    public static void main(String[] args) {

        int a = 10;
        int b = a;

        a = 20;

        Integer c = new Integer(20);
        Integer d = c;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("c = " + c);
        System.out.println("d = " + d);

        Address address1 = new Address("city", "street", "10000");
        Address address2 = new Address("city", "street", "10000");

        System.out.println("address1 == address2 " + (address1 == address2));
        System.out.println("address1 equals address2 " + (address1.equals(address2)));

    }
}
