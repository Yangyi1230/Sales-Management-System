
/**
 * Created by chenhao on 11/13/15.
 */

// calculate sale amount of each product for each salesclerk each month.
public class MonthSaleCalculator extends Transition {


    int getMonthSaleCalculatorResult(int proId, int month,String clerkName){
        int amount=0;
        ReceiptCatalog temp;

        temp=getClerkMonthRecord(month,clerkName);


        amount= getProTotalAmount(proId, temp);

//        System.out.println("MonthSaleCalculator result: " + amount);
        return amount;
    }

    public MonthSaleCalculator(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        super(rc, clerkList, productList);
    }
}
