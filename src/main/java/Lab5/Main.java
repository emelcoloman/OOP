package Lab5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();


        vehicles.add(new Car("Toyota Camry", 60000, 80));
        vehicles.add(new Truck("Freightliner", 120000, 90));
        vehicles.add(new Motorcycle("Harley Davidson", 25000, 70));

        System.out.println("Initial State:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
            System.out.println("Remaining lifespan: " + vehicle.calculateRemainingLifespan() + " miles");
            System.out.println();
        }
        System.out.println("After 1 Year:");
        for (Vehicle vehicle : vehicles) {
            vehicle.simulateYear();
            System.out.println(vehicle.service());
            System.out.println("Remaining lifespan: " + vehicle.calculateRemainingLifespan() + " miles");
            System.out.println();
        }
        System.out.println("Performing Maintenance:");
        for (Vehicle vehicle : vehicles) {
            vehicle.performMaintenance(vehicle); // Perform maintenance based on vehicle type
            System.out.println("Remaining lifespan after maintenance: " + vehicle.calculateRemainingLifespan() + " miles");
            System.out.println();
        }
    }
}