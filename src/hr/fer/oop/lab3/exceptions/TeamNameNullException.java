package hr.fer.oop.lab3.exceptions;

public class TeamNameNullException extends TeamCreationException {

    public TeamNameNullException(){ super("ERROR: Team name must not be null!");}
}
