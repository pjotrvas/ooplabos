package hr.fer.oop.ispiti.ispit2.task3;

public class Fridge extends RemoteAbs{

    private double temperature;

    public Fridge( String id, boolean isPoweredOn, boolean isRemoteSessionActive, int temperature){
        super(id, isPoweredOn, isRemoteSessionActive);
        this.temperature = temperature;
    }
}
