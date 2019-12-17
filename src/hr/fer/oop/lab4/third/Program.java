package hr.fer.oop.lab4.third;

import java.util.*;

public class Program {

    static Organizer organizer;

    public static void main ( String[] args ) {
        organizer = new Organizer();

        try (Scanner sc = new Scanner(System.in)){
            while (sc.hasNextLine()){
                String line = sc.nextLine().trim();
                if (line.equals("KRAJ")) break;

                String[] parts = line.split("\\s");

                String student = parts[0];
                Integer grade = Integer.valueOf(parts[1]);

                organizer.addGrade(student, grade);
            }

            printStatistics();
        }
    }

    public static void printStatistics(){
        LinkedHashMap<String, Organizer.GradeList> allGrades = organizer.getStudentGrades();

        double average = 0;
        int count = 0;
        double deviation = 0;

        for (String student: allGrades.keySet()) {
            Vector<Integer> grades = allGrades.get(student).grades;
            HashSet<Integer> uniqueGrades = new HashSet <>(grades);

            System.out.println("Total grades for " + student + ": " + grades.size());

            System.out.print("Grades for " + student + ": ");

            for (Integer grade: grades) {
                System.out.print( grade + " ");
                average += grade;
                count++;
            }

            System.out.println();

            System.out.print("Unique grades for " + student + ": ");
            for (Integer grade: uniqueGrades) {
                System.out.print(grade + " ");
            }
            System.out.println();

            System.out.println("Average grade for " + student + ": " + (average/count));

            for (Integer grade: grades) {
                deviation += (average - grade) * (average - grade);
                deviation = Math.sqrt(deviation/count);
            }

            System.out.println("Deviation for " + student + ": " + deviation);

        }
    }
}
