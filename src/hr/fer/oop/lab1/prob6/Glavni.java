package hr.fer.oop.lab1.prob6;

import java.util.Scanner;

public class Glavni {

    static Scanner input = new Scanner(System.in);

    private static ListNode addToList(ListNode head, double value) {
        ListNode node = new ListNode();
        node.data = value;
        node.next = null;

        ListNode temp = head;

        if (head == null){
            head = node;
            return head;
        }

        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = node;

        return head;
    }

    private static int listSize(ListNode head){
        int counter = 0;

        while (head.next!=null){
            counter++;
            head = head.next;
        }

        return counter;
    }

    private static double calcAverage(ListNode head){
        double sum = 0;

        if (head == null){
            sum = 0;
            return sum;
        }

        else if (head.next == null){
            sum = head.data;
            return sum;
        }

        while (head.next != null){
            sum += head.data;
            head = head.next;
        }
        return sum/listSize(head);

    }

    private static void writeBiggerThan(ListNode head, double value){

    }

    public static void main(String[] args) {
        ListNode head = null;

        while (true) {
            if (input.hasNextDouble()) {
                double number = input.nextDouble();
                if (number < 0) break;
                else head = addToList(head, number);
            } else
                input.next();
        }

        if (listSize(head) < 1){
            System.out.println("Niste unijeli niti jedan number!");
            return;
        }

        double average = calcAverage(head);
        System.out.println("Prosjek unesenih numbereva je: " + average);

        System.out.println("Brojevi koji su veci od prosjeka su: ");
    //    writeBiggerThan(head, average);
    }
}

