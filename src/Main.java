/**
 * Created by chenhao on 11/13/15.
 */

public class Main {
    public static void main(String[] args)throws  Exception{

//        ReceiptCatalog catalog=new ReceiptCatalog();
//        Receipt receipt=new Receipt();
//        catalog.add(receipt);

//        String clerkName="Tom";
        ProductInfoList proInfoList;
        DataTransition data = new DataTransition();
        String str =new String("/TXT/OldRecord.txt") ;
        proInfoList = data.generateProListFromFile(Main.class.getResource(str).getFile());
//
        String str1 =new String("/TXT/ClerkInfoDB.txt") ;
        ClerkList clerkList;
        clerkList = data.generateClerkList(Main.class.getResource(str1).getFile());

        String str2=new String("/TXT/ProductInfoDB.txt");
        ProductList productList;
        productList=data.generateProductList(Main.class.getResource(str2).getFile());

        ReceiptCatalog receiptCatalog= new ReceiptCatalog();
        receiptCatalog = data.generateReceiptCatalog(proInfoList);
//
//        MonthSaleCalculator monthSaleCalculator=new MonthSaleCalculator(receiptCatalog,clerkList,productList);
//
//        monthSaleCalculator.getMonthSaleCalculatorResult(1,11,clerkName);//Tom number 1 product sold in 11
//
//        PercentageCounter percentageCounter=new PercentageCounter(receiptCatalog,clerkList,productList);
//        percentageCounter.getProPercentageCounterResult(11, clerkName);
//
//        percentageCounter.getSalePercentageCounterResult(11, clerkName);
//
//        TotalSaleCalculator totalSaleCalculator=new TotalSaleCalculator(receiptCatalog,clerkList,productList);
//        totalSaleCalculator.getTotalSaleCalculator(1);
//
//        ReportProducer reportProducer=new ReportProducer(receiptCatalog,clerkList,productList);
//        reportProducer.generateReport(11);

//        String clerkName="Tom";
//        String or =new String("/TXT/OldRecord.txt") ;
//        String ci =new String("/TXT/ClerkInfoDB.txt") ;
//        String pid=new String("/TXT/ProductInfoDB.txt");
//        Transition.initial(pid, ci, or);
//
//        PercentageCounter percentageCounter=new PercentageCounter();
//        percentageCounter.getSalePercentageCounterResult(11,clerkName);
//        SaleSystem saleSystem=new SaleSystem();
//        saleSystem.reportProducer.generateReport(11);

        data.SerialToFile(proInfoList);
        data.SerialToFile(clerkList);
        data.SerialToFile(receiptCatalog);
        data.SerialToFile(productList);
        data.SerialFromClerkList();
        data.SerialFromProductList();
        data.SerialFromProductInfoList();
        data.SerialFromReceiptCatalog();
    }
}
