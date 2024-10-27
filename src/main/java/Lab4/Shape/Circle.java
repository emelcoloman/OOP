package Lab4.Shape;

public class Circle extends Shape {
    private double radius;
    public Circle(String color, Filltype filltype, double radius) {
        super(color, filltype);
        this.radius = radius;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Radius: " + radius);
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public int getArea(){
        return (int)(radius * radius);
    }

    public double calculateCircumference(double radius){
        return 2 * Math.PI * radius;
    }



}
