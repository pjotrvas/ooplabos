package hr.fer.oop.ispiti.ispit1.task4.pack3;

import hr.fer.oop.ispiti.ispit1.task4.pack2.B;

public class C extends B {
    private int rotationNumber;

    public C(int a, int rotationNumber){
        this(a, 2*a, 3*a, rotationNumber);
    }

    public C(int x, int y, int z, int rotationNumber){
        super(x, y, z);
        this.rotationNumber = rotationNumber;
    }

    public void rotate(){
        for (int i = 0; i < rotationNumber; i++) {
            super.rotate();
        }
    }

}
