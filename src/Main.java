/**
 * Created by chenhao on 11/13/15.
 */

public class Main {
    public static void main(String[] args) {



        AccountList accountList =null;

        try {

            accountList = DataTransition.SerialFromAccountList();

        }catch (Exception e){

        }

        LoginScreen loginScreen = new LoginScreen();
        LoginControl loginControl=new LoginControl(accountList,loginScreen);
        loginScreen.setControl(loginControl);


        java.awt.EventQueue.invokeLater( ()-> loginScreen.setVisible(true) );

    }
}