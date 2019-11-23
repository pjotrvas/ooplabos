package hr.fer.oop.ispiti.ispit1.task1;

public class DoubleTuple extends Tuple<Double> {

    public DoubleTuple(Double ... args){
        super(args);
    }

    public DoubleTuple(int size){
        super(size);
    }

    public DoubleTuple multiplayWith(double number){
        for (int i = 0; i < this.len(); i++) {
            this.set(i, number*this.get(i));
        }

        return this;
    }

    public static Tuple<Double> avg(Tuple<? extends Number> first, Tuple<? extends Number> second){
        Tuple<Double> tuple =  new Tuple <>(first.len());
        for (int i = 0; i < first.len(); i++) {
            tuple.set(i, (first.get(i).doubleValue()+second.get(i).doubleValue())/2);
        }
        return tuple;
    }
}
