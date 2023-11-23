package Bank;

public class Bank {
    protected String bankCode;
    protected double amount = 0;

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

    protected Bank(String bankCode_, double sum, CurrencyType currencyType_) throws bankException {
        this.bankCode = bankCode_;
        this.currencyType = currencyType_;
        depose(sum);
    }

    public void depose(double sum) throws bankException {
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

    public String toString() {
        return "Bank: code= " + bankCode + ", amount= " + amount;
    }

    public String getBankCode() {
        return bankCode;
    }
}
