/**
 * Created by chenhao on 11/13/15.
 */

import java.net.URL;
public class Main {
    public static void main(String[] args){

//        ReceiptCatalog catalog=new ReceiptCatalog();
//        Receipt receipt=new Receipt();
//        catalog.add(receipt);

        String clerkName="Tom";
        ProductInfoList proList = new ProductInfoList();
        DataTransition data = new DataTransition();
        String str =new String("/TXT/OldRecord.txt") ;
        proList = data.generateProListFromFile(Main.class.getResource(str).getFile());

        String str1 =new String("/TXT/ClerkInfo.txt") ;
        ClerkList clerkList;
        clerkList = data.generateClerkList(Main.class.getResource(str1).getFile());

        ReceiptCatalog receiptCatalog= new ReceiptCatalog();
        receiptCatalog = data.generateReceiptCatalog(proList);

        MonthSaleCalculator monthSaleCalculator=new MonthSaleCalculator(receiptCatalog,clerkList);

        monthSaleCalculator.getMonthSaleCalculatorResult(1,11,clerkName);//Tom number 1 product sold in 11

        PercentageCounter percentageCounter=new PercentageCounter(receiptCatalog,clerkList);
        percentageCounter.getPercentageCounterResult(clerkName,11);



    }
}
