package hr.fer.oop.lab2.demo;

import hr.fer.oop.lab2.FootballPlayer;
import hr.fer.oop.lab2.SimpleFootballPlayerCollectionImpl;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public class SimpleFootballPlayerCollectionTest2 {
    public static void main(String[] args){

        final int SIZE = 10;
        SimpleFootballPlayerCollection collection = new SimpleFootballPlayerCollectionImpl(SIZE);

        FootballPlayer player = new FootballPlayer("Ivan", "Hrvatska", 9,9, PlayingPosition.GK);
        FootballPlayer player2 = new FootballPlayer("Marko", "Hrvatska", 9,9, PlayingPosition.GK);
        FootballPlayer player3 = new FootballPlayer("Ivica", "Hrvatska", 9,9, PlayingPosition.GK);
        FootballPlayer player4 = new FootballPlayer("Luka", "Hrvatska", 9,9, PlayingPosition.GK);

        collection.add(player);
        collection.add(player2);
        collection.add(player3);
        collection.add(player4);


        String output = "";
        for ( FootballPlayer p: collection.getPLayers()) {
            if(p!=null)
                output += p.getName() + "\n";
        }
        System.out.println(output);

        ((SimpleFootballPlayerCollectionImpl) collection).remove(player);
        ((SimpleFootballPlayerCollectionImpl) collection).remove(player2);

        String output2 = "";
        for ( FootballPlayer p: collection.getPLayers()) {
            if(p!=null)
                output2 += p.getName() + "\n";
        }
        System.out.println(output2 );

    }
}
