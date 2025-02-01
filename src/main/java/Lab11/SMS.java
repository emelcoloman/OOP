package Lab11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class InvalidStudentDataException extends Exception{
    public InvalidStudentDataException(String message) {
        super(message);
    }
}

class Student {
    private String id;
    private String name;
    private String university;
    private String department;
    private double GPA;

    public Student(String id, String name, String university, String department, double GPA){
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.GPA = GPA;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getUniversity(){
        return university;
    }
    public String getDepartment(){
        return department;
    }
    public double getGPA(){
        return GPA;
    }

    @Override
    public String toString(){
        return "Student name is: " + name + ", university of: " + university + ", department: " + department + ", GPA: " + GPA;
    }
}

class StudentSystem{
    private List<Student> students = new ArrayList<Student>();
    public StudentSystem(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) {
                    throw new InvalidStudentDataException("Invalid data format in CSV file");
                }
                String id = parts[0];
                String name = parts[1];
                String university = parts[2];
                String department = parts[3];
                double GPA = Double.parseDouble(parts[4]);

                Student student = new Student(id, name, university, department, GPA);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidStudentDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public StudentSystem(List<Student> students) {
        this.students = students;
    }

    public static List<Student> readStudents(String filename){
        List<Student> students = new ArrayList<Student>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length != 5){
                    throw new InvalidStudentDataException("Exception detected");
                }
                String id = parts[0];
                String name = parts[1];
                String university = parts[2];
                String department = parts[3];
                double GPA = Double.parseDouble(parts[4]);
                Student student = new Student(id, name, university, department, GPA);
                students.add(student);
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (InvalidStudentDataException e){
            System.err.println(e.getMessage());
        }
        return students;
    }
    public int noOfStudents(){
        return students.size();
    }
    public String getStudentById(String id){
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        return student.map(Student::getId).orElse(null);
    }
    public Student getHighestGPAStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        return students.stream()
                .max(Comparator.comparingDouble(Student::getGPA))
                .orElseThrow(() -> new EmptyStudentListException("List of students is empty."));
    }

    public Student getLongestNameStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }
        return students.stream()
                .max(Comparator.comparingInt(student -> student.getName().length()))
                .orElseThrow(() -> new EmptyStudentListException("List of students is empty."));
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException {
        for (Student student : students) {
            if (student.getGPA() < 6 || student.getGPA() > 10) {
                throw new InvalidStudentDataException("Read data has invalid rows.");
            }
        }
    }

}