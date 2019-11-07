package hr.fer.oop.lab3.exceptions;

public class FootballPlayerPlayingSkillException extends FootballPlayerCreationException {

  public FootballPlayerPlayingSkillException(String message, int lowB, int upB){ super(message + " " + lowB + " - " + upB); }

}
