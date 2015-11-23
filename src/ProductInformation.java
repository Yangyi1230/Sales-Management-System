/**
 * Created by Jingshun on 2015/11/16.
 */
public class ProductInformation {
    Clerk clerk;
    Date date;
    Product product;
    int amount;

    public ProductInformation() {
        clerk = new Clerk();
        date = new Date();
        product = new Product();
        amount = 0;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
