import java.util.ArrayList;

/**
 * Created by chenhao on 11/23/15.
 */
public class ProductList extends ArrayList <Product> {
    public boolean isExist(String name){
        for(int i = 0; i < size(); i++){
            if(get(i).getProName().equals(name))
                return true;
        }
        return false;
    }

}
