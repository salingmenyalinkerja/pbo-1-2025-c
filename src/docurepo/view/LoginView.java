package docurepo.view;

import docurepo.controller.DocumentController;
import javax.swing.*;

public class LoginView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginView(DocumentController controller) {

        setTitle("Login Form");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(20, 20, 80, 25);
        add(l1);

        usernameField = new JTextField();
        usernameField.setBounds(110, 20, 150, 25);
        add(usernameField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(20, 60, 80, 25);
        add(l2);

        passwordField = new JPasswordField();
        passwordField.setBounds(110, 60, 150, 25);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(110, 95, 150, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            boolean success = controller.login(user, pass);

            if (success) {
                JOptionPane.showMessageDialog(this, "Login Berhasil!");
            } else {
                JOptionPane.showMessageDialog(this, "Login Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
