/**
 * Created by chenhao on 11/13/15.
 */

public class Main {
    public static void main(String[] args) {
       //更新obj文件时使用
     /*  DataTransition d = new DataTransition();
       // ProductInfoList pro = d.generateProListFromFile();
        ProductList pl = d.generateProductList();
        try{
           // d.SerialToFile(pro);
            d.SerialToFile(pl);
        }catch(Exception e){
        }*/

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