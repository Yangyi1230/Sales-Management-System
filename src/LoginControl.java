import sun.awt.resources.awt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chenhao on 12/1/15.
 */
public class LoginControl {

    AccountList accountList;
    LoginScreen loginScreen;

    public LoginControl() {
    }

    public LoginControl(AccountList accountList, LoginScreen loginScreen) {
        this.accountList = accountList;
        this.loginScreen = loginScreen;
    }

    public void loginPressed() {

        for (Account account : accountList) {
            if (account.getUserName().equals(loginScreen.accountField.getText()) && account.getPassword().equals(loginScreen.passwordField.getText())) {
                SaleSystem saleSystem = new SaleSystem(account);

                JOptionPane.showMessageDialog(null, "Welcome: " + account.getClerkName() + " !", "", JOptionPane.PLAIN_MESSAGE);
                loginScreen.setVisible(false);
                MainUI dialog = new MainUI(saleSystem);

                EventQueue.invokeLater(() -> {
                    dialog.pack();
                    dialog.setVisible(true);
                });


                return;

            }

        }

        JOptionPane.showMessageDialog(null, "用户名或密码错误", "", JOptionPane.ERROR_MESSAGE);

    }


}


