package Lab3.VehicleRentSystem.Motorcycle;

import Lab3.VehicleRentSystem.VehicleRent;

public class Motorcycle extends VehicleRent {
    private int engineCapacity;

    public Motorcycle(String registrationNumber, String brand, double pricePerDay, int engineCapacity) {
        super(registrationNumber, brand, pricePerDay);
        if (engineCapacity <= 0)
            throw new IllegalArgumentException("Seats must be positive");
        this.engineCapacity = engineCapacity;
    }
    public int getengineCapacity(){
        return engineCapacity;
    }
    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0)
            throw new IllegalArgumentException("Days must be positive");

        return getPricePerDay() * days + 50;
    }
}
