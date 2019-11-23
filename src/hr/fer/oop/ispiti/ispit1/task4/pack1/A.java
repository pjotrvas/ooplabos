package hr.fer.oop.ispiti.ispit1.task4.pack1;

import hr.fer.oop.ispiti.ispit1.task4.pack4.D;

public class A implements D {

    private int x;
    private int y;

    public A(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    protected void setX(int x){
        this.x = x;
    }

    protected void setY(int y){
        this.y = y;
    }

    @Override
    public String values () {
        return String.format("X = %d, Y= %d", x, y);
    }
}
