package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManagableTeam;
import hr.fer.oop.lab2.welcomepack.Manager;

public class Coach extends Person implements Manager {

    private int coachingSkill = Constants.DEFAULT_COACHING_SKILL;
    private Formation formation = Constants.DEFAULT_FORMATION;
    private ManagableTeam managingTeam;

    public Coach(String name, String country, int emotion, int coachingSkill, Formation formation){
        super(name, country, emotion);
        setCoachingSkill(coachingSkill);
        setFormation(formation);
    }

    public Coach(){ super(); }

    public void setCoachingSkill(int coachingSkill){
        if (coachingSkill >= Constants.MIN_COACHING_SKILL && coachingSkill <= Constants.MAX_COACHING_SKILL) this.coachingSkill = coachingSkill;
        else System.out.println("ERROR: Coaching skill out of range.");
    }

   public void setFormation(Formation formation){
        if (formation != null) this.formation = formation;
        else System.out.println("ERROR: Formation must not be null.");
   }

   public int getCoachingSkill(){ return coachingSkill; }

   public Formation getFormation(){ return formation; }

    @Override
    public void forceMyFormation () {
        managingTeam.setFormation(formation);
    }

    @Override
    public void pickStartingEleven () {
        int gk = managingTeam.getFormation().getNoGoalkeeper();
        int df = managingTeam.getFormation().getNoDefenders();
        int mf = managingTeam.getFormation().getNoMidfielders();
        int fw = managingTeam.getFormation().getNoForwards();

        managingTeam.clearStartingEleven();

        for (FootballPlayer player : managingTeam.getRegisteredPlayers().getPLayers()) {
           if (player != null && managingTeam.getStartingEleven().size() != managingTeam.getStartingEleven().getMaxSize()){
               switch (player.getPlayingPosition()){
                   case GK:
                       if (gk > 0){
                           managingTeam.addPlayerToStartingEleven(player);
                           gk--;
                       } break;
                   case DF:
                       if (df > 0){
                           managingTeam.addPlayerToStartingEleven(player);
                           df--;
                       } break;
                   case MF:
                       if (mf > 0){
                           managingTeam.addPlayerToStartingEleven(player);
                           mf--;
                       } break;
                   case FW:
                       if (fw > 0){
                           managingTeam.addPlayerToStartingEleven(player);
                           fw--;
                       } break;
               default:
                   break;
               }

           }

        }

    }

    @Override
    public void setManagingTeam ( ManagableTeam team ) {
        if (team != null) this.managingTeam = team;
        else System.out.println("ERROR: Team must not be null.");
    }
}
