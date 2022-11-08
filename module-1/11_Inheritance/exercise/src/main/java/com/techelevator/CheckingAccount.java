package com.techelevator;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if (this.getBalance() >= amountToWithdraw) {
            super.withdraw(amountToWithdraw);
        }
        else if (this.getBalance() - amountToWithdraw > -100) {
            super.withdraw(amountToWithdraw + 10);
        }
        return super.getBalance(); //should this be super or this.getBalance? Is using super
        //better encapsulation because you can change the method in BankAccount and this will continue to work?
    }
}
