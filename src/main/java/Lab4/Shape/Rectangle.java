package Lab4.Shape;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, Filltype filltype, double width, double height) {
        super(color, filltype);
        this.width = width;
        this.height = height;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Width: " + width + " Height: " + height);
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }

}
