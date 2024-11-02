package Lab5;

public class Car extends Vehicle implements Vehicle.Repairable {
    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    public Car(String modelName) {
        super(modelName);
    }

    public String repair() {
        return "Engine tune and oil changed for: " + getModelName();
    }

    @Override
    public String service() {
        return "Service for product: " + getModelName() + "Checking engine, checking oil.\n" + "Current mileage" + getMileage() + "miles, Health: " + getHealth() + "%";
    }
    @Override
    public int expectedLifespan() {
        return 150000;
    }

    public void drive(int miles) {
        if (miles <= 0) {
            System.out.println("Miles driven must be positive.");
            return;
        }

        increaseMileage(miles);

        int healthReduction = (int) (miles * 0.01);
        decreaseHealth(healthReduction);

        if (getHealth() < 30) {
            adjustedLifespan -= 10000;
        }
    }

    @Override
    public int calculateRemainingLifespan() {
        return Math.max(0, adjustedLifespan - getMileage());
    }
}