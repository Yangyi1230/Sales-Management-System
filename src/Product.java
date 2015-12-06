import java.io.Serializable;

/**
 * Created by chenhao on 11/13/15.
 */
public class Product implements Serializable {

    protected int price;
    protected int id;
    protected  int storeAmount;
    protected  String proName;

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

    public Product(int id,int price, int storeAmount, String proName) {
        this.price = price;
        this.id=id;
        this.storeAmount = storeAmount;
        this.proName = proName;
    }

    public Product() {
    }
}
