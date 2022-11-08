package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if ((this.getBalance() - amountToWithdraw - 2) < 0) {
            return this.getBalance();
        }
         else if (this.getBalance() - amountToWithdraw >= 0 && this.getBalance() - amountToWithdraw < 150) {
            super.withdraw(amountToWithdraw + 2);
        }
         else if (this.getBalance() - amountToWithdraw > 0) {
            super.withdraw(amountToWithdraw);
        }
        return super.getBalance();
    }
}
