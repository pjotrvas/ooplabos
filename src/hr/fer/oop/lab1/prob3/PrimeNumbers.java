package hr.fer.oop.lab1.prob3;

public class PrimeNumbers {

    public static void main(String[] args){
        int numOfPrimeNum = Integer.parseInt(args[0]);

        int i = 0;
        int primNum = 2;

        System.out.printf("You requested calculation of first %d prime numbers. Here they are: \n", numOfPrimeNum);

        do {
            if (isPrime(primNum)){
                i++;
                System.out.println(i + ". " + primNum);
            }
            primNum++;
        }while (i < numOfPrimeNum);
    }

    private static boolean isPrime(int n){
        if (n == 2) return true;
        else if (n % 2 == 0) return false;
        else{
            for (int i = 3; i < Math.sqrt(n); i+=2)
                if (n % i == 0)
                    return false;
        }
        return true;
    }
}
