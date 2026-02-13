package hellojpa;

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
    }
}
