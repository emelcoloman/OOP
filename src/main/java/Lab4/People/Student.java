package Lab4.People;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int credits;
    private int grade;
    private String student_id;
    private List<Integer> grades;

    public Student(String firstName, String lastName, int age, String Country, String student_id) {
        super(firstName, lastName, age, Country);
        this.student_id = student_id;
        this.grades = new ArrayList<>();
    }
    public String getStudentId(){
        return student_id;
    }
    public void setStudentId(String student_id){
        this.student_id = student_id;
    }
    public boolean addGrade(int grade){
        if (grade > 0 && grade < 100){
            this.grades.add(grade);
            return true;
        } else {
            return false;
        }
    }

    public int getCredits() {
        return credits;
    }
    public int credits() {
        return this.credits;
    }
    public void study(){
        this.credits++;
    }
    public String toString(){
        return super.toString() + "\nCredits: " + this.credits;
    }


    public static void main(String[] args) {
        Lab4.People.Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki", 18, "Denmark", "521345123");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        olli.addGrade(56);
        olli.addGrade(77);
        System.out.println("credits "+ olli.credits());
    }

}

