package Lab3.VehicleRentSystem.Car;

import Lab3.VehicleRentSystem.VehicleRent;

public  class Car extends VehicleRent {
    private int numberOfSeats;

    public Car(String registrationNumber, String brand,
               double pricePerDay, int numberOfSeats) {

        super(registrationNumber, brand,pricePerDay);

        if (numberOfSeats <= 0)
            throw new IllegalArgumentException("Seats must be positive");

        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0)
            throw new IllegalArgumentException("Days must be positive");

        return getPricePerDay() * days + 100;
    }
}
