package Lab5;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;
    protected int adjustedLifespan;

    public Vehicle(String modelName){
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health){
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public String getModelName(){
        return modelName;
    }

    public int getMileage(){
        return mileage;
    }

    public int getHealth(){
        return health;
    }
    public void increaseMileage(int miles) {
        this.mileage += miles;
    }
    public void decreaseHealth(int amount) {
        this.health = Math.max(0, this.health - amount); // Ensure health doesn’t go below 0
    }

    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance(){
        if (health < 70) {
            return true;
        }
        else {
            return false;
        }
    }
    public int calculateRemainingLifespan(){
        int lifespan = expectedLifespan();

        if (health < 50){
            double healthfactor = health / 50;
            lifespan = (int) (lifespan * healthfactor);
        }
        return lifespan;
    }

    public void adjustHealthBasedOnMileage() {
        int lifespan = expectedLifespan();
        if (mileage > lifespan / 2) {
            decreaseHealth(5); // Reduce health by 5 points if mileage exceeds half of expected lifespan
        }
    }
    public interface Repairable {
        String repair();
    }
    public void simulateYear(){
        adjustHealthBasedOnMileage();
        adjustedLifespan = calculateRemainingLifespan();
    }
    public void performMaintenance(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println(car.repair());
            car.drive(100); // Example mileage for driving
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.println(truck.repair());
            truck.haul(6000); // Example load weight for hauling
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            System.out.println(motorcycle.repair());
            motorcycle.race(50); // Example mileage for racing
        }
    }
}
