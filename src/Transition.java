import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class Transition {

    protected ReceiptCatalog catalog;

    protected ClerkList clerkList;

    Transition(){
        catalog = new ReceiptCatalog();
        clerkList=new ClerkList();
    }

    Transition(ReceiptCatalog rc, ClerkList clerkList){
        this.catalog=rc;
        this.clerkList=clerkList;
        System.out.println("Transition Construct complete ");
    }


    //    return ReceiptList of all record of certain clerkName in certain month
    ReceiptCatalog getClerkMonthRecord(int month, String clerkName, ReceiptCatalog rc){

        //initialise
        ReceiptCatalog monthReceipt=new ReceiptCatalog();

        Iterator iterator =rc.iterator();
        Receipt r;

        while(iterator.hasNext()){
            r=(Receipt)iterator.next();

            System.out.println(r.clerk.getName()+" "+r.date.getMonth());

            if(r.clerk.getName().equals(clerkName)&&r.date.getMonth()==month){
                monthReceipt.add(r);
            }
        }

        System.out.println(" getClerkMonthRecord complete ");

        return monthReceipt;
    }

    //    calculate certain product total sell amount by Id in the Receipt List rc
    int getProAmount(int proId,ReceiptCatalog rc)
    {
        int amount=0;

        Iterator iter=rc.iterator();
        while(iter.hasNext()){
            Receipt r=(Receipt)iter.next();
            amount+=r.getAmountById(proId);
        }

        System.out.println("getProAmount result: " + amount );
        return amount;

    }

}
