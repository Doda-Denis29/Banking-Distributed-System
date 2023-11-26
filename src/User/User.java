package User;

import BackEnd.UserDatabase;
import Bank.Bank;
import Bank.bankException;
import _Utils_._Logger_;

public class User {
    private String name;
    private Bank bank;
    private _Logger_ logger;
    private UserDatabase userDatabase = UserDatabase.getInstance();

    public User(String name_, Bank.CurrencyType currencyType, String nameBank) throws bankException {
        this.name = name_;
        bank = new Bank(0, currencyType, nameBank);
        bank.completeBankCode(name_);
        logger.logDebug("Created " + getClass());
        userDatabase.addEntry(this);
    }

    public String toString() {
        return name + ", bank: " + bank.toString();
    }

    public Bank getBank() {
        return this.bank;
    }
}
