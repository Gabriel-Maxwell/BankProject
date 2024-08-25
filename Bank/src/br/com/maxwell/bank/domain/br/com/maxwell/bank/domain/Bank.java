package br.com.maxwell.bank.domain;
import br.com.maxwell.bank.enums.AccountType;
import br.com.maxwell.bank.utils.FormatterUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Bank {

    private List<Account> customerAccountsList;
    private List<Customer> customerList;
   

    public Bank() {
        this.customerList = new ArrayList<>();
        this.customerAccountsList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
    }   

    public void addAccountCustomer(Account account) {
        this.customerAccountsList.add(account);
    }

    public List<Account> getAccountList() {
        return customerAccountsList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer findCustomerByDocumentNumber(String documentNumber) {
        for (Customer customer : customerList) {
            if (customer.getDocumentNumber().equals(documentNumber)) {
                return customer;
            }

        }
        return null;
    }

    public Account findAccountById(int id) {
        for (Account account : customerAccountsList) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Bem vindo ao banco!\n");
        while (option != 7) {
            System.out.println("Selecione uma das opcoes abaixo:");
            System.out.println(" 1 - Cadastrar cliente ");
            System.out.println(" 2 - Cadastrar conta ");
            System.out.println(" 3 - Fazer deposito em conta ");
            System.out.println(" 4 - Fazer saque em conta");
            System.out.println(" 5 - Extrato de conta ");
            System.out.println(" 6 - Lista de clientes do banco ");
            System.out.println(" 7 - Sair ");
            System.out.println(" Digite a opcao desejada: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> //Cadastrar cliente
                    registerCustomer(sc, bank);
                case 2 -> //Cadastrar conta
                    registerAccount(sc, bank);
                case 3 -> //Fazer depósito em conta
                    makeDeposit(sc, bank);
                case 4 -> //Fazer saque em conta
                    makeWithdrawal(sc, bank);
                case 5 -> //Extrato de conta
                    showExtract(sc, bank);
                case 6 -> //Lista de clientes do banco
                    showAllAccountCustomers(bank);
                case 7 -> //Sair
                    System.exit(0);
                default ->
                    System.out.println("Opcao invalida");
            }

        }

    }

    private static void registerCustomer(Scanner sc, Bank bank) {
        System.out.println("Digite o nome do cliente: ");
        String name = sc.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String documentNumber = sc.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = sc.nextLine();
        Customer customer = new Customer(name, documentNumber, email);
        bank.addCustomer(customer);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void registerAccount(Scanner sc, Bank bank) {

        System.out.println("Informe o CPF do cliente: ");
        String documentNumber = sc.nextLine();
        Customer customer = bank.findCustomerByDocumentNumber(documentNumber);
        if (customer == null) {
            System.out.println("Cliente nao encontrado: ");
            return;
        }

        System.out.println("Informe se o tipo da conta é Corrente(C) ou Poupança(P) ");
        String accountTypeString = sc.nextLine();
        AccountType accountType = AccountType.getAccountType(accountTypeString);
        System.out.println("Informe o saldo inicial: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Informe o limite da conta: ");
        double limit = sc.nextDouble();
        sc.nextLine();
        Account account = new Account(customer, accountType, balance, limit);

        account.setCustomer(customer);
        bank.addAccountCustomer(account);
        System.out.println("Conta  cadastrada com sucesso!");
    }

    private static void makeDeposit(Scanner sc, Bank bank) {
        Optional<Account> oppAccount = validateAccountAndCustomer(sc, bank);
        System.out.println("Informe o valor a ser depositado: ");
        double value = sc.nextDouble();
        sc.nextLine();
        if (oppAccount.isPresent()) {
            oppAccount.get().makeDeposit(value);
        }

    }

    private static void makeWithdrawal(Scanner sc, Bank bank) {
        Optional<Account> oppAccount = validateAccountAndCustomer(sc, bank);
        System.out.println("Informe o valor a ser sacado: ");
        double value = sc.nextDouble();
        sc.nextLine();
        if (oppAccount.isPresent()) {
            oppAccount.get().makeWithdrawal(value);
        }

    }

    private static void showExtract(Scanner sc, Bank bank) {
        Optional<Account> oppAccount = validateAccountAndCustomer(sc, bank);
        String date = FormatterUtils.formatValueToString(LocalDateTime.now());
        System.out.println(date);
        if (oppAccount.isPresent()) {
            System.out.println("O Saldo atual e: R$ " + FormatterUtils.formatValueToString(oppAccount.get().getBalance()));
            System.out.println("O limite atual e: R$ " + FormatterUtils.formatValueToString(oppAccount.get().getLimit()));
            System.out.println(oppAccount.get().getTransactions());
        }
    }

    private static void showAllAccountCustomers(Bank bank) {

        System.out.println(bank.getAccountList());
    }

    private static Optional<Account> validateAccountAndCustomer(Scanner sc, Bank bank) {
        System.out.println("Informe o CPF do cliente para deposito");
        String documentNumber = sc.nextLine();
        Customer customer = bank.findCustomerByDocumentNumber(documentNumber);
        if (customer == null) {
            System.out.println("Cliente nao encontrado. ");
            return Optional.empty();
        }
        System.out.println("Informe o Numero da conta: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        Account account = bank.findAccountById(accountNumber);
        if (account == null) {
            System.out.println("Conta nao encontrada. ");
            return Optional.empty();
        }
        if (!customer.equals(account.getCustomer())) {
            System.out.println("Cliente da conta nao corresponde ao cliente com documento fornecido. ");
            return Optional.empty();
        }
        return Optional.of(account);
    }
}
