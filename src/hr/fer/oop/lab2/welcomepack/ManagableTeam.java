package hr.fer.oop.lab2.welcomepack;


import hr.fer.oop.lab2.FootballPlayer;

/**
 * A team can be managed according to this interface.
 */
public interface ManagableTeam {

    /**
     * Adds a player to starting eleven
     * if the player is already added to registered player collection
     * and there is less than eleven players already added.
     * @param player
     * @return true if a player is added, false otherwise.
     */
    public boolean addPlayerToStartingEleven(FootballPlayer player);

    /**
     * Calculates team rating by this rulles:
     *
     *  club team: 70% sum of registered players skills + 30% sum of emotions of registered players;
     *
     *  national team: 30% sum of registered players skills  + 70% sum of emotions of registered players.
     *
     * @return team rating
     */
    public double calculateRating();

    /**
     * Clears a collection of starting eleven.
     */
    public void clearStartingEleven();

    /**
     * Formation setter.
     * Sets formation if it's not null.
     * @param formation
     */
    public void setFormation(Formation formation);

    /**
     * Formation getter.
     * @return team formation
     */
    public Formation getFormation();

    /**
     * Returns a collection of registered players.
     * @return registered players
     */
    public SimpleFootballPlayerCollection getRegisteredPlayers();

    /**
     * Returns a collection of starting eleven.
     * @return starting eleven
     */
    public SimpleFootballPlayerCollection getStartingEleven();

    /**
     *If a team is a national team, a player need to have the same country as a national team;
     *If a team is a club team, a player needs to have player skill
     *which is higher or equal to club's reputation (note: in either case
     *player registration will be successful if there is a space for a player).
     *
     * @param player
     * @return true if a player is added, false otherwise
     */
    public boolean registerPlayer(FootballPlayer player);

    /**
     * Checks if the player is registered in a team.
     * @param player
     * @return true if a player is registered, false otherwise
     */
    public boolean isPlayerRegistered(FootballPlayer player);

}
