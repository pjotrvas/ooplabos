package hr.fer.oop.lab1.prob1;

import java.util.Scanner;

/**
 * The program calculates the area and the perimeter of a given ractangle.
 * The parameters can be taken through a command line or through the key board while the program is running.
 * Arguments must be two non-negative real numbers, width and height.
 */

public class Rectangle {

    /**
     * The main method. Accpets two arguments - the width and height
     * of a rectangle and prints the area and perimeter of given ractangle.
     * @param args width and height from the command line, if given
     */

    public static void main(String[] args) {
        double width;
        double height;

        double area;
        double perimeter;

        if (args.length != 0){
            if (args.length != 2){
                System.out.println("Invalid number of arguments was provided.");
                return;
            }
            else {
                width = Double.parseDouble(args[0]);
                height = Double.parseDouble(args[1]);
            }
        }
        else {
            Scanner sc = new Scanner(System.in);
            width = getDimensions("width", sc);
            height = getDimensions("height", sc);

            sc.close();
        }

        area = calculateArea(height, width);
        perimeter = calculatePerimeter(height, width);

        System.out.printf("You have specified a rectangle of width %.2f and height %.2f." +
                "It's area is %.2f and its perimeter is %.2f", width, height, area, perimeter);
    }

    /**
     * Calculates the area of a rectangle
     * @param height height of a rectangle
     * @param width width of a rectangle
     * @return area of rectangle
     */

    public static double calculateArea(double height, double width){
        return height*width;
    }

    /**
     * Calculates the perimeter of a rectangle
     * @param height height of a rectangle
     * @param width width of a rectangle
     * @return perimeter of a rectangle
     */

    public static double calculatePerimeter(double height, double width){
        return (2*height + 2*width);
    }

    /**
     * Handles input of rectangle parameters through the keyboard
     * @param dim which dimensions, height or width
     * @param sc the Scanner object
     * @return input dimensions
     */

    public static double getDimensions(String dim, Scanner sc){
        String inputLine;
        double dimensions;

        while(true){
            System.out.printf("Please provide %s ", dim);
            inputLine = sc.nextLine().trim();

            if (inputLine.isEmpty()){
                System.out.println("The input must not be blank.");
                continue;
            }

            dimensions = Double.parseDouble(inputLine);

            if (dimensions < 0){
                System.out.println("The number must not be negative.");
                continue;
            }
            else {
                break;
            }
        }
        return dimensions;
    }
}
