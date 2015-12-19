
/**
 * Created by 景舜 on 2015/12/19.
 */
public class AddNewProduct extends Transition {
    public void addProduct(int id, String proName, int price, int storeAmount){
        Product pro = new  Product( id, price,  storeAmount, proName);
        productList.add(pro);
        System.out.println();
    }
    public  boolean productIsExist(String name){
        return productList.isExist(name);
    }
}
