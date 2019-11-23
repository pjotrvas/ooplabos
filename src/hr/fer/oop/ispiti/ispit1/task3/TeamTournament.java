package hr.fer.oop.ispiti.ispit1.task3;

public class TeamTournament extends Tournament {

    public TeamTournament ( String name , String when ) {
        super(name , when);
    }

    @Override
    public boolean addCompetitor ( Competitor competitor ) {

        if (competitor instanceof Team)
        return super.addCompetitor(competitor);

        else return false;
    }
}
