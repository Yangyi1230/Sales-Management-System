import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class PercentageCounter extends Transition {

//
    float getPercentageCounterResult(String clerk, int month, ReceiptCatalog rc){

        int total=0;
        float percent=0;

        Iterator iterator =clerkList.iterator();
        while(iterator.hasNext()){
            Clerk c=(Clerk)iterator.next();
            total+=getClerkTotalProAmountPerMonth(month,c.getName(),rc);
        }

        int clerkTotal=0;

        clerkTotal=getClerkTotalProAmountPerMonth(month,clerk,rc);

        percent= ((float)clerkTotal)/((float)total);

        percent=(float)(Math.round(percent*100)/100);//保留两位小数

        System.out.println("getPercentageCounterResult result: "+percent);
        return percent;
    }

//    get each clerk total sale product amount every month
    int getClerkTotalProAmountPerMonth(int month, String clerk, ReceiptCatalog rc){

        int total=0;

        ReceiptCatalog temp=getClerkMonthRecord(month,clerk,rc);

        Iterator iterator=temp.iterator();
        while(iterator.hasNext()){
            Receipt r=(Receipt) iterator.next();
            total+=r.getTotalProAmountPerReceipt();
        }

        System.out.println("getClerkTotalProAmountPerMonth result: "+total);

        return total;
    }
}
