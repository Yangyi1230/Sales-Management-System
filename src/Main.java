/**
 * Created by chenhao on 11/13/15.
 */

public class Main {
    public static void main(String[] args) {

        //test part
      /*DataTransition data = new DataTransition();
        ProductInfoList prolist = data.generateProListFromFile(Main.class.getResource("TXT/OldRecord.txt").getFile());
        ClerkList clerkList = data.generateClerkList(Main.class.getResource("TXT/ClerkInfoDB.txt").getFile());
        ProductList productInfoList = data.generateProductList(Main.class.getResource("TXT/ProductInfoDB.txt").getFile());
        AccountList accountList = data.generateAccountList();
        ReceiptCatalog list = data.generateReceiptCatalog(prolist);
        try{
            //data.SerialToFile(prolist);
            data.SerialToFile(prolist,list, clerkList, productInfoList,accountList);
        }catch(Exception e){
        }

        try{
            ClerkList l1 = data.SerialFromClerkList();
            ProductInfoList l2 = data.SerialFromProductInfoList();
            ReceiptCatalog l3 = data.SerialFromReceiptCatalog();
            ProductList l4 = data.SerialFromProductList();
            AccountList l5 = data.SerialFromAccountList();
        }catch(Exception e){
            e.printStackTrace();
        }*/

        AccountList accountList =null;

        try {
            DataTransition data = new DataTransition();
            accountList = data.SerialFromAccountList();

        }catch (Exception e){

        }

        LoginScreen loginScreen = new LoginScreen();
        LoginControl loginControl=new LoginControl(accountList,loginScreen);
        loginScreen.setControl(loginControl);
        java.awt.EventQueue.invokeLater( ()-> loginScreen.setVisible(true) );

    }
}