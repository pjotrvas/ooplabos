package hr.fer.oop.lab3.prob2;

public interface ISet<T> extends Iterable<T> {

    boolean isEmpty();

    boolean contains(Object elem);

    boolean add(T elem);

    boolean remove(Object elem);

    int size();

    void clear();
}
