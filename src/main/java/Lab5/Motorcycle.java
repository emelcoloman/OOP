package Lab5;

public class Motorcycle extends Vehicle {
    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    public Motorcycle(String modelName) {
        super(modelName);
    }
    public String repair() {
        return "Tire replacement and brake inspection performed for: " + getModelName();
    }

    @Override
    public String service() {
        return "Service procedure for Motorcycle model: " + getModelName() + "\n" + "Lubricate chain, tune engine, and check tire pressure.\n" + "Current mileage: " + getMileage() + " miles\n" + "Health: " + getHealth() + "%";
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }
    public void race(int raceMiles){
        increaseMileage(raceMiles);

        int healthReduction = (int) (raceMiles * 0.01);
        decreaseHealth(healthReduction);

        if (getHealth() < 40) {
            adjustedLifespan -= 5000; // Reduce remaining lifespan by 5,000 miles
            System.out.println("Health is low after racing. Adjusted lifespan reduced by 5,000 miles.");
        }

        System.out.println("Raced for " + raceMiles + " miles. Health reduced by " + healthReduction + "%.");
    }
}
