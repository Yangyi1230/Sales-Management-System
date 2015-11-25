import java.io.Serializable;

/**
 * Created by Jingshun on 2015/11/16.
 */
public class ProductInformation   implements Serializable{
    Clerk clerk;
    Date date;
    Product product;
    int amount;

    public ProductInformation(){
        clerk = new Clerk();
        date = new Date();
        product = new Product();
        amount = 0;
    }

    public ProductInformation(Clerk clerk, Date date, Product product, int amount) {
        this.clerk = clerk;
        this.date = date;
        this.product = product;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
