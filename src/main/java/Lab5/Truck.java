package Lab5;

public class Truck extends Vehicle implements Vehicle.Repairable{
    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    public Truck(String modelName) {
        super(modelName);
    }
    @Override
    public String repair() {
        return "Tire replacement and brake inspection performed for: " + getModelName();
    }
    @Override
    public String service() {
        return "Engine overhauled and tires replaced for " + getModelName() + "\n" + "Inspect brakes, check oil levels, and assess tire condition.\n" + "Current mileage: " + getMileage() + " miles\n" + "Health: " + getHealth() + "%";
    }
    @Override
    public int expectedLifespan() {
        return 300000;
    }
    public void haul(int loadWeight){


        int healthReduction = (loadWeight > 5000) ? 15 : 5; // Reduce health by 15% if over 5000 lbs, else 5%
        decreaseHealth(healthReduction);

        if (getHealth() < 30) {
            adjustedLifespan -= 20000; // Reduce remaining lifespan by 20,000 miles
            System.out.println("Health is low. Adjusted lifespan reduced by 20,000 miles.");
        }

        System.out.println("Hauling " + loadWeight + " pounds. Health reduced by " + healthReduction + "%.");
    }

}
