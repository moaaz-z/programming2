package Lab3.DeliveryOrderSystem;

import Lab3.DigitalWallet.DigitalWallet;

public class DeliveryOrder {
     private String orderId;
     private String customerName;
     private String deliveryAddress;
     private int itemCount;
     private double subtotal;
     private boolean paid;
     private boolean delivered;
     private String paymentMethod;
     private DigitalWallet wallet;

    public DeliveryOrder(String orderId,String customerName,String deliveryAddress,int itemCount,double subtotal){
        if (customerName == null || customerName.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid customer name");
    }

    if (deliveryAddress == null || deliveryAddress.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid delivery address");
    }

    if (itemCount <= 0) {
        throw new IllegalArgumentException("Item count must be greater than zero");
    }

    if (subtotal < 0) {
        throw new IllegalArgumentException("Subtotal cannot be negative");
    }

        this.orderId=orderId;
        this.customerName=customerName;
        this.deliveryAddress=deliveryAddress;
        this.itemCount=itemCount;
        this.subtotal=subtotal;
        this.paid=false;
        this.delivered=false;
         this.paymentMethod = "Cash";
          this.wallet = null;
    }
     public DeliveryOrder(String orderId,String customerName,String deliveryAddress,int itemCount,double subtotal,DigitalWallet wallet){
        if (customerName == null || customerName.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid customer name");
    }

    if (deliveryAddress == null || deliveryAddress.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid delivery address");
    }

    if (itemCount <= 0) {
        throw new IllegalArgumentException("Item count must be greater than zero");
    }

    if (subtotal < 0) {
        throw new IllegalArgumentException("Subtotal cannot be negative");
    }
    if (wallet == null) {
    throw new IllegalArgumentException("Wallet cannot be null");
    }
        this.orderId=orderId;
        this.customerName=customerName;
        this.deliveryAddress=deliveryAddress;
        this.itemCount=itemCount;
        this.subtotal=subtotal;
         this.paid = false;
         this.delivered = false;
        this.paymentMethod = "Wallet";
        this.wallet = wallet;
    }
    public String getOrderId(){
        return orderId;
    }
public String getCustomerName(){
    return customerName;
}
public String getDeliveryAddress(){
    return deliveryAddress;
}
public int getItemCount(){
    return itemCount;
}
public double getSubtotal(){
    return subtotal;
}
public boolean isPaid(){
    return paid;
}
public boolean isDelivered(){
    return delivered;
}
public String getPaymentMethod(){
    return paymentMethod;
}
public DigitalWallet getWallet(){
    return wallet;
}
public void setCustomerName(String customerName){
     if (customerName == null || customerName.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid customer name");
    }
    this.customerName=customerName;
}
public void setDeliveryAddress(String deliveryAddress){
     if (deliveryAddress == null || deliveryAddress.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid delivery address");
    }
    this.deliveryAddress=deliveryAddress;
}
public void setItemCount(int itemCount){
    if (itemCount <= 0) {
        throw new IllegalArgumentException("Item count must be greater than zero");
    }
    this.itemCount=itemCount;
}
public void setSubtotal(double subtotal){
     if (subtotal < 0) {
        throw new IllegalArgumentException("Subtotal cannot be negative");
    }
    this.subtotal=subtotal;
}
private double calculateDeliveryCost(){
   if(subtotal<500){
    return 50;
   }
   else if(subtotal<1000){
    return 30;
   }
   else{
    return 10;
   }
}
public double calculateTotalCost(){
    return subtotal+calculateDeliveryCost();
}
public boolean payOrder(){
    if(isPaid()){
        System.out.println("Order Already Paid.");
        return false;
    }
    if(paymentMethod.equals("Cash")){
        this.paid=true;
        return true;
    }
    if(paymentMethod.equals("Wallet")){
       boolean successed= wallet.withdraw(calculateTotalCost());
       if(successed){
        paid=true;
        return true;
       }
    }
    return false;
}
public boolean deliverOrder(){
    if(!isPaid()){
        System.out.println("order Is Not Paid Yet.");
        return false;
    }
    if(isDelivered()){
        System.out.println("Order Is Delevired Before");
        return false;
    }
    this.delivered=true;
    return true;
}
public void orderInfo() {
    System.out.println("----------- Order Info -----------");
    System.out.println("Order ID: " + orderId);
    System.out.println("Customer Name: " + customerName);
    System.out.println("Delivery Address: " + deliveryAddress);
    System.out.println("Item Count: " + itemCount);
    System.out.println("Subtotal: " + subtotal);
    System.out.println("Delivery Cost: " + calculateDeliveryCost());
    System.out.println("Total Cost: " + calculateTotalCost());
    System.out.println("Payment Method: " + paymentMethod);
    System.out.println("Paid: " + paid);
    System.out.println("Delivered: " + delivered);
    System.out.println("----------------------------------");
}    
}
