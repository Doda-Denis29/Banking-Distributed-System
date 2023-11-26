
import BackEnd.UserDatabase;
import Bank.*;
import User.User;

public class Main {
    public static void main(String[] args) throws bankException {
        User user = new User("Giorno Giovanna", Bank.CurrencyType.YEN, "BCR");
        User user1 = new User("Tester", Bank.CurrencyType.EUR, "BRD");
        UserDatabase userDatabase = UserDatabase.getInstance();
        userDatabase.listEverything();
    }
}
