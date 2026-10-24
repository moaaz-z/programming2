package Lab3.VehicleRentSystem.Main;

import Lab3.VehicleRentSystem.VehicleRent;
import Lab3.VehicleRentSystem.Car.*;
import Lab3.VehicleRentSystem.Motorcycle.*;

public class Main {
    public static void main(String[] args) {
        VehicleRent[] vehicles = {
            new Car("C101", "Toyota", 500, 5),
            new Motorcycle("M201", "Honda", 200, 150)
        };

        for (VehicleRent v : vehicles) {
            System.out.println("Registration: " + v.getRegistrationNumber());
            System.out.println("Cost for 3 days: " +
                               v.calculateRentalCost(3) + " EGP");
            System.out.println();
        }

        System.out.println("Renting car: " + vehicles[0].rentVehicle());
        System.out.println("Renting car again: " + vehicles[0].rentVehicle());

        System.out.println("Returning car: " + vehicles[0].returnVehicle());
        System.out.println("Renting car again: " + vehicles[0].rentVehicle());
    }
}
