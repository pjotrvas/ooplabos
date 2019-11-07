package hr.fer.oop.lab3.exceptions;

public class FootballPlayerCreationException extends FootballException{

    public FootballPlayerCreationException(String message){ super(message); }

    public FootballPlayerCreationException(){ super(); }
}
