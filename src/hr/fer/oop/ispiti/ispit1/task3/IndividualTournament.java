package hr.fer.oop.ispiti.ispit1.task3;

public class IndividualTournament extends Tournament {


    public IndividualTournament ( String name , String when ) {
        super(name , when);
    }

    @Override
    public boolean addCompetitor ( Competitor competitor ) {
        if (competitor instanceof Player) return super.addCompetitor(competitor);

        else return false;
    }
}
