package Lab3.VehicleRentSystem;

public abstract class  VehicleRent {
    private String registrationNumber;
    private String brand;
    private double pricePerDay;
    private boolean rented;
    
    
    public VehicleRent(String registrationNumber, String brand, double pricePerDay){
        if(registrationNumber==null||registrationNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid Registration Number.");}
        if(brand==null||brand.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid Brand.");
        }
        if(pricePerDay<=0){
            throw new IllegalArgumentException("Invalid Price.");
        }
        this.registrationNumber=registrationNumber;
        this.brand=brand;
        this.pricePerDay=pricePerDay;
        this.rented=false;
}
    public String getRegistrationNumber(){
        return registrationNumber;
    }
    public String getbrand(){
        return brand;
    }
    public double getPricePerDay(){
        return pricePerDay;
    }
    public boolean isRented(){
        return rented;
    }
     public abstract double calculateRentalCost(int days);
     public boolean rentVehicle(){
        if(rented){
            return false;
        }
        rented=true;
        return true;
     }
     public boolean returnVehicle() {
        if (!rented)
            return false;

        rented = false;
        return true;
    }
}
