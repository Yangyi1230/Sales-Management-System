/**
 * Created by chenhao on 11/13/15.
 */
public class Product {

    protected int price;
    protected int id;

    protected int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int id,int price) {
        this.price = price;
        this.id=id;
    }

    public Product() {
    }
}
