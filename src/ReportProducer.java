import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class ReportProducer extends Transition {

    public ReportProducer() {
    }

    public ReportProducer(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        super(rc, clerkList, productList);
    }

    void generateReport(int month){


        Iterator iterator=productList.iterator();
        while(iterator.hasNext()){
            Product proForName=(Product)iterator.next();
            System.out.print(proForName.getId()+"  ");
        }
        System.out.println();


        Iterator clerkIterator=clerkList.iterator();
        while(clerkIterator.hasNext()){
            Clerk clerk=(Clerk)clerkIterator.next();


            System.out.print(clerk.getName() + ":  ");
            ReceiptCatalog monthCatalog=getClerkMonthRecord(month,clerk.getName());

            int tempSaleAmount=0;

            Iterator proIterator=productList.iterator();
            while(proIterator.hasNext()){
                Product product=(Product)proIterator.next();
                tempSaleAmount= getProTotalAmount(product.getId(), monthCatalog)*getProPriceById(product.getId());
                System.out.print(tempSaleAmount+"  ");
            }

            System.out.print(getClerkTotalSaleAmountPerMonth(month,clerk.getName()));
            System.out.println();

        }

        System.out.print("     ");
        Iterator iterator1=productList.iterator();
        int tempProAmount=0;
        while(iterator1.hasNext()){
            Product product=(Product)iterator1.next();
            tempProAmount=getProMonthAmount(product.getId(),month,catalog);
            System.out.print(tempProAmount+"  ");
        }


    }

}
