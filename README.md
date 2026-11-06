# Object-Oriented Programming and Problem Solving (Java)

[![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)](https://www.java.com/)
[![Paradigm](https://img.shields.io/badge/Paradigm-Object--Oriented-blue)](#)
[![Alexandria University](https://img.shields.io/badge/Coursework-Programming%202-green)](https://eng.alexu.edu.eg/)

Comprehensive implementations of Object-Oriented Programming (OOP) principles and algorithmic challenges in Java, developed during the Computer & Communication Engineering coursework at Alexandria University.

---

## Core Concepts Demonstrated

- Encapsulation: Private attributes, validated getter/setter mutators, and state security.
- Inheritance and Hierarchy: Extensible domain classes sharing common behaviors.
- Polymorphism: Method overriding and dynamic method dispatch across derived types.
- Abstraction: Abstract base classes (`VehicleRent`) establishing contractual interfaces for domain specializations.
- Algorithmic Problem Solving: Unit-tested implementations of classic array and string problems.

---

## Repository Structure

```text
programming2/
├── Lab3/ # Real-world system models
│ ├── DeliveryOrderSystem/
│ │ └── DeliveryOrder.java # Order dispatching & digital payment handling
│ ├── DigitalWallet/
│ │ └── DigitalWallet.java # Balance management & secure transfer operations
│ ├── MovieTicket/
│ │ └── MovieTicket.java # Seat allocation, pricing & ticket management
│ ├── VehicleRentSystem/
│ │ ├── VehicleRent.java # Abstract base rental model
│ │ ├── Car/Car.java # Car rental specialization
│ │ ├── Motorcycle/Motorcycle.java # Motorcycle rental specialization
│ │ └── Main/Main.java # Rental system test runner
│ └── Test/
│ └── OOPLab3.java # Unified integration test suite
│
├── Question1/ to Question4/ # Algorithmic exercise modules
│ ├── Question1/Exercise.java # General mathematical / array logic
│ ├── Question2/Exercise.java # swapNumbers implementation
│ ├── Question3/Exercise.java # twoSum target index lookup
│ └── Question4/Exercise.java # compressString run-length compression
│
├── Tests/
│ └── TestCases.java # Automated test validation suite
└── README.md # Repository documentation
```

---

## Key Systems and Solutions

### 1. Unified OOP Lab Systems (`Lab3/`)
- Digital Wallet: Supports safe deposit, withdrawal, balance checking, and peer-to-peer transfers with validation against insufficient funds.
- Delivery Order System: Links customer order details to a `DigitalWallet` instance to verify and debit payments automatically upon checkout.
- Vehicle Rent System: Abstract class `VehicleRent` defines base registration and daily pricing rules; overridden by `Car` (accommodating seating capacity metrics) and `Motorcycle` (factoring engine displacement).

### 2. Algorithmic Problem Solving
- `twoSum(int[] nums, int target)`: Finds the pair of array indices whose values sum to the target value.
- `compressString(String str)`: Performs run-length string compression (e.g., `"aabcccccaaa"` to `"a2b1c5a3"`).
- `swapNumbers(int first, int second)`: Swaps integer values returning the reordered pair.

---

## How to Compile and Run

### Compile all Java sources
```bash
javac Lab3/DigitalWallet/DigitalWallet.java Lab3/DeliveryOrderSystem/DeliveryOrder.java Lab3/MovieTicket/MovieTicket.java Lab3/VehicleRentSystem/VehicleRent.java Lab3/VehicleRentSystem/Car/Car.java Lab3/VehicleRentSystem/Motorcycle/Motorcycle.java Lab3/Test/OOPLab3.java
```

### Run Lab Integration Suite
```bash
java Lab3.Test.OOPLab3
```

### Run Algorithmic Tests
```bash
javac Question*/Exercise.java Tests/TestCases.java
java Tests.TestCases
```
