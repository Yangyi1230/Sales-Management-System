/**
 * Created by chenhao on 11/13/15.
 */


public class InformationInput extends Transition {

    public InformationInput(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        super(rc, clerkList, productList);
    }

    public InformationInput() {
    }

    void input(int clerkId, int month,int day, int proId, int proAmount){


        ProductInformation productInformation=new ProductInformation();
        Clerk clerk=new Clerk();
        clerk.setId(clerkId);
        clerk.setName(getClerkNameById(clerkId));

        productInformation.setClerk(clerk);
        productInformation.setAmount(proAmount);
        productInformation.date.setDate(day);
        productInformation.date.setMonth(month);
        productInformation.product.setId(proId);

        productInfoList.add(productInformation);

        //refresh the catalog
        catalog=dataTransition.generateReceiptCatalog(productInfoList);
    }
}
