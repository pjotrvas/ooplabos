package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.FootballPlayerCollection;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

/**
 * Implementation of SimpleFootbalPlayerCollection.
 * Collection which stores football players through an array.
 */
public class SimpleFootballPlayerCollectionImpl implements FootballPlayerCollection {

    private FootballPlayer[] players;

    public SimpleFootballPlayerCollectionImpl(int size){
        players = new FootballPlayer[size];
    }

    @Override
    public boolean add ( FootballPlayer player ) {
        if (!contains(player)){
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null){
                    players[i] = player;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains ( FootballPlayer player ) {
        if (player == null) return false;

        for (FootballPlayer p: players) {
            if (p != null){
                if (player.equals(p)) return true;
            }
        }
        return false;
    }

    @Override
    public void clear () {
        for (int i = 0; i < players.length; i++) {
            players[i] = null;
        }
    }

    @Override
    public int calculateEmotionSum () {
        int emotionSum = 0;
        for (FootballPlayer p: players) {
            if (p != null) emotionSum += p.getEmotion();
        }
        return emotionSum;
    }

    @Override
    public int calculateSkillSum () {
        int skillSum = 0;
        for (FootballPlayer p: players) {
            if (p != null) skillSum += p.getPlayingSkill();
        }
        return skillSum;
    }

    @Override
    public int getMaxSize () { return players.length; }

    @Override
    public int size () {
        int size = 0;

        for (FootballPlayer p: players) {
            if (p != null) size++;
        }
        return size;
    }

    @Override
    public FootballPlayer[] getPLayers () { return players; }

    @Override
    public boolean remove ( FootballPlayer player ) {
        if (player == null) return false;

        for (int i = 0; i < players.length; i++) {
            if (players[i] != null){
                if (players[i].equals(player)){
                    players[i] = null;
                    return true;
                }
            }

        }
        return false;
    }
}
