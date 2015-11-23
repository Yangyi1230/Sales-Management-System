/**
 * Created by chenhao on 11/13/15.
 */

import java.net.URL;
public class Main {
    public static void main(String[] args){

//        ReceiptCatalog catalog=new ReceiptCatalog();
//        Receipt receipt=new Receipt();
//        catalog.add(receipt);

        ProductInfoList proList = new ProductInfoList();
        DataTransition data = new DataTransition();
        String str =new String("/TXT/OldRecord.txt") ;
        proList = data.generateProListFromFile(Main.class.getResource(str).getFile());

        ReceiptCatalog x= new ReceiptCatalog();
        x = data.generateReceiptCatalog(proList);

    }
}
