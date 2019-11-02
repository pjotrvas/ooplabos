package hr.fer.oop.lab2.welcomepack;

import hr.fer.oop.lab2.FootballPlayer;

/**
 * A specification of a simple data structure in which players are stored.
 */
public interface SimpleFootballPlayerCollection {

    /**
     * Adds player in a collection if he is not added already
     * and if there is not enough players already.
     *
     * @param player
     * @return true if player is added, false otherwise.
     */
    public boolean add( FootballPlayer player);

    /**
     * Checks whether player is a part of the collection.
     * @param player
     * @return true if player is found in collection, false otherwise
     */
    public boolean contains(FootballPlayer player);

    /**
     * Clears all players from a collection.
     */
    public void clear();

    /**
     * Sums emotions from all players in collection.
     * @return the sum of emotions.
     */
    public int calculateEmotionSum();

    /**
     * Sums skills from all platers in collection.
     * @return the sum of skills.
     */
    public int calculateSkillSum();

    /**
     * Maximum number of player who can be stored in a collection.
     * @return maximum number of players in a collection.
     */
    public int getMaxSize();

    /**
     * Returns the number of players that are currently in the collection.
     * @return number of players that are now in the collection.
     */
    public int size();

    /**
     * Method used to get the underlying array in which players are actually stored.
     * @return an array of players
     */
    public FootballPlayer[] getPLayers();
}
