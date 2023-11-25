
import Bank.*;
import User.User;

public class Main {
    public static void main(String[] args) throws bankException {
        User user = new User("Giorno Giovanna", Bank.CurrencyType.YEN);
        User user1 = new User("Tester", Bank.CurrencyType.EUR);
        System.out.println(user.getBank().toString());
        System.out.println(user1.getBank().toString());
    }
}
