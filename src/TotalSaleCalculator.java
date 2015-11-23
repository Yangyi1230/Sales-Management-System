/**
 * Created by chenhao on 11/13/15.
 */
public class TotalSaleCalculator extends Transition {

    public TotalSaleCalculator(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        super(rc, clerkList, productList);
    }

    public TotalSaleCalculator() {
    }

    int getTotalSaleCalculator(int proId){
        int total=0;
        total= getProTotalAmount(proId, catalog)*getProPriceById(proId);
//        System.out.println("getTotalSaleCalculator: "+total);
        return total;
    }

}
