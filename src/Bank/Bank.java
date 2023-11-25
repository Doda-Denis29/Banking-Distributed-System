package Bank;

import java.util.Arrays;
import java.util.Random;
import _Utils_.RandomGenerator;

public class Bank {
    private String bankCode;
    private int pinCode;
    private RandomGenerator randomGenerator = new RandomGenerator();
    private double amount = 0;

    public enum CurrencyType {
        EUR,
        RON,
        FRA,
        LIR,
        DOL,
        YEN,
        FOR
    };

    protected CurrencyType currencyType;

    public Bank(double sum, CurrencyType currencyType_) throws bankException {
        this.bankCode = randomGenerator.generateRandomString();
        this.currencyType = currencyType_;
        this.pinCode = new Random().nextInt(9000) + 1000;
        deposit(sum);
        System.out.println("IT HAS BEEN CREATED " + getClass());
    }

    public void deposit(double sum) throws bankException {
        if(sum < 0) {
            throw new bankException("Error, trying to deposit negative money");
        }
        this.amount = sum;
    }

    public void retrieve(double sum) throws bankException {
        if(sum > amount) {
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
        this.bankCode = this.bankCode + String.join(" ", result);
    }

    public int getPinCode() {
        return pinCode;
    }

    public String toString() {
        return "Bank: code= " + bankCode + ", amount= " + amount + ", pincode is " + pinCode + ", Currency is " + currencyType;
    }
}
