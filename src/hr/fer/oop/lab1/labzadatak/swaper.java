package hr.fer.oop.lab1.labzadatak;

import java.util.Random;

public class swaper {


    static void swap(int[] arr){

        if(arr.length<2) return;


        int pozicija2 =(int)(Math.random() * arr.length) + 0;
        int pozicija3 =(int)(Math.random() * arr.length) + 0;

        int broj2 = arr[pozicija2];
        int broj3 = arr[pozicija3];

        for (int i = 0; i < arr.length; i++) {
            if (i == pozicija2){
                arr[i] = broj3;
            }
            if (i == pozicija3){
                arr[i] = broj2;
            }
        }

    }
}
