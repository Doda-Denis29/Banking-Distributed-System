package Bank;

import java.util.Random;
import _Utils_._RandomGenerator_;
import _Utils_._Logger_;

import javax.swing.*;

public class Bank {
    private String bankCode, nameBank;
    private int pinCode;
    private _RandomGenerator_ randomGenerator = new _RandomGenerator_();
    private double amount = 0;
    private _Logger_ logger;

    public enum CurrencyType {
        EUR,
        RON,
        FRA,
        LIR,
        USD,
        YEN,
        FOR
    };

    protected CurrencyType currencyType;

    public Bank(double sum, CurrencyType currencyType_, String nameBank_) throws bankException {
        this.bankCode = randomGenerator.generateRandomString();
        this.currencyType = currencyType_;
        this.nameBank = nameBank_;
        this.pinCode = new Random().nextInt(9000) + 1000;
        deposit(sum);
        logger.logDebug("Created " + getClass());
    }

    public void deposit(double sum) throws bankException {
        if(sum < 0) {
            logger.logWarning("Trying to deposit negative money");
            throw new bankException("Error, trying to deposit negative money");
        }
        this.amount = sum;
    }

    public void retrieve(double sum) throws bankException {
        if(sum > amount) {
            logger.logWarning("Trying to withdraw more money then available");
            throw new bankException("Error, trying to retrieve more money then available");
        }
        this.amount = sum;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void completeBankCode(String appendedText) {
        String result = "_";
        for (Character firstPart : appendedText.toCharArray()) {
            if (firstPart == ' ' ) {
                break;
            }
            result += firstPart;
        }
        result += nameBank;
        result += currencyType;
        this.bankCode = this.bankCode + String.join(" ", result);
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getNameBank() {
        return nameBank;
    }

    public String toString() {
        return "Bank: code= " + bankCode + ", name of the bank "+ nameBank + ", amount= " + amount + ", pincode is " + pinCode + ", Currency is " + currencyType;
    }
}
