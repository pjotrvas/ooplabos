package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManagableTeam;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;


public abstract class Team implements ManagableTeam {

    private String name = Constants.DEFAULT_TEAM_NAME;
    private Formation formation = Constants.DEFAULT_FORMATION;
    private SimpleFootballPlayerCollection registeredPlayers;
    private SimpleFootballPlayerCollection startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);

    public Team(String name, Formation formation, int registeredPlayersSize){
        this.registeredPlayers = new SimpleFootballPlayerCollectionImpl(registeredPlayersSize);

        if (name != null) this.name = name;
        else System.out.println("ERROR: Name must not be null");

        setFormation(formation);
    }

    public Team(int registeredPlayersSize){
        this.registeredPlayers = new SimpleFootballPlayerCollectionImpl((registeredPlayersSize));
    }

    @Override
    public boolean addPlayerToStartingEleven ( FootballPlayer player ) {
        if (registeredPlayers.contains(player) && !startingEleven.contains(player) && startingEleven.size() < Constants.STARTING_ELEVEN_SIZE){
            startingEleven.add(player);
            return true;
        }
        return false;
    }

    @Override
    public void clearStartingEleven () {
        startingEleven.clear();
    }

    @Override
    public void setFormation ( Formation formation ) {
        if (formation != null) this.formation = formation;
        else System.out.println("ERROR: Formation must not be null.");
    }

    @Override
    public Formation getFormation () {
        return formation;
    }

    @Override
    public SimpleFootballPlayerCollection getRegisteredPlayers () {
        return registeredPlayers;
    }

    @Override
    public SimpleFootballPlayerCollection getStartingEleven () {
        return startingEleven;
    }

    @Override
    public boolean isPlayerRegistered ( FootballPlayer player ) {
        return registeredPlayers.contains(player);
    }
}
