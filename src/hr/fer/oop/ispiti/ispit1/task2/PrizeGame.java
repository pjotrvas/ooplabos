package hr.fer.oop.ispiti.ispit1.task2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class PrizeGame {

    private String name;
    private LocalDate drawDate;

    private Collection<Prize> prize;

    public PrizeGame ( String name , LocalDate drawDate ) {
        this.name = name;
        this.drawDate = drawDate;

        this.prize = new LinkedList <>();
    }

    public String getName () {
        return name;
    }

    public LocalDate getDrawDate () {
        return drawDate;
    }

    public Iterable<Prize> getPrizes(){
        return prize;
    }

    public Prize addPrize(String description, double value){
        Prize p = new Prize(description, value);
        prize.add(p);
        return p;
    }
}
