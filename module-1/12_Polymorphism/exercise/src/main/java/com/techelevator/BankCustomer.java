package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addAccount(Accountable newAccount) {
        this.accounts.add(newAccount);
    }

    public Accountable[] getAccounts() {
        Accountable[] customerAccounts = new Accountable[accounts.size()];
        for (int i = 0; i < customerAccounts.length; i++) {
            customerAccounts[i] = accounts.get(i);
        }
        return customerAccounts;
    }

    public boolean isVip() {
        int balance = 0;
        for (int i = 0; i < accounts.size(); i++) {
          balance +=  accounts.get(i).getBalance();
        }
        return balance >= 25000;
    }
}
