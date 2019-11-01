package hr.fer.oop.lab2.welcomepack;


/**
 * Football team formation; (no. of defenfers, no. of midfielders, no. of forwards) and 1 goalkeeper
 */

public enum Formation {

    F442(4,4,2), F352(3, 5, 2), F541(5, 4, 1);

    private int noDefenders;
    private int noMidfielders;
    private int noForwards;
    private final int noGoalkeeper = 1;

    Formation(int noDefenders, int noMidfielders, int noForwards){
        this.noDefenders = noDefenders;
        this.noMidfielders = noMidfielders;
        this.noForwards = noForwards;
    }

    public int getNoDefenders () {
        return noDefenders;
    }

    public int getNoMidfielders () {
        return noMidfielders;
    }

    public int getNoForwards () {
        return noForwards;
    }

    public int getNoGoalkeeper () {
        return noGoalkeeper;
    }
}
