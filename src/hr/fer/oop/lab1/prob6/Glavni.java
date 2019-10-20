package hr.fer.oop.lab1.prob6;

import java.util.Scanner;

public class Glavni {

    static Scanner input = new Scanner(System.in);

    private static ListNode addToList(ListNode head, double value) {

        if (head == null){
            head = new ListNode();
            head.data = value;
            head.next = null;
        }

        else {
            ListNode temp = head;

            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = new ListNode();
            temp.next.data = value;
            temp.next.next = null;
        }

        return head;
    }

    private static int listSize(ListNode head){
        int counter = 0;

        if (head == null){ return 0;}

        counter = 1;
        ListNode temp = head;

        while (temp.next!=null){
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    private static double calcAverage(ListNode head){

        if (head == null){
            return 0;
        }

        double sum = head.data;
        ListNode temp = head;

        while (temp.next != null){
            temp = temp.next;
            sum += temp.data;
        }

        return sum/listSize(head);

    }

    private static void writeBiggerThan(ListNode head, double value) {
        if (head == null) {
            return;
        }

        double average = calcAverage(head);
        ListNode temp = head;

        while (temp != null) {
            if (temp.data > average) { System.out.println(temp.data); }
                temp = temp.next;
            }
        }


    public static void main(String[] args) {
        ListNode head = null;

        while (true) {
            System.out.println("Upisite decimalni broj: ");
            if (input.hasNextDouble()) {
                double number = input.nextDouble();
                if (number < 0) break;
                else head = addToList(head, number);
            } else
                input.next();
        }

        if (listSize(head) < 1){
            System.out.println("Niste unijeli niti jedan broj!");
            return;
        }

        double average = calcAverage(head);
        System.out.println("Prosjek unesenih numbereva je: " + average);

        System.out.println("Brojevi koji su veci od prosjeka su: ");
        writeBiggerThan(head, average);
        input.close();
    }
}

