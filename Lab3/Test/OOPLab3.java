package Lab3.Test;
import Lab3.DeliveryOrderSystem.DeliveryOrder;
import Lab3.DigitalWallet.DigitalWallet;
import Lab3.MovieTicket.MovieTicket;

public class OOPLab3 {

    public static void main(String[] args) {
         //testCinema();
        //testWallet();
         testDelivery();
    }

    public static void testCinema(){
        // Normal ticket
        MovieTicket ticket1 =
                new MovieTicket("T001", "Interstellar", "Moaaz", "A5", 200);
        ticket1.ticketInfo();
        // Valid discount
        ticket1.applyDiscount(10);
        // Successful booking
        ticket1.bookTicket();
        // Repeated booking
        ticket1.bookTicket();
        // Try changing seat while booked
        ticket1.setSeatNumber("B7");
        ticket1.ticketInfo();
        // Cancel booking
        ticket1.cancelBooking();
        ticket1.ticketInfo();
        // Change seat after cancellation
        ticket1.setSeatNumber("B7");
        ticket1.ticketInfo();
        // Zero-price ticket
        MovieTicket freeTicket =
                new MovieTicket("T002", "Avatar", "Ahmed", "C3", 0);

        freeTicket.bookTicket();


        // Invalid discount
        MovieTicket ticket2 =
                new MovieTicket("T003", "Inception", "Ali", "D4", 300);
        ticket2.applyDiscount(150);}
         public static void testWallet(){
         DigitalWallet wallet1 =
                new DigitalWallet("W001", "Moaaz", 2000);
        DigitalWallet wallet2 =
                new DigitalWallet("W002", "Ahmed", 500);
        // Initial wallet information
        wallet1.walletInfo();
        wallet2.walletInfo();
        // Valid deposit
        wallet1.deposit(500);
        wallet1.walletInfo();
        // Invalid deposit
        try {
            wallet1.deposit(-100);
        } catch (IllegalArgumentException e) {
            // Invalid deposit rejected
        }
        wallet1.walletInfo();
        // Valid withdrawal
        wallet1.withdraw(300);
        wallet1.walletInfo();
        // Invalid withdrawal
        wallet1.withdraw(-50);
        wallet1.walletInfo();
        // Insufficient balance
        wallet2.withdraw(1000);
        wallet2.walletInfo();
        // Successful transfer
        wallet1.transfer(wallet2, 400);
        wallet1.walletInfo();
        wallet2.walletInfo();
        // Failed transfer because balance is not enough
        wallet2.transfer(wallet1, 5000);
        wallet1.walletInfo();
        wallet2.walletInfo();
        // Transfer to null
        wallet1.transfer(null, 100);

        // Transfer to the same wallet
        wallet1.transfer(wallet1, 100);
        // Fee boundary test: less than 500
        DigitalWallet wallet3 =new DigitalWallet("W003", "Ali", 5000);
        DigitalWallet wallet4 =new DigitalWallet("W004", "Omar", 0);
        wallet3.transfer(wallet4, 499);
        wallet3.walletInfo();
        wallet4.walletInfo();
        // Fee boundary test: exactly 500
        DigitalWallet wallet5 =
                new DigitalWallet("W005", "Youssef", 5000);
        DigitalWallet wallet6 =
                new DigitalWallet("W006", "Khaled", 0);
        wallet5.transfer(wallet6, 500);
        wallet5.walletInfo();
        wallet6.walletInfo();
        // Fee boundary test: exactly 1000
        DigitalWallet wallet7 =
                new DigitalWallet("W007", "Mostafa", 5000);
        DigitalWallet wallet8 =
                new DigitalWallet("W008", "Mahmoud", 0);
        wallet7.transfer(wallet8, 1000);
        wallet7.walletInfo();
        wallet8.walletInfo();}
        public static void testDelivery() {

    // ---------------- Cash Order ----------------

    DeliveryOrder cashOrder =
            new DeliveryOrder(
                    "O001",
                    "Moaaz",
                    "Alexandria",
                    3,
                    700
            );

    cashOrder.orderInfo();

    // Unpaid order should NOT be delivered
    cashOrder.deliverOrder();
    cashOrder.orderInfo();

    // Pay cash order
    cashOrder.payOrder();
    cashOrder.orderInfo();

    // Paid order should be delivered
    cashOrder.deliverOrder();
    cashOrder.orderInfo();

    // Cannot deliver the same order again
    cashOrder.deliverOrder();
    cashOrder.orderInfo();


    // ---------------- Wallet Order ----------------

    DigitalWallet wallet =
            new DigitalWallet(
                    "W001",
                    "Ahmed",
                    2000
            );

    DeliveryOrder walletOrder =
            new DeliveryOrder(
                    "O002",
                    "Ahmed",
                    "Cairo",
                    2,
                    800,
                    wallet
            );

    wallet.walletInfo();
    walletOrder.orderInfo();

    // Successful wallet payment
    walletOrder.payOrder();

    walletOrder.orderInfo();
    wallet.walletInfo();

    // Deliver after successful payment
    walletOrder.deliverOrder();
    walletOrder.orderInfo();


    // ---------------- Insufficient Wallet Balance ----------------

    DigitalWallet poorWallet =
            new DigitalWallet(
                    "W002",
                    "Ali",
                    100
            );

    DeliveryOrder failedOrder =
            new DeliveryOrder(
                    "O003",
                    "Ali",
                    "Tanta",
                    1,
                    600,
                    poorWallet
            );

    // Should fail because total cost is more than wallet balance
    failedOrder.payOrder();

    failedOrder.orderInfo();
    poorWallet.walletInfo();


    // ---------------- Delivery Cost Boundaries ----------------

    DeliveryOrder order499 =
            new DeliveryOrder(
                    "O004",
                    "Omar",
                    "Alexandria",
                    1,
                    499
            );

    order499.orderInfo();


    DeliveryOrder order500 =
            new DeliveryOrder(
                    "O005",
                    "Youssef",
                    "Alexandria",
                    1,
                    500
            );

    order500.orderInfo();


    DeliveryOrder order1000 =
            new DeliveryOrder(
                    "O006",
                    "Mahmoud",
                    "Alexandria",
                    1,
                    1000
            );

    order1000.orderInfo();


    // ---------------- Invalid Data ----------------

    try {
        DeliveryOrder invalidItems =
                new DeliveryOrder(
                        "O007",
                        "Mohamed",
                        "Cairo",
                        0,
                        500
                );
    }
    catch (IllegalArgumentException e) {
        // Invalid item count correctly rejected
    }


    try {
        DeliveryOrder invalidSubtotal =
                new DeliveryOrder(
                        "O008",
                        "Mohamed",
                        "Cairo",
                        2,
                        -100
                );
    }
    catch (IllegalArgumentException e) {
        // Negative subtotal correctly rejected
    }


    try {
        DeliveryOrder invalidCustomer =
                new DeliveryOrder(
                        "O009",
                        "",
                        "Cairo",
                        2,
                        500
                );
    }
    catch (IllegalArgumentException e) {
        // Invalid customer name correctly rejected
    }


    try {
        DeliveryOrder invalidAddress =
                new DeliveryOrder(
                        "O010",
                        "Mohamed",
                        "",
                        2,
                        500
                );
    }
    catch (IllegalArgumentException e) {
        // Invalid address correctly rejected
    }
}
    }

