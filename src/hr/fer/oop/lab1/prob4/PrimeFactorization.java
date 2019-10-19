package hr.fer.oop.lab1.prob4;

/**
 * This program finds and prints the prime factorization of a number
 *
 */

public class PrimeFactorization {

    /**
     * The main method. It takes integer from the command line and prints out
     * the prime factors of given number
     * @param args a positive integer
     */

    public static void main(String[] args){

        int num = Integer.parseInt(args[0]);

        int counter = 1;
        int primen = 2;

        System.out.printf("Youu requested decomposition of number %d into prime factors. Here they are: \n", num);

        while (primen <= num){
            if (num % primen == 0) {
                System.out.println(counter + ". " + primen);
                counter++;
                num /= primen;
                primen = 1;
            }
            primen++;
        }
    }
}
