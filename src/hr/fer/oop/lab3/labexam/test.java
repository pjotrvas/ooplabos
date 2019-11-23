package hr.fer.oop.lab3.labexam;

public class test {

   public static void main(String[] args){
       SmartSerpa serpa = new SmartSerpa();

       System.out.println( serpa.isWaterHeated());

       serpa.heatWater();
       System.out.println(serpa.isWaterHeated());

       serpa.addWater(5);
      serpa.heatWater();
       System.out.println(serpa.isWaterHeated());



       serpa.addCoffee(5);


       System.out.println(serpa.getWaterAmount());
       System.out.println(serpa.getCoffeeSize());
       System.out.println(serpa.pourCoffee(3));

   }
}