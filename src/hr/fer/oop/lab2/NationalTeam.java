package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

public class NationalTeam extends Team{

    private String country = Constants.DEFAULT_COUNTRY;

    public NationalTeam() { super(Constants.MAX_NUMBER_OF_PLAYERS_NATIONAL); }
    
    public NationalTeam(String name, Formation formation, String country){
        super(name, formation, Constants.MAX_NUMBER_OF_PLAYERS_NATIONAL);

        if (country != null) this.country = country;
        else System.out.println("ERROR: Country name must not be null.");
    }

    @Override
    public double calculateRating () {
        return Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateEmotionSum() + Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateSkillSum();
    }

    @Override
    public boolean registerPlayer ( FootballPlayer player ) {
       if (player == null) return false;
       if (!player.getCountry().equals(country) || getRegisteredPlayers().size() >= getRegisteredPlayers().getMaxSize())
           return false;

       getRegisteredPlayers().add(player);
        return true;
    }
}
