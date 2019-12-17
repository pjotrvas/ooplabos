package hr.fer.oop.randomtasks;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();


        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>(size);

        for(int i = 0; i < size; i++)  {
            int sizeOfRow = sc.nextInt();

            listOfLists.add(new ArrayList<Integer>(sizeOfRow));

            for(int j = 0; j < sizeOfRow; j++)
                listOfLists.get(i).add(sc.nextInt());
        }

        int numberOfWantedPositions = sc.nextInt();

        for(int i = 0; i < numberOfWantedPositions; i++){

            int x = sc.nextInt();
            int y = sc.nextInt();

            if(listOfLists.size() >= x && listOfLists.get(x-1).size() >= y)
                System.out.println(listOfLists.get(x-1).get(y-1));
            else{
                System.out.println("ERROR!");
            }
        }

    }

}



