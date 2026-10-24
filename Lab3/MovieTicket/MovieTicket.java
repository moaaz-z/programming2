package Lab3.MovieTicket;

public class  MovieTicket {
        private String ticketId;
        private String movieName;
        private String customerName;
        private String seatNumber;
        private double price;
        private boolean booked;
        private double discountPercentage;
    public MovieTicket(String ticketId, String movieName, String customerName,String seatNumber, double price){
        this.ticketId=ticketId;
        this.movieName=movieName;
        this.customerName=customerName;
        this.seatNumber=seatNumber;
       if (price < 0) {
    throw new IllegalArgumentException("Price cannot be negative");//reject negative
        }

        this.price = price;
        this.booked=false;
        this.discountPercentage=0;
}
    public String getTicketId(){
        return ticketId;
    }
    public String getMovieName(){
        return movieName;
    }
    public String getCustomerName(){
        return customerName;
    }
        public String getSeatNumber() {
                return seatNumber;  
        }
        public double getPrice(){
                return price;
        }
        public boolean isBooked(){
                return booked;
        }
        public double getDiscountPercentage(){
                return discountPercentage; 
        }
        public void setCustomerName(String customerName){
                this.customerName=customerName;
        }
        public void setSeatNumber(String seatNumber){
                if (booked)return;
                else
                this.seatNumber=seatNumber;
        }
        public void bookTicket(){
                if (booked){
                  System.out.println("Ticket Already Bookeed.");
                  return;}
                if(price==0){
                        System.out.println("Price Is Not Elgible.");
                  return;}
                booked=true;
        }
        public void cancelBooking(){
                if(!booked){
                        System.out.println("Ticket Is Noot Booked");
                        return;
                }
                booked=false; 
        }
        public void applyDiscount(double discountPercentage){
                if(discountPercentage<=100&&discountPercentage>=0){
                this.discountPercentage=discountPercentage;}
                else{
                        System.out.println("Invalid Discount Percentage.");
                        return;
                }
        }
        public double calculateFinalPrice(){
                double finalPrice=price- price * (discountPercentage / 100);
                if(booked){
                double bookfee=(10.0/100)*finalPrice;
                return finalPrice+bookfee;}
                return finalPrice;
        }
   public void ticketInfo() {
        System.out.println("-----------Ticket Info-----------");
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Movie Name: " + movieName);
    System.out.println("Customer Name: " + customerName);
    System.out.println("Seat Number: " + seatNumber);
    System.out.println("Ticket Price: " + price);
    System.out.println("Booked: " + booked);
    System.out.println("Discount: " + discountPercentage + "%");
    System.out.println("Final Price: " + calculateFinalPrice());
    System.out.println("-----------------------------");
}

}

