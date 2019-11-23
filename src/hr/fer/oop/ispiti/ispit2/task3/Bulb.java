package hr.fer.oop.ispiti.ispit2.task3;

public class Bulb extends RemoteAbs{

   private Colors color;

   public Bulb( String id, boolean isPoweredOn, boolean isRemoteSessionActive, Colors color){
       super(id, isPoweredOn, isRemoteSessionActive);
       this.color = color;
   }
}
