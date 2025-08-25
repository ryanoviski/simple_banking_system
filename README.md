# Banking System

## Overview
**Banking System** is a Java console application that simulates a simple banking system.  
It allows users to create accounts, deposit and withdraw money, transfer between accounts, and view account statements — all from an interactive console menu.

## Features
- Create new accounts (Checking or Savings)
- Deposit money into accounts
- Withdraw money (Checking accounts apply a small fee)
- Transfer money between accounts
- View account statements with updated balance
- Input validation for menu options and numeric values
- Error handling for insufficient balance or invalid accounts
- Continuous loop until the program is exited

## Technologies Used
- Java SE (Console Application)
- Object-Oriented Programming (OOP) with inheritance and method overriding
- Basic exception handling
- Java Collections Framework (`HashMap`) for account management
- Modern switch expressions (Java 14+)

## Requirements
- Java Development Kit (JDK) version **14 or higher** is required to compile and run this project.  
  (It uses the modern switch expression syntax introduced in Java 14).
- To check your Java version, run:
```bash
javac -version
```
```bash
java -version
```

## Installation
1. Clone the repository:
```bash
git clone https://github.com/ryanoviski/banking_system.git
```
2. Navigate to the project directory:
```bash
cd banking_system
```
3. Compile the Java files:
```bash
javac -d bin src/application/Main.java src/entities/Account.java src/entities/CheckingAccount.java src/entities/SavingsAccount.java src/services/BankingSystem.java
```
4. Run the program:
```bash
java -cp bin application/Main
```

## How to Use
- Upon running, you will see a menu with available options.
- Enter the number corresponding to the desired action.
- Provide the requested information (account number, holder name, amount).
- View results or confirmation messages in the console.
- The program will keep running until you choose to exit (option 6).

## Contributions
Contributions are welcome! Feel free to open issues or pull requests.

## License
This project is licensed under the MIT License (LICENSE).

## Contact
Ryan dos Santos — ryanoviski@gmail.com  
GitHub: [https://github.com/ryanoviski](https://github.com/ryanoviski)  
