package hr.fer.oop.ispiti.ispit2.task4;

public class BasicLifeCost {
    private double income;
    private double basicCost;

    public BasicLifeCost ( double income , double basicCost ) {
        this.income = income;
        this.basicCost = basicCost;
    }

    public String getCostType () {
        return "Basic";
    }

    public static void info ( BasicLifeCost cost ) {
        System.out.println("B: " + cost.getCostType());
    }

    public double totalCost () {
        return basicCost;
    }

    public double getTotalCost(){
        return basicCost;
    }

    public final double monthlySavings () {
        return income - getTotalCost();
    }

    @Override
    public String toString(){
        if (income < getTotalCost()) return "You cant afford to live... Total cost is " + getTotalCost();
        else return  "Total living cost is " + getTotalCost();
    }


}