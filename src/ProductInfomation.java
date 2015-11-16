/**
 * Created by ¾°Ë´ on 2015/11/16.
 */
public class ProductInfomation {
    Clerk clerk;
    Date date;
    Product product;
    int amount;

    public ProductInfomation() {
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
