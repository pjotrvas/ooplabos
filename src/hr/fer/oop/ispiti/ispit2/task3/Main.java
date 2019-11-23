package hr.fer.oop.ispiti.ispit2.task3;

import java.util.Set;
/**
public class Main {

    public static void main(String[] args) {
        Set <Device> devices = DBLoader.loadDevices();

        for (Device device: devices) {
           if (!device.isPoweredOn()) device.switchPower();

           if (device instanceof RemoteAbs){
               ((RemoteAbs) device).startRemoteSession();

           }
        }

    }

}*/
