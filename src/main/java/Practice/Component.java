package Practice;

class Component {
    private int serialNumber;
    private String name;
    private Manufacturer manufacturer;


    public enum Manufacturer {
        BMW,
        AUDI,
        GOLF
    }

    public Component(int serialNumber, String name, Manufacturer manufacturer){
        this.name = name;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }

    public String whichComponentAmI(){
        return "Component";
    }
}

class Wheel extends Component {
    private int diameter;

    public Wheel (int serialNumber, String name, Manufacturer manufacturer, int diameter){
        super(serialNumber, name, manufacturer);
        this.diameter = diameter;
    }

    public int getDiameter(){
        return diameter;
    }
    public void setDiameter(int diameter){
        this.diameter = diameter;
    }

    @Override
    public String whichComponentAmI(){
        return "Wheel";
    }
}

class Gearbox extends Component {
    private int numOfGears;

    public Gearbox (int serialNumber, String name, Manufacturer manufacturer, int numOfGears){
        super(serialNumber,name,manufacturer);
        this.numOfGears = numOfGears;
    }

    public int getNumOfGears(){
        return numOfGears;
    }

    public void setNumOfGears(int numOfGears){
        this.numOfGears = numOfGears;
    }

    @Override
    public String whichComponentAmI(){
        return "Gearbox";
    }
}
class Main {
    public static void main(String[] args) {
        // Create a Component
        Component component = new Component(12345, "Generic Component", Component.Manufacturer.AUDI);
        System.out.println("Component Name: " + component.getName());
        System.out.println("Serial Number: " + component.getSerialNumber());
        System.out.println("Manufacturer: " + component.getManufacturer());
        System.out.println("Which Component Am I? " + component.whichComponentAmI());
        System.out.println();

        // Create a Wheel
        Wheel wheel = new Wheel(123456, "Front Wheel", Component.Manufacturer.BMW, 20);
        System.out.println("Wheel Name: " + wheel.getName());
        System.out.println("Serial Number: " + wheel.getSerialNumber());
        System.out.println("Manufacturer: " + wheel.getManufacturer());
        System.out.println("Diameter: " + wheel.getDiameter());
        System.out.println("Which Component Am I? " + wheel.whichComponentAmI());
        System.out.println();

        // Create a Gearbox
        Gearbox gearbox = new Gearbox(12347, "6-Gear-Shift", Component.Manufacturer.GOLF, 6);
        System.out.println("Gearbox Name: " + gearbox.getName());
        System.out.println("Serial Number: " + gearbox.getSerialNumber());
        System.out.println("Manufacturer: " + gearbox.getManufacturer());
        System.out.println("Number of Gears: " + gearbox.getNumOfGears());
        System.out.println("Which Component Am I? " + gearbox.whichComponentAmI());
    }
}