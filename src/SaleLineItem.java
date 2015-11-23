/**
 * Created by chenhao on 11/13/15.
 */
public class SaleLineItem {

    Product product;

    private int count=0;

    public SaleLineItem(Product product,int amount) {
        this.product = product;
        count = amount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
