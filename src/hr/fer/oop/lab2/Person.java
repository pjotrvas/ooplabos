package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;

import java.util.Objects;

public abstract class Person {

    private String name = Constants.DEFAULT_PLAYER_NAME;
    private String country = Constants.DEFAULT_COUNTRY;
    private int emotion = Constants.DEFAULT_EMOTION;

    public Person( String name, String country, int emotion){
            if (name != null) this.name = name;
            else System.out.println("ERROR : Name is null.");

            if (country != null) this.country = country;
            else System.out.println("ERROR: Country is null");

            setEmotion(emotion);
    }

    public Person () { }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getCountry () {
        return country;
    }

    public void setEmotion ( int emotion ) {
        if (emotion >= Constants.MIN_EMOTION && emotion <= Constants.MAX_EMOTION) this.emotion = emotion;
        else System.out.println("ERROR: Emotion is out of range.");
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getName() , person.getName()) &&
                Objects.equals(getCountry() , person.getCountry());
    }

    @Override
    public int hashCode () {
        return Objects.hash(getName() , getCountry());
    }
}
