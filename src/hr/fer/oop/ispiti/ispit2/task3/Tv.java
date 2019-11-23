package hr.fer.oop.ispiti.ispit2.task3;

public class Tv extends Device {

    private double size;

    public Tv(String id, boolean isPoweredOn, double size){
        super(id, isPoweredOn);
        this.size = size;
    }

}
