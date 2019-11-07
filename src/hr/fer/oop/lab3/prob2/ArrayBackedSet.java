package hr.fer.oop.lab3.prob2;

import java.util.*;
import java.util.function.Consumer;

public class ArrayBackedSet<T> implements ISet<T> {

    private HashMap<T, Object> map;
    private static final Object PRESENT = new Object();

    public ArrayBackedSet () {
        map = new LinkedHashMap <>();
    }

    @Override
    public boolean isEmpty () {
        return map.isEmpty();
    }

    @Override
    public boolean contains ( Object elem ) {
       return map.containsKey(elem);
    }

    @Override
    public boolean add ( T elem ) {
       return map.put(elem, PRESENT) == null ;
    }

    @Override
    public boolean remove ( Object elem ) {
        return map.remove(elem) == PRESENT;
    }

    @Override
    public int size () {
        return map.size();
    }

    @Override
    public void clear () {
        map.clear();
    }


    @Override
    public Iterator <T> iterator () {
        return map.keySet().iterator();
    }

}
