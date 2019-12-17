package hr.fer.oop.lab4.third;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

public class Organizer {

    protected static class GradeList {

        protected final String student;
        protected Vector<Integer> grades = new Vector <>();

        public GradeList ( String student ) {
            this.student = student;
        }

        protected GradeList(String student, Integer grade) {
            this(student);
            this.grades.add(grade);
        }
    }

    private HashMap<String, GradeList> studentGrades = new LinkedHashMap <>();

    public void addGrade(String student, Integer grade){
        if (student == null || student.isEmpty()) throw new IllegalArgumentException();

        if (grade < 1 || grade > 5) throw new IllegalArgumentException();

        if (studentGrades.containsKey(student)) studentGrades.get(student).grades.add(grade);

        else  studentGrades.put(student, new GradeList(student, grade));
    }

    public List<Integer> getGrades(String student){
        if (student == null || student.isEmpty()) throw new IllegalArgumentException();

        if (!studentGrades.containsKey(student)) return null;

        else return new Vector <>(studentGrades.get(student).grades);
    }

    public LinkedHashMap<String, GradeList> getStudentGrades(){ return new LinkedHashMap <>(studentGrades); }
}

