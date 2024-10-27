package Lab4.People;
public class Teacher extends Person{
    private int salary;
    public Teacher(String firstName, String lastName, int salary, int age, String country) {
        super(firstName, lastName, age, country);
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + "\nSalary: " + salary;
    }



    public static void main(String[] args) {
        Lab4.People.Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200, 30, "Sweden");
        Lab4.People.Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400, 22, "England");
        System.out.println( pekka );
        System.out.println( esko );




        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki",18,"Denmark", "523125321");
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println( olli );
    }

}

