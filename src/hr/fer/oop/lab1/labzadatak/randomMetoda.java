package hr.fer.oop.lab1.labzadatak;

public class randomMetoda {


    public double calculateAverage(int [] array){

        if (array.length == 0){return 0;}
        int sum = 0;

        int length = array.length;


        for (int i = 0; i < length; i++) {
            sum += array[i];
        }

        return (double)sum/array.length;


    }

}
