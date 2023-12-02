package FrontEnd;

import BackEnd.UserDatabase;
import Bank.Bank;
import Bank.bankException;
import User.User;
import _Utils_._Logger_;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewUser implements GUI, ActionListener {
    private static JFrame frame;
    private static JLabel name, bankName, currencyType, pin, pin_txt, bankCode, bankCode_txt;
    private static JTextField name_txt, bankName_txt;
    private static JButton back_b, createAccount_b;
    private static JComboBox<String> dropDownCurrency;
    private static JLabel suc;
    private static JPanel panel;
    private UserDatabase userDatabase = UserDatabase.getInstance();
    private _Logger_ logger = new _Logger_();

    @Override
    public void createBasic(String nameFrame, int sizeX, int sizeY, ImageIcon icon) {
        frame = new JFrame(nameFrame);
        panel = new JPanel();
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.setIconImage(icon.getImage());

        name = new JLabel("Full name");
        name.setBounds(7, 20, 80, 25);
        panel.add(name);
        name_txt = new JTextField(20);
        name_txt.setBounds(100, 20, 165, 25);
        panel.add(name_txt);

        bankName = new JLabel("Bank name");
        bankName.setBounds(7, 50, 80, 25);
        panel.add(bankName);
        bankName_txt = new JTextField(20);
        bankName_txt.setBounds(100, 50, 165, 25);
        panel.add(bankName_txt);

        String[] currencyOptions = {"EUR", "RON", "FRA", "LIR", "USD", "YEN", "FOR"};
        currencyType = new JLabel("Currency type");
        currencyType.setBounds(7, 80, 80, 25);
        panel.add(currencyType);
        dropDownCurrency = new JComboBox<>(currencyOptions);
        dropDownCurrency.setBounds(100, 80, 80, 25);
        panel.add(dropDownCurrency);

        pin = new JLabel("Generated pin");
        pin.setBounds(7, 110, 100, 25);
        panel.add(pin);
        pin_txt = new JLabel();
        pin_txt.setBounds(100, 110, 100, 25);
        panel.add(pin_txt);

        bankCode = new JLabel("Generated bank code");
        bankCode.setBounds(7, 140, 130, 25);
        panel.add(bankCode);
        bankCode_txt = new JLabel();
        bankCode_txt.setBounds(140, 140, 165, 25);
        panel.add(bankCode_txt);

        back_b = new JButton("Back");
        back_b.setBounds(100, 200, 80, 25);
        panel.add(back_b);

        createAccount_b = new JButton("Generate account");
        createAccount_b.setBounds(100,170,170,25);
        panel.add(createAccount_b);

        suc = new JLabel("");
        suc.setBounds(100, 130, 300, 25);
        panel.add(suc);

        back_b.addActionListener(this);
        createAccount_b.addActionListener(this);
        dropDownCurrency.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void endBasic() {
        this.frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name_ = name_txt.getText();
        String bankName_ = bankName_txt.getText();
        String currencyType_ = (String)dropDownCurrency.getSelectedItem();

        if(e.getSource() == back_b) {
            endBasic();
            SignUpPage signUpPage = new SignUpPage();
            ImageIcon sigunUpIcon = new ImageIcon("icons/def1.png");
            signUpPage.createBasic("Sign up", 350, 250, sigunUpIcon);
        }
        if (e.getSource() == createAccount_b) {
            if((name_.length() != 0 && bankName_.length() != 0) && (name_.length() <= 38 && bankName_.length() <= 38)) {
                try {
                    User newUser = new User(name_, Bank.CurrencyType.valueOf(currencyType_), bankName_);
                    pin_txt.setText(String.valueOf(newUser.getBank().getPinCode()));
                    bankCode_txt.setText(String.valueOf(newUser.getBank().getBankCode()));
                    userDatabase.addEntry(newUser);
                    userDatabase.listEverything();
                    logger.logInfo("Added a new user");
                } catch (bankException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                System.out.println("Bruh");
            }
        }
        if(e.getSource() == dropDownCurrency) {
            ((JComboBox)e.getSource()).getSelectedItem();
        }
    }
}
