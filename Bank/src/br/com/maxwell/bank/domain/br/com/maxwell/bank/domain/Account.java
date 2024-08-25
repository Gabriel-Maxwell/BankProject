package br.com.maxwell.bank.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.maxwell.bank.enums.AccountType;
import br.com.maxwell.bank.enums.TransactionType;
import br.com.maxwell.bank.utils.FormatterUtils;

public class Account {

    private static int nextNumber = 1;
    private int id;
    private Customer customer;
    private AccountType accountType;
    private double balance;
    private double limit;
    private List<Transaction> transactions;

    public Account(Customer customer, AccountType accountType, double balance, double limit) {

        this.customer = customer;
        this.id = nextNumber++;
        this.accountType = accountType;
        this.balance = balance;
        this.limit = limit;
        this.transactions = new ArrayList<>();

    }

    public void makeDeposit(double value) {
        if (value <= 0) {
            System.out.println("Valor invalido para deposito");
        } else {
            Transaction deposit = new Transaction(this, TransactionType.DEPOSITO, LocalDateTime.now(), value, this.balance, null);
            this.balance += value;
            deposit.setFinalBalance(this.balance);
            transactions.add(deposit);
            System.out.println("Deposito realizado com sucesso!");
        }
    }

    public void makeWithdrawal(double value) {
        if (value <= 0) {
            System.out.println("Valor para saque invalido");
        } else if (value > balance + limit) {
            System.out.println("Saldo insuficiente");
        } else {
            Transaction withdrawal = new Transaction(this, TransactionType.SAQUE, LocalDateTime.now(), value, this.balance, null);
            this.balance -= value;
            if (this.balance < 0) {
                this.limit += this.balance;
                this.balance = 0;
            }
            withdrawal.setFinalBalance(this.balance);
            transactions.add(withdrawal);
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
    

    public AccountType getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "\nThe Account number is: " + id
                + "\nThe custumer is: " + customer
                + "\nThe type of this account is: " + accountType
                + "\nThe balance is: " + FormatterUtils.formatValueToString(balance)
                + "\nThe limit is: " + FormatterUtils.formatValueToString(limit);
    }
}
