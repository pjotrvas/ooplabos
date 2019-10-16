package hr.fer.oop.lab1.prob2;


/**
 * This program takes 3 arguments from the command line;
 * the real and imaginary part of a complex number and the root to be calculated.
 * The program calculates the roots of the given complex number and prints them.
 */


public class Roots {

    /**
     * The main method. Requies 3 arguments.
     * @param args real part, imaginary part, root
     */

    public static void main(String[] args){

       double realPart;
       double imaginaryPart;
       int root;

        if (args.length != 3){
            System.out.println("Requires 3 arguments.");
            return;
        }

        realPart = Double.parseDouble(args[0]);
        imaginaryPart = Double.parseDouble(args[1]);
        root = Integer.parseInt(args[2]);

        if (root <= 1){
            System.out.println("The root must be a positive integer greater than 1.");
            return;
        }

        System.out.printf("Your requested calculation of %d roots. Soulutions are \n", root);
        getRoots(realPart, imaginaryPart, root);
    }

    /**
     * This method calculates and prints the nth root of a complex number using De Moivre's Formula.
     * @param realPart real part of a complex number
     * @param imaginaryPart imaginary part of a complex number
     * @param n nth root to calculate
     * @see <a href="https://en.wikipedia.org/wiki/De_Moivre%27s_formula#Roots_of_complex_numbers">De Moivre's Formula</a>
     *
     */

    private static void getRoots(double realPart, double imaginaryPart, int n) {
        double r = Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
        double theta = Math.atan2(imaginaryPart , realPart);

        double real;
        double img;

        for (int j = 0; j < n; j++) {
            real = Math.pow(r , 1.0 / n) * Math.cos((theta + 2 * j * Math.PI) / n);
            img = Math.pow(r , 1.0 / n) * Math.sin((theta + 2 * j * Math.PI) / n);

            printRoot(real , img , j);
        }
    }

    /**
     * Prints a given complex number in a formatted fashion
     * @param realPart real part of a complex number
     * @param imaginaryPart imaginary part of a complex number
     * @param n nth solution of the given root
     */
    private static void printRoot(double realPart, double imaginaryPart, int n){
        char sign;
            if (imaginaryPart >= 0){
                sign = '+';
            }
            else {
                sign = '-';
                imaginaryPart = Math.abs(imaginaryPart);
            }

            System.out.printf("%d) %.3f %c %.3fi\n", n+1, realPart, sign, imaginaryPart);

    }
}
