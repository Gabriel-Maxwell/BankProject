package br.com.maxwell.bank.domain;
import br.com.maxwell.bank.enums.TransactionType;
import br.com.maxwell.bank.utils.FormatterUtils;

import java.time.LocalDateTime;
public class Transaction {

    private Account account;
    private TransactionType transactionType;
    private LocalDateTime dateTime;
    private Double value;
    private Double initialBalance;
    private Double finalBalance;

    public Transaction(Account account, TransactionType transactionType, LocalDateTime dateTime, Double value, Double initialBalance, Double finalBalance) {
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

    public Double getInitialBalance() {
        return initialBalance;
    }

    public Double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(Double finalBalance) {
        this.finalBalance = finalBalance;
    }

    @Override
    public String toString() {
        return  
                "\nOperação: " + transactionType +
                ",\nData e Hora: " + FormatterUtils.formatValueToString(dateTime) +
                ",\nValor: " + FormatterUtils.formatValueToString(value)  +
                ",\nSaldo Inicial: " + FormatterUtils.formatValueToString(initialBalance) +
                ",\nSaldo Final: " + FormatterUtils.formatValueToString(finalBalance) +
                "\n\n";
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
