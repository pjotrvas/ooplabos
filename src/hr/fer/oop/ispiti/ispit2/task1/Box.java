package hr.fer.oop.ispiti.ispit2.task1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Box <T> {

    private List<T> elements;

    public Box(){
        elements = new LinkedList <>();
    }

    public Collection<T> getIteams(){
        return elements;
    }

    public void add(T ... elements){
        for (T element: elements) {
            this.elements.add(element);
        }
    }
}
