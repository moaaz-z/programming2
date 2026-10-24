package Lab3.DigitalWallet;

public class DigitalWallet {
    private String walletId;
    private String ownerName;
    private double balance;
    private int transactionCount=0;
    public DigitalWallet(String walletId, String ownerName, double balance){
        this.walletId=walletId;
        this.ownerName=ownerName;
        if (balance < 0) {
           throw new IllegalArgumentException("Balance cannot be negative");//reject negative and prevent creating the object in that condition
        }
        this.balance=balance;
    }
    public String getWalletId(){
        return walletId;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance(){
        return balance;
    }
    public int getTransactionCount(){
        return transactionCount;
    }
    public void setOwnerName(String ownerName) {
    if (ownerName != null && !ownerName.trim().isEmpty()) {// ownerName.trim().isEmpty() check owner name is not empty
        this.ownerName = ownerName;
    }else{
        System.out.println("Invalid Name");
    }
    }
    public void deposit(double amount){
        if (amount <=0){
            throw new IllegalArgumentException("Amount cannot be negative or zero");//reject negative and zero
        }
        this.balance+=amount;
        transactionCount++;
    }
    public boolean withdraw(double amount){
        if (amount<=0 || amount>balance){
            System.out.println("Invalid Amount");
            return false;
        }
        this.balance-=amount;
        transactionCount++;
        System.out.println("Amount "+amount+" Withdrawed Sucessfully");
        return true;
    }
    private double calculateTransactionFee(double amount){
        if (amount>0&&amount<500) {
            return 5;}
        else if (amount>=500&&amount<1000) {
            return 10;
            
        } else {
            return 15;
        }
    }
    public void transfer(DigitalWallet receiver, double amount){
        double fee = calculateTransactionFee(amount);
        if (receiver == null) {
          System.out.println("Invalid Receiver");
            return;
        }

        if (receiver == this) {
         System.out.println("Cannot transfer to the same wallet");
             return;
        }
        if (amount<=0 || this.balance<(amount+fee) ){
            System.out.println("Invalid Amount ");
            return;
        }
        this.balance-=(amount+fee);
        receiver.balance+=amount;
        transactionCount++;
        receiver.transactionCount++;
        System.out.println("Transaction Successfull");
    }




    public void walletInfo(){
        System.out.println("-----------Wallet Info-----------");
    System.out.println("Wallet ID: " + walletId);
    System.out.println("Owner Name: " + ownerName);
    System.out.println("Balance: " + balance);
    System.out.println("Number Of Transactions: " + transactionCount);
    System.out.println("-----------------------------");
    }
}
