package hr.fer.oop.ispiti.ispit2.task3;

public abstract class Device {

    private final String id;
    private boolean isPoweredOn;

    public Device(String id, boolean isPoweredOn){
        this.id = id;
        this.isPoweredOn = isPoweredOn;
    }

    public String getId () {
        return id;
    }

    public boolean isPoweredOn(){
        return isPoweredOn;
    }

    public void switchPower(){
        if (isPoweredOn) isPoweredOn = false;
        else isPoweredOn = true;
    }

}
