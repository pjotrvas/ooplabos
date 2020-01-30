package hr.fer.oop.ispiti.ZIpokazni.prvi;

import hr.fer.oop.ispiti.ispit1.task4.pack4.D;

import java.util.Comparator ;

public class Driver  {

    private String firstname;
    private String surname;
    private String adress;
    private long pid;

    public Driver(String firstname, String surname, String adress, long pid){
        this.firstname = firstname;
        this.surname = surname;
        this.adress = adress;
        this.pid = pid;
    }

    public long getPid () {
        return pid;
    }

    public String getFirstname () {
        return firstname;
    }

    public void setFirstname ( String firstname ) {
        this.firstname = firstname;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public String getAdress () {
        return adress;
    }

    public void setAdress ( String adress ) {
        this.adress = adress;
    }

    public void setPid ( long pid ) {
        this.pid = pid;
    }

    @Override
    public String toString(){
        return "Name: " + getFirstname() + " " + getSurname()+ " adress: " + getAdress() + " id: " + getPid();
    }

}

