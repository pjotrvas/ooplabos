package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab3.exceptions.TeamCountryNullException;

public class NationalTeam extends Team{

    private String country = Constants.DEFAULT_COUNTRY_NAME;

    public NationalTeam() { super(Constants.MAX_NUMBER_OF_PLAYERS_NATIONAL); }

    public NationalTeam(String name, Formation formation, String country){
        super(name, formation, Constants.MAX_NUMBER_OF_PLAYERS_NATIONAL);

        try {
            if (country != null) this.country = country;
            else throw new TeamCountryNullException();
        } catch (TeamCountryNullException e){
            e.printStackTrace();
            this.country = "noCountry";
        }
        finally {
            if (country == null) System.out.println("Country set to noCountry.");
        }

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
