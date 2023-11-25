package User;

import Bank.Bank;
import Bank.bankException;

public class User {
    private String name;
    private Bank bank;

    public User(String name_, Bank.CurrencyType currencyType) throws bankException {
        this.name = name_;
        bank = new Bank(0, currencyType);
        bank.completeBankCode(name_);
        System.out.println("IT HAS BEEN CREATED " +getClass());
    }

    public Bank getBank() {
        return this.bank;
    }
}
