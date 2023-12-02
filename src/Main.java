
import BackEnd.UserDatabase;
import Bank.*;
import FrontEnd.SignUpPage;
import User.User;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws bankException {
        User user = new User("Giorno Giovanna", Bank.CurrencyType.YEN, "BCR");
        User user1 = new User("Tester", Bank.CurrencyType.EUR, "BRD");
        UserDatabase userDatabase = UserDatabase.getInstance();
        userDatabase.listEverything();
        SignUpPage signUpPage = new SignUpPage();
        ImageIcon sigunUpIcon = new ImageIcon("icons/def1.png");
        signUpPage.createBasic("Sign up", 350, 250, sigunUpIcon);
    }
}
