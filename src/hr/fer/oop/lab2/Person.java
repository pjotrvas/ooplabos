package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab3.exceptions.FootballPlayerEmotionException;

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

    public String getCountry () {
        return country;
    }

    public int getEmotion () {
        return emotion;
    }

    public void setEmotion ( int emotion ) {
      try {
          if (emotion >= Constants.MIN_EMOTION && emotion <= Constants.MAX_EMOTION) this.emotion = emotion;
          else throw new FootballPlayerEmotionException("Emotion is not in the defined range :", Constants.MIN_EMOTION, Constants.MAX_EMOTION);
          } catch (FootballPlayerEmotionException e){
          e.printStackTrace();
          this.emotion = 25;
      } finally {
          if (emotion < Constants.MIN_EMOTION || emotion > Constants.MAX_EMOTION) System.out.println("Emotion set to 25.");
      }
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
