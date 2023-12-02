package FrontEnd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewUser implements GUI, ActionListener {
    private static JFrame frame;
    private static JLabel user, passw;
    private static JTextField user_txt;
    private static JPasswordField passw_txt;
    private static JButton login_b, createAccount_b;
    private static JLabel suc;

    @Override
    public void createBasic(String nameFrame, int sizeX, int sizeY, ImageIcon icon) {
        frame = new JFrame(nameFrame);
        JPanel panel = new JPanel();
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.setIconImage(icon.getImage());
        user = new JLabel("User");
        user.setBounds(10, 20, 80, 25);
        panel.add(user);
        user_txt = new JTextField(20);
        user_txt.setBounds(100, 20, 165, 25);
        panel.add(user_txt);
        passw = new JLabel("Password");
        passw.setBounds(10, 50, 80, 25);
        panel.add(passw);
        passw_txt = new JPasswordField();
        passw_txt.setBounds(100, 50, 165, 25);
        panel.add(passw_txt);
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
