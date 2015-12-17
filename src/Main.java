/**
 * Created by chenhao on 11/13/15.
 */

public class Main {
    public static void main(String[] args) {


        AccountList accountList =null;

        try {
            DataTransition data = new DataTransition();
            accountList = data.SerialFromAccountList();

        }catch (Exception e){

        }

        LoginScreenView loginScreenView = new LoginScreenView();
        LoginController loginController =new LoginController(accountList, loginScreenView);
        loginScreenView.setControl(loginController);
        java.awt.EventQueue.invokeLater( ()-> loginScreenView.setVisible(true) );

    }
}