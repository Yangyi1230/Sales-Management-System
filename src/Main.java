/**
 * Created by chenhao on 11/13/15.
 */


public class Main {
    public static void main(String[] args){

        ReceiptCatalog catalog=new ReceiptCatalog();
        Receipt receipt=new Receipt();
        catalog.add(receipt);

        System.out.println("bathmat: "+receipt.bathmat.price);
        System.out.println("Pillow: "+receipt.pillow.price);

    }
}
