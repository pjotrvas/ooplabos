package hr.fer.oop.lab2.welcomepack;

/**
 * A manager knows how to manage a team bi implementing this interface.
 */
public interface Manager {

    /**
     * Manager sets his favorite formation with this method.
     */
    public void forceMyFormation();

    /**
     * A method used to pick the starting eleven from a team he manages (NOTE: only the players
     * from registered players collection are eligible);
     * a method must be careful to pick such players who can form a team formation
     * (e.g., a number of forwards within first eleven should match a number of forwards in a team formation).
     */
    public void pickStartingEleven();

    /**
     * With this method, a manager sets a team he manages if a team is not null.
     * @param team team
     */
    public void setManagingTeam(ManagableTeam team);
}
