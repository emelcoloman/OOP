package Lab4.Shape;

public class Main {
    public static void main(String[] args) {
        Circle mycircle = new Circle("Red", Shape.Filltype.FILLED, 5.0);
        mycircle.displayInfo();

        Rectangle myrectangle = new Rectangle("Blue", Shape.Filltype.FILLED, 4.0, 6.0);
        myrectangle.displayInfo();
    }
}
