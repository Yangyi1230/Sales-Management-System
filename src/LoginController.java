import javax.swing.*;
import java.awt.*;

/**
 * Created by chenhao on 12/1/15.
 */
public class LoginController {

    AccountList accountList;
    LoginScreenView loginScreenView;

    public LoginController() {
    }

    public LoginController(AccountList accountList, LoginScreenView loginScreenView) {
        this.accountList = accountList;
        this.loginScreenView = loginScreenView;
    }

    public void loginPressed() {

        for (Account account : accountList) {
            if (account.getUserName().equals(loginScreenView.accountField.getText()) && account.getPassword().equals(loginScreenView.passwordField.getText())) {
                SaleSystem saleSystem = new SaleSystem(account);
                JOptionPane.showMessageDialog(null, "Welcome: " + account.getClerkName() + " !", "", JOptionPane.PLAIN_MESSAGE);
                loginScreenView.setVisible(false);
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


