package hr.fer.oop.lab3.exceptions;

public class TeamCreationException extends FootballException{

    public TeamCreationException(String message){ super(message); }

    public TeamCreationException(){ super(); }
}
