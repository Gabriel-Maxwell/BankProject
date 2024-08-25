package br.com.maxwell.bank.domain;
import br.com.maxwell.bank.enums.TransactionType;

import java.time.LocalDateTime;
public class Transaction {

    private Account account;
    private TransactionType transactionType;
    private LocalDateTime dateTime;
    private double value;
    private double initialBalance;
    private double finalBalance;

    public Transaction(Account account, TransactionType transactionType, LocalDateTime dateTime, double value, double initialBalance, double finalBalance) {
        this.account = account;
        this.transactionType = transactionType;
        this.dateTime = dateTime;
        this.value = value;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getLocalDateTime() {
        return dateTime;
    }

    public Double getValue() {
        return value;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "Operação: " + transactionType +
                ", Data e Hora: " + dateTime +
                ", Valor: " + value +
                ", Saldo Inicial: " + initialBalance +
                ", Saldo Final: " + finalBalance +
                '}';
    }
}
