package hr.fer.oop.lab1.prob5;

public class Shapes {

    public static void main(String[] args){
        hourGlass();
        hexagon();
        System.out.println();
        cup();
        cap();
    }

    private static void hourGlass(){
        line();
        bowl();
        upsideDownBowl();
        line();
    }

    private static void hexagon(){
        upsideDownBowl();
        bowl();
    }

    private static void cup(){
        bowl();
        line();
    }

    private static void cap(){
        upsideDownBowl();
        line();
    }

    private static void line(){
        System.out.println("+--------+");
    }

    private static void bowl(){
        System.out.println("\\        /");
        System.out.println(" \\______/");
    }

    private static void upsideDownBowl(){
        System.out.println("  ______");
        System.out.println(" /      \\");
        System.out.println("/        \\");
    }

}
