package hr.fer.oop.lab3.prob2;


public class test {

    public static void main(String[] args) {
        ISet<String> set = new ArrayBackedSet <>();

        System.out.println(set.add("Ana"));
        System.out.println(set.add("Janko"));
        System.out.println(set.add("Ana"));
        System.out.println(set.add("Zora"));
        System.out.println(set.size());

        for (String ime: set) {
            System.out.println(ime);
        }
    }
}
