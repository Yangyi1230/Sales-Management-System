import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class PercentageCounter extends Transition {

    public PercentageCounter() {
    }

    float getProPercentageCounterResult(int month, String clerkName){
        
        int total=0;
        float percent=0;

        Iterator iterator =clerkList.iterator();
        while(iterator.hasNext()){
            Clerk c=(Clerk)iterator.next();
            total+=getClerkTotalProAmountPerMonth(month,c.getName());
        }

        int clerkTotal=0;

        clerkTotal=getClerkTotalProAmountPerMonth(month,clerkName);

//        System.out.println("clerkTotal: "+clerkTotal);
        percent= ((float)clerkTotal)/((float)total);
        percent=(float)Math.round(percent*10000)/10000;//保留两位小数
//        System.out.println("getProPercentageCounterResult result: " + percent);

        return percent;

    }

    public PercentageCounter(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        super(rc, clerkList, productList);
    }

    float getSalePercentageCounterResult(int month, String clerkName){
        int total=0;
        float percent=0;

        Iterator iterator =clerkList.iterator();
        while(iterator.hasNext()){
            Clerk c=(Clerk)iterator.next();
            total+=getClerkTotalSaleAmountPerMonth(month, c.getName());
        }

        float clerkTotal=0;

        clerkTotal= getClerkTotalSaleAmountPerMonth(month, clerkName);

        percent= ((float)clerkTotal)/((float)total);
        percent=(float)Math.round(percent*10000)/10000;//保留两位小数

        System.out.println("getSalePercentageCounterResult: "+percent);
        return percent;
    }

}
