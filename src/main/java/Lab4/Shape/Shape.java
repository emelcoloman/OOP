package Lab4.Shape;


public class Shape {
    private String color;
    private Filltype filltype;

    public enum Filltype {
        FILLED,
        NOT_FILLED
    }


    public Shape(String color, Filltype filltype) {
        this.color = color;
        this.filltype = filltype;
    }
    public void displayInfo() {
        System.out.println("Color: " + color + " Filltype: " + filltype);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Filltype getFilltype() {
        return filltype;
    }
    public void setFilltype(Filltype filltype) {
        this.filltype = filltype;
    }
}


