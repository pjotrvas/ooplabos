package hr.fer.oop.ispiti.ispit1.task1;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T> {

    private List<T> list;

    public Tuple (T ... args) {
       int i = 0;

       list = new ArrayList <>(args.length);

        for (T t: args) {
            list.add(t);
        }
    }

    public Tuple(int size){
        list = new ArrayList <>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
    }

    public T get(int index){
        return list.get(index);
    }

    public void set(int index, T value){
        list.set(index, value);
    }

    public int len(){
        return list.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append('(');
        for (T elem: list) {
            sb.append(elem);
            if (i < list.size() - 1) sb.append(',');
        }
        sb.append(')');

        return sb.toString();
    }
}
