package hr.fer.oop.ispiti.ispit2.task3;

public abstract class RemoteAbs extends Device implements Remote {

    private boolean isRemoteSessionActive;

    public RemoteAbs ( String id , boolean isPoweredOn, boolean isRemoteSessionActive ) {
        super(id , isPoweredOn);
        this.isRemoteSessionActive = isRemoteSessionActive;
    }

    @Override
    public void startRemoteSession () {
        isRemoteSessionActive = true;
    }

    @Override
    public void endRemoteSession () {
        isRemoteSessionActive = false;
    }
}
