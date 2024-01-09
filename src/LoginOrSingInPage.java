import models.ShoppingManager;
import models.User;
import view.WestminsterShoppingCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class LoginOrSingInPage extends JFrame {

    private JLabel conformPwordLbt;
    private JTextField conformPwordTxt;
    private JSeparator jSeparator2;
    private JButton loginBtn;
    private JLabel loginLbl;
    private JLabel newPwordLbl;
    private JTextField newPwordTxt;
    private JLabel newUnameLbl;
    private JTextField newUnameTxt;
    private JTextField pWordTxt;
    private JLabel pwordLbl;
    private JButton singInBtn;
    private JLabel singLbl;
    private JLabel uNameLbl;
    private JTextField uNameTxt;


    public LoginOrSingInPage() {
        // Set Window
        setWindow(760,440,"Westminster Shopping Center");

        // Set Body
        try {
            GUIBody();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void setWindow(int width, int height, String name) {
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
    }

    private void GUIBody() throws ParseException {

        jSeparator2 = new JSeparator();
        uNameLbl = new JLabel();
        pwordLbl = new JLabel();
        newUnameLbl = new JLabel();
        newPwordLbl = new JLabel();
        conformPwordLbt = new JLabel();
        uNameTxt = new JTextField();
        pWordTxt = new JTextField();
        newUnameTxt = new JTextField();
        newPwordTxt = new JTextField();
        conformPwordTxt = new JTextField();
        loginLbl = new JLabel();
        singLbl = new JLabel();
        loginBtn = new JButton();
        singInBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jSeparator2.setOrientation(SwingConstants.VERTICAL);

        uNameLbl.setText("User name:");

        pwordLbl.setText("Password:");

        newUnameLbl.setText("User name:");

        newPwordLbl.setText("Password:");

        conformPwordLbt.setText("Conform Password");

        uNameTxt.setText("");

        pWordTxt.setText("");

        newUnameTxt.setText("");

        newPwordTxt.setText("");

        conformPwordTxt.setText("");

        loginLbl.setText("Login");

        singLbl.setText("Sign in");

        loginBtn.setText("Login");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        singInBtn.setText("Sing in");
        singInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singInBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(pwordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(uNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(uNameTxt)
                                                        .addComponent(pWordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(loginLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(loginBtn)))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(123, 123, 123)
                                                .addComponent(singLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(singInBtn)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(conformPwordLbt, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                                                        .addComponent(newPwordLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(newUnameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(newUnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                                        .addComponent(newPwordTxt)
                                                                        .addComponent(conformPwordTxt))))))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(loginLbl)
                                                .addGap(65, 65, 65)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(uNameLbl)
                                                        .addComponent(uNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(pwordLbl)
                                                        .addComponent(pWordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(66, 66, 66)
                                                .addComponent(loginBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(singLbl)
                                                .addGap(61, 61, 61)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newUnameLbl)
                                                        .addComponent(newUnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newPwordLbl)
                                                        .addComponent(newPwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(conformPwordLbt)
                                                        .addComponent(conformPwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addComponent(singInBtn))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
        );
    }

    private void loginBtnActionPerformed(ActionEvent evt) {
        WestminsterShoppingManager wsm = new WestminsterShoppingManager();

        String name = uNameTxt.getText();
        String pass = pWordTxt.getText();
        boolean invalideLogin = false;


        if(name != null && !name.isEmpty() && pass != null && !pass.isEmpty()) {
            for (User u : wsm.getUserList()) {
                if(u.getUserName().equalsIgnoreCase(name.toLowerCase()) &&
                        u.getPassword().equalsIgnoreCase(pass.toLowerCase())) {
                    new WestminsterShoppingCenter(wsm.getProductList()).setVisible(true);
                    invalideLogin = false;
                    setVisible(false);
                    break;

                } else {
                    invalideLogin = true;
                }
            }

            if(invalideLogin) {
                showWarningDialog("Warning", "Invalid login details!");
            }

        } else {
            showWarningDialog("Warning", "Insert input correctly!");
        }
    }

    private void singInBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private static void showWarningDialog(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

}
