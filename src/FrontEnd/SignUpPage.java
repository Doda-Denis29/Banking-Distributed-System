package FrontEnd;

import BackEnd.UserDatabase;
import _Utils_._Logger_;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage implements GUI, ActionListener {

    private static JFrame frame;
    private static JLabel bankCode, pin;
    private static JTextField bankCode_txt;
    private static JPasswordField pin_txt;
    private static JButton login_b, createAccount_b;
    private static JLabel suc;
    private _Logger_ logger = new _Logger_();
    private UserDatabase userDatabase = UserDatabase.getInstance();


    @Override
    public void createBasic(String nameFrame, int sizeX, int sizeY, ImageIcon icon) {
        frame = new JFrame(nameFrame);
        JPanel panel = new JPanel();
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.setIconImage(icon.getImage());

        bankCode = new JLabel("Bank code");
        bankCode.setBounds(10, 20, 80, 25);
        panel.add(bankCode);
        bankCode_txt = new JTextField(20);
        bankCode_txt.setBounds(100, 20, 165, 25);
        panel.add(bankCode_txt);

        pin = new JLabel("Pin");
        pin.setBounds(10, 50, 80, 25);
        panel.add(pin);
        pin_txt = new JPasswordField();
        pin_txt.setBounds(100, 50, 165, 25);
        panel.add(pin_txt);

        login_b = new JButton("Login");
        login_b.setBounds(100, 80, 80, 25);
        panel.add(login_b);

        createAccount_b = new JButton("Create a new account");
        createAccount_b.setBounds(100,110,170,25);
        panel.add(createAccount_b);

        suc = new JLabel("");
        suc.setBounds(100, 130, 300, 25);
        panel.add(suc);

        login_b.addActionListener(this);
        createAccount_b.addActionListener(this);
        frame.setVisible(true);
    }

    @Override
    public void endBasic() {
        this.frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user_ = bankCode_txt.getText();
        String pas = pin_txt.getText();

        if(e.getSource() == login_b) {
            if(pas.length() > 4) {
                logger.logError("Pin exceeds length");
            } else if (pas.length() == 0) {
                logger.logError("Pin is empty");
            } else {
                if(userDatabase.findUser(user_, Integer.parseInt(pas))) {
                    System.out.println("Logged in");
                } else {
                    System.out.println("Not logged in, user not exist");
                }
            }
        }
        if(e.getSource() == createAccount_b) {
            endBasic();
            CreateNewUser createNewUser = new CreateNewUser();
            ImageIcon createAccountIcon = new ImageIcon("icons/piggyBank.png");
            createNewUser.createBasic("Create account", 400, 300, createAccountIcon);
        }
    }
}
