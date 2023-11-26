package FrontEnd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage implements GUI, ActionListener {

    private static JLabel user, passw;
    private static JTextField user_txt;
    private static JPasswordField passw_txt;
    private static JButton login_b, createAccount_b;
    private static JLabel suc;


    @Override
    public void createBasic(JFrame frame, float sizeX, float sizeY, ImageIcon icon) {
        frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        icon = new ImageIcon("icon/Chinease_funny.jpg");
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
    public void endBasic(JFrame frame) {
        frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user_ = user_txt.getText();
        String pas = passw_txt.getText();

        if(e.getSource() == login_b) {
            System.out.println("Logged in");
        }
        if(e.getSource() == createAccount_b) {
            System.out.println("Created account");
        }
    }
}
