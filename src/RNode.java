import java.util.Iterator;

/**
 * Created by ?? on 2015/11/22.
 */
public class RNode {
    Clerk clerk;
    Date date;
   SaleLineList saleList;

    RNode(){
        clerk = new Clerk();
        date = new Date();
        saleList = new SaleLineList();
    }
    RNode(Clerk c, Date d, SaleLineList s){
        this.saleList = s;
        this.clerk = c;
        this.date = d;
    }

    public int getAmount(String name) {
        Iterator iter= saleList.iterator();
        int amount = 0;
        while(iter.hasNext()){
            SaleLineItem item = (SaleLineItem) iter.next();
            if(item.getName().equals(name)){
                amount =  item.getCount();
            }
        }
        return amount;
    }

    public int getAmount(int id){
        Iterator iter = saleList.iterator();
        int amount = 0;
        while(iter.hasNext()){
            SaleLineItem item = (SaleLineItem) iter.next();
            if(item.getID() == id){
                amount = item.getCount();
            }
        }
        return amount;
    }

    public RNode(Clerk clerk, Date date) {
        this.clerk = clerk;
        this.date = date;
    }

    //    need change ...
    public int getTotalProAmountPerReceipt(){
        int total=0;
       Iterator iter = saleList.iterator();
        while(iter.hasNext()){
            SaleLineItem item = (SaleLineItem) iter.next();
            total+=item.getCount();
        }
        return total;
    }
}

