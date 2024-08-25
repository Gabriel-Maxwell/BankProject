package br.com.maxwell.bank.enums;

public enum AccountType {
    CURRENT("C"),
    SAVINGS("P");

    private String type;
    
    private AccountType(String type) {
        this.type = type;
    }

    public static AccountType getAccountType(String type) {
        switch (type) {
            case "C" -> {
                return  CURRENT;
            }
            case "P" -> {
                return SAVINGS;
            }
            default -> throw new RuntimeException("Tipo de conta invalido");
        }
    }
}
