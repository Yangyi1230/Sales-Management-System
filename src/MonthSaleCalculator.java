import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by chenhao on 11/13/15.
 */
public class MonthSaleCalculator extends Transition {


    int getMonthSaleCalculatorResult(int proId, int month,String clerkName){
        int amount=0;
        ReceiptCatalog temp=new ReceiptCatalog();

        temp=getClerkMonthRecord(month,clerkName,catalog);


        amount=getProAmount(proId,temp);

        System.out.println("MonthSaleCalculator result: " + amount);
        return amount;
    }

    public MonthSaleCalculator(ReceiptCatalog rc, ClerkList clerkList) {
        super(rc, clerkList);
    }
}
