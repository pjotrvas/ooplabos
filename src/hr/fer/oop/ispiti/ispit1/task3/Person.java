package hr.fer.oop.ispiti.ispit1.task3;

public class Person {

    private  String name;
    private  String id;

    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getId () {
        return id;
    }

    public String getName () {
        return name;
    }
}
