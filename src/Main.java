
import BackEnd.UserDatabase;
import Bank.*;
import FrontEnd.SignUpPage;
import User.User;

import javax.swing.*;

public class Main {
    private static User test;
    private static UserDatabase userDatabase = UserDatabase.getInstance();
    protected static void populateDatabase() throws bankException {
        User user = new User("Giorno Giovanna", Bank.CurrencyType.EUR, "ALPHA");
        User user1 = new User("Andrei Iordache", Bank.CurrencyType.RON, "BRD");
        User user2 = new User("Andreea Petcu", Bank.CurrencyType.RON, "ING");
        User user3 = new User("Camelia Ivanescu", Bank.CurrencyType.RON, "BCR");
        User user4 = new User("Josh Frigollo", Bank.CurrencyType.FRA, "ING");
        User user5 = new User("Ovidiu Munteanu", Bank.CurrencyType.EUR, "BRD");
        User user6 = new User("Arthur Knight", Bank.CurrencyType.USD, "UNICREDIT");
        User user7 = new User("Dylan Waters", Bank.CurrencyType.LIR, "ALPHA");
        User user8 = new User("Kate Long", Bank.CurrencyType.LIR, "FIRSTBANK");
        User user9 = new User("Talya Hoffman", Bank.CurrencyType.FRA, "RAIFFEISEN");
        User user10 = new User("Asher White", Bank.CurrencyType.EUR, "RAIFFEISEN");
        User user11 = new User("Oliver Harris", Bank.CurrencyType.FOR, "TRANSILVANIA");
        User user12 = new User("Sofia Baker", Bank.CurrencyType.FOR, "CEC");
        User user13 = new User("Heyden Young", Bank.CurrencyType.YEN, "BRD");
        User user14 = new User("Matthew Gill", Bank.CurrencyType.USD, "FIRSTBANK");
        User user15 = new User("Tom Jefferson", Bank.CurrencyType.USD, "UNICREDIT");
        test = new User("Test", Bank.CurrencyType.EUR, "TEST");
        userDatabase.addEntry(user);
        userDatabase.addEntry(user1);
        userDatabase.addEntry(user2);
        userDatabase.addEntry(user3);
        userDatabase.addEntry(user4);
        userDatabase.addEntry(user5);
        userDatabase.addEntry(user6);
        userDatabase.addEntry(user7);
        userDatabase.addEntry(user8);
        userDatabase.addEntry(user9);
        userDatabase.addEntry(user10);
        userDatabase.addEntry(user11);
        userDatabase.addEntry(user12);
        userDatabase.addEntry(user13);
        userDatabase.addEntry(user14);
        userDatabase.addEntry(user15);
        userDatabase.addEntry(test);
    }
    public static void main(String[] args) throws bankException {
        populateDatabase();
        userDatabase.listEverything();
        SignUpPage signUpPage = new SignUpPage();
        ImageIcon sigunUpIcon = new ImageIcon("icons/def1.png");
        signUpPage.createBasic("Sign up", 350, 250, sigunUpIcon);
    }
}
