package hr.fer.oop.ispiti.ispit2.task4;

public class ExtendedLifeCost extends BasicLifeCost {

    private double additionalExpenses;
    public String getCostType(){
        return "Extended";
    }
    public static void info(ExtendedLifeCost cost) {
        System.out.println("E: " + cost.getCostType());
    }
    public ExtendedLifeCost(double income, double basicCost) {
        this(income, basicCost, basicCost);
    }

    public ExtendedLifeCost(double income, double basicCosts, double additionalExpenses){
        super(income, basicCosts);
        this.additionalExpenses = additionalExpenses;
    }
}
