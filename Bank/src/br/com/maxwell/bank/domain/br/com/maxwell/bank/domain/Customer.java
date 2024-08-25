package br.com.maxwell.bank.domain;
public class Customer {

    private String name;
    private String documentNumber;
    private String email;
    // private List<Account> accountList;

    public Customer(String name, String documentNumber, String email) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        // this.accountList = new ArrayList<>();      
    }

    // public void addAccount(Account account) {
    //     accountList.add(account);
    // }
    public String getName() {
        return name;
    }

    public void setString(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public Customer findCustomer() {
    //     if(this.documentNumber.equals(account.getID())) {
    //        return account.setCustomer(bank.);;
    //     } else {
    //         System.out.println("Invalid option: ");
    //     }
    // }
    public String toString() {
        return "\n{Name: " + name
                + "\nDocumentNumber: " + documentNumber
                + "\nE-mail: " + email + "}";
    }

}
