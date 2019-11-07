package hr.fer.oop.lab3.exceptions;

public class FootballException extends RuntimeException{

    public FootballException(String message){ super(message); }

    public FootballException(){ super("ERROR IN PROJECT!"); }
}
