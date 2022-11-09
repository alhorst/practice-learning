package com.techelevator;


import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // make an object
        BankAccount account = new BankAccount("Bob",
                "11111", 1234);

        BankAccount account1 = new BankAccount("Sue",
                "22222");

        System.out.println("Sue's balance is " + account1.getBalance());


        // programming to the interface -- ArrayList is concrete class
        List<BankAccount> bankAccountList = new ArrayList<>(); // to group together BankAccount objects

        BankAccount[] bankAccountArray = new BankAccount[50];

        CheckingAccount checkingAccount = new CheckingAccount("Tom",
                "33333", 5000);
        System.out.println(checkingAccount.getAccountHolderName() + " " +
                checkingAccount.getAccountNumber() + " " + checkingAccount.getBalance());
        bankAccountList.add(checkingAccount);
        //  added an anonymous object
        bankAccountList.add(new SavingsAccount("Ann", "44444",
                200));
        checkingAccount.withdraw(600);
        System.out.println(checkingAccount.getAccountHolderName() + " " +
                checkingAccount.getAccountNumber() + " " + checkingAccount.getBalance());

        for (int i = 0; i < bankAccountList.size(); i++) {
            BankAccount item = bankAccountList.get(i);
            System.out.println(item.getAccountHolderName() + " " +
                    bankAccountList.get(i).getAccountNumber() + " " + bankAccountList.get(i).getBalance());

        }
    }
}
