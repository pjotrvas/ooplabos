package hr.fer.oop.lab3.exceptions;

public class FootballPlayerEmotionException extends FootballPlayerCreationException{

    public FootballPlayerEmotionException(String message, int lowB, int upB){ super(message + " " + lowB + " - " + upB); }

}
