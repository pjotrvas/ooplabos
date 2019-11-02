package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

public class ClubTeam extends Team{

    private int reputation = Constants.DEFAULT_REPUTATION;

    public ClubTeam(){ super(Constants.MAX_NUMBER_OF_PLAYERS_CLUB); }

    public ClubTeam( String name, Formation formation, int reputation ){
        super(name, formation, Constants.MAX_NUMBER_OF_PLAYERS_NATIONAL);

        setReputation(reputation);
    }

    public void setReputation(int reputation){
        if (reputation >= Constants.MIN_REPUTATION && reputation <= Constants.MAX_REPUTATION)
            this.reputation = reputation;
        else System.out.println("ERROR: Reputation out of range.");
    }

    public int getReputation(){ return reputation; }

    @Override
    public double calculateRating () {
        return Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateSkillSum() + Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateEmotionSum();
    }

    @Override
    public boolean registerPlayer ( FootballPlayer player ) {
        if (player == null) return false;
        if (player.getPlayingSkill() < reputation || getRegisteredPlayers().size() >= getRegisteredPlayers().getMaxSize()) return false;

        getRegisteredPlayers().add(player);
        return true;
    }
}
