package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;

public class Coach extends Person{

    private int coachingSkill = Constants.DEFAULT_COACHING_SKILL;
    private Formation formation = Constants.DEFAULT_FORMATION;

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
}
