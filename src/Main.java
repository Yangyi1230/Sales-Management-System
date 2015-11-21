/**
 * Created by chenhao on 11/13/15.
 */


public class Main {
    public static void main(String[] args){

//        ReceiptCatalog catalog=new ReceiptCatalog();
//        Receipt receipt=new Receipt();
//        catalog.add(receipt);

        ProductInfoList proList = new ProductInfoList();
        DataTransition data = new DataTransition();
        proList = data.generateProListFromFile("F:\\OldRecord.txt");

        ReceiptCatalog x= new ReceiptCatalog();


    }
}
