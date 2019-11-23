package hr.fer.oop.ispiti.ispit1.task4.pack2;

import hr.fer.oop.ispiti.ispit1.task4.pack1.A;

public class B extends A {
    private int z;

    public B ( int x , int y, int z ) {
        super(x , y);
        this.z = z;
    }

    @Override
    public String values(){
        return super.values() + ", Z =" + z;
    }

    @Override
    public void rotate () {
        int temp = getX();
        setX(getY());
        setY(z);
        z = temp;
    }
}
