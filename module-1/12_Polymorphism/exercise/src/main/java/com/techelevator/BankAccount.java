package com.techelevator;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        this.balance = balance + amountToDeposit;
        return this.balance;
    }

    public int withdraw(int amountToWithdraw) {
        this.balance = balance - amountToWithdraw;
        return this.balance;
    }

    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        this.balance = withdraw(transferAmount);
        destinationAccount.balance = destinationAccount.deposit(transferAmount);
        return this.balance;
    }
}
