package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;

public class FootballPlayer extends Person {

    private int playingSkill = Constants.DEFAULT_PLAYING_SKILL;
    private PlayingPosition playingPosition = Constants.DEFAULT_PLAYING_POSITION;

    public FootballPlayer(){ super();}

    public FootballPlayer (String name, String country, int emotion, int playingSkill , PlayingPosition playingPosition ) {
        super(name, country, emotion);

        setPlayingSkill(playingSkill);
        setPlayingPosition(playingPosition);
    }

    public void setPlayingSkill(int playingSkill){
        if (playingSkill >= Constants.MIN_PLAYING_SKILL && playingSkill <= Constants.MAX_PLAYING_SKILL) this.playingSkill = playingSkill;
        else System.out.println("ERROR: Playing skill is out of range.");
    }

    public void setPlayingPosition(PlayingPosition playingPosition){
        if (playingPosition != null) this.playingPosition = playingPosition;
        else System.out.println("ERROR: Playing position must not be null.");
    }

    public int getPlayingSkill () {
        return playingSkill;
    }

    public PlayingPosition getPlayingPosition () {
        return playingPosition;
    }
}
