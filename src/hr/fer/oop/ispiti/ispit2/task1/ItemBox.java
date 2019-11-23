package hr.fer.oop.ispiti.ispit2.task1;

import hr.fer.oop.ispiti.ispit2.task1.item.Item;

import java.util.Collection;
import java.util.Set;

public class ItemBox<T extends Item> extends Box<T>{

    public double boxValue() {
        double value = 0;
        Collection<T> items = getIteams();

        for (Item item: items){
            value += item.getNetSalePrice();
        }

        return value;
    }
}
