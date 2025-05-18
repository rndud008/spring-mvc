package hello.hellobasic;

import jakarta.persistence.criteria.CriteriaBuilder;

public class ValueMain {
    public static void main(String[] args) {
//        int a = 10;
//        int b = a;
//
//        b =20;
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
        // 기본타입은 항상 값을 복사
//         공유 X


//        Integer a = 10;
//        Integer b = a;
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
        // 참조값 공유
//        변경 X

        int a = 10;
        int b = 10;
        System.out.println("a == b: " + (a==b));

        Address address1 = new Address("city","street","10000");
        Address address2 = new Address("city","street","10000");
        System.out.println("(address1 == address2): " + (address1 == address2));
        System.out.println("(address1.equals(address2)): " + (address1.equals(address2)));

    }
}
