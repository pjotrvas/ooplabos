package hr.fer.oop.ispiti.ispit1.task4;

import hr.fer.oop.ispiti.ispit1.task4.pack1.A;
import hr.fer.oop.ispiti.ispit1.task4.pack2.B;
import hr.fer.oop.ispiti.ispit1.task4.pack3.C;
import hr.fer.oop.ispiti.ispit1.task4.pack4.D;

public class Main {

    public static void main(String[] args) {
        D d = new A(1, 2);
        //a.setX(1) or a.x = 1 would cause a compile error
        System.out.println(d.values()); // X = 1, Y = 2
        d.rotate();
        System.out.println(d.values()); // X = 1, Y = 2

        d = new B(1, 2, 3);
        System.out.println(d.values()); // X = 1, Y = 2, Z = 3
        d.rotate();
        System.out.println(d.values()); // X = 2, Y = 3, Z = 1

        d = new C(3, 2);
        System.out.println(d.values()); // X = 3, Y = 6, Z = 9
        d.rotate();
        System.out.println(d.values()); // X = 9, Y = 3, Z = 6
        d.rotate();
        System.out.println(d.values()); // X = 6, Y = 9, Z = 3

    }

}
