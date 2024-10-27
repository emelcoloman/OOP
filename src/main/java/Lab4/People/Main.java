package Lab4.People;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200, 21, "Denmark") );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki", 18, "Denmark","523512556") );
        printDepartment(people);
    }

}
