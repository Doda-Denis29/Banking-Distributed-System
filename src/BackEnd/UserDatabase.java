package BackEnd;

import User.User;
import _Utils_._Logger_;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    //BankCode -> PinCode
    private HashMap<String, Integer> Database;
    private static _Logger_ logger;

    private static UserDatabase userDatabaseInstance = null;

    public static synchronized UserDatabase getInstance() {
        if(userDatabaseInstance == null) {
            logger.logDebug("Created " + UserDatabase.class);
            userDatabaseInstance = new UserDatabase();
        }
        return userDatabaseInstance;
    }

    private UserDatabase() {
        logger.logDebug("Created " + getClass());
        Database = new HashMap<>();
    }

    public void addEntry(User user) {
        Database.put(user.getBank().getBankCode(), user.getBank().getPinCode());
        logger.logInfo("Added user: " + user);
    }

    public void removeEntry(User user) {
        Database.remove(user.getBank().getNameBank(), user.getBank().getPinCode());
        logger.logInfo("Removed user: " + user);
    }

    public void ChangePin(String bankCode, int pinCode, int newPinCode) {
        Database.replace(bankCode, pinCode, newPinCode);
        logger.logInfo("Changed the pin code for bankCode: " + bankCode);
    }

    public boolean findUser(String bankCode, int pinCode) {
        for (Map.Entry<String, Integer> entry : Database.entrySet()) {
            if((entry.getKey().equals(bankCode)) && (entry.getValue().equals(pinCode))) {
                return true;
            }
        }
        return false;
    }

    public void listEverything() {
        for(Map.Entry<String, Integer> entry : Database.entrySet()) {
            logger.logInfo("Bank code is " + entry.getKey() + ", pin code is " + entry.getValue());
        }
    }
}
