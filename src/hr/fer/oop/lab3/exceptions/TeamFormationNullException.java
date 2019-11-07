package hr.fer.oop.lab3.exceptions;

public class TeamFormationNullException extends TeamCreationException {

    public TeamFormationNullException(){ super("ERROR: Team formation must not be null"); }
}
