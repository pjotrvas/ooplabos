package hr.fer.oop.lab3.labexam;


interface CoffeeMaker {

    /**
     * U spremnik (npr. lonac, šerpa, dzezva) se dodaje hladna voda. Dodatno, ako je voda bila zagrijana, poziv ove metode ohladit ce postojecu vodu.
     * @param water u decilitrima
     */
    public void addWater(int water);

    /**
     * Ova ce metoda zagrijati vodu iz spremnika ako postoji vode u spremniku.
     */
    public void heatWater();

    /**
     * U spremnik se dodaje kava ako je voda zagrijana.
     * @param  coffeeSpoonNumber broj zlica kave koji se ubacuje u spremnik zagrijane vode
     */
    public void addCoffee(int coffeeSpoonNumber);

    /**
     * Za jednu šalicu kave potrebno je 1 decilitar ZAGRIJANE vode i 2 zlice kave.
     * Potrebno je istočiti određeni broj salica kave.
     * @param requestedCupsNumber traženi broj šalica kave
     * @return vraća broj šalica kave koje je priprematelj uspio istočiti (manje ili jednako traženom broju šalica).
     */
    public int pourCoffee(int requestedCupsNumber);

    /**
     * @return vraca trenutnu kolicinu vode iz spremnika u decilitrima.
     */
    public int getWaterAmount();

    /**
     * @return vraca trenutnu kolicinu kave iz spremnika u broju zlica.
     */
    public int getCoffeeSize();

    /**
     * @return vraca true ako je voda zagrijana inace vraca false. Trivijalno, ako nema vode u spremniku tada ova metoda vraca false.
     */
    public boolean isWaterHeated();
}