package Lab4.People;

class Person {
    private String name;
    private String address;
    private int age;
    private String country;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public Person (String name, String address, int age, String country) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.country = country;
    }
    public String toString() {
        return name + "\n " + address + "\n Age: " + age + "\n Country: " + country;
    }

    public static void main(String[] args) {
        // Creating instances of the Person class
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 21, "Denmark");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki", 30, "United States of America");

        // Printing the person details
        System.out.println(pekka);
        System.out.println(esko);
    }
}



