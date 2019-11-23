package hr.fer.oop.lab3.labexam;

class SmartSerpa implements CoffeeMaker{

    private int coffee;
    private int water;

    private boolean waterHeated;

    public SmartSerpa(){
      this.coffee = 0;
      this.water = 0;
      this.waterHeated = false;
    }



    @Override
    public void addWater ( int water ) {
           this.water += water;
            if (isWaterHeated()){
                this.waterHeated = false;
            }
    }

    @Override
    public void heatWater () {
          if (water > 0) this.waterHeated = true;
    }

    @Override
    public void addCoffee ( int coffeeSpoonNumber ) {
            if (isWaterHeated()){
                coffee += coffeeSpoonNumber;
            }
    }

    @Override
    public int pourCoffee ( int requestedCupsNumber ) {
        int noOfCoffes = 0;

        if (requestedCupsNumber == 0) return 0;

        if (isWaterHeated()) {
            while (coffee >= 2 && water >= 1 && requestedCupsNumber > noOfCoffes) {
                coffee -= 2;
                water -= 1;

                noOfCoffes++;
            }
        }
        return noOfCoffes;
    }

    @Override
    public int getWaterAmount () {
        return this.water;
    }

    @Override
    public int getCoffeeSize () {
        return this.coffee;
    }

    @Override
    public boolean isWaterHeated () {
        if (water == 0) return false;

        else return this.waterHeated;
    }
}
