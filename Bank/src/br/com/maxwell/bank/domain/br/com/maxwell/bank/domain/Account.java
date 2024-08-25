package br.com.maxwell.bank.domain;

import br.com.maxwell.bank.enums.AccountType;

public class Account {

    private static int nextNumber = 1;
    private int id;
    private Customer customer;
    private AccountType accountType;
    private double balance;
    private double limit;
    // private List<Transaction> transactions;

    public Account(Customer customer, AccountType accountType, double balance, double limit) {

        this.customer = customer;
        this.id = nextNumber++;
        this.accountType = accountType;
        this.balance = balance;
        this.limit = limit;

    }

    public void makeDeposit(double value) {
        if (value <= 0) {
            System.out.println("Valor invalido para deposito");

        } else {
            this.balance += value;
            System.out.println("Deposito realizado com sucesso!");

        }
    }

    public void makeWithdrawal(double value) {
        if (value <= 0) {
            System.out.println("Valor para saque invalido");

        } else if (value > balance + limit) {
            System.out.println("Saldo insuficiente");

        } else {
            this.balance -= value;
            if (this.balance < 0) {
                this.limit += this.balance;
                this.balance = 0;
            }
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public int getNumber() {
        return nextNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public double getLimit() {
        return limit;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "\nThe Account number is: " + id
                + "\nThe custumer is: " + customer
                + "\nThe type of this account is: " + accountType
                + "\nThe balance is: " + balance
                + "\nThe limit is: " + limit;
    }
}
