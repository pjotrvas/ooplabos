package hr.fer.oop.lab1.labzadatak;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FizzBuzzProblem {

    public static void main(String[] args){
        System.out.println(fizzbuzz(2, 20));
    }

    public static String fizzbuzz(int from, int to) {

        StringBuilder sb = new StringBuilder();

            for (int i = from; i <= to; i++) {

                if ((i % 3 == 0) && (i % 5 == 0)) {
                    sb.append("FizzBuzz, ");
                } else if (i % 3 == 0)
                    sb.append("Fizz, ");
                else if (i % 5 == 0)
                    sb.append("Buzz, ");

                else {
                    sb.append(i + ", ");
                }
            }

            String s = sb.toString();

        s = s.replaceAll(", $", "");
            return s;
        }

}
