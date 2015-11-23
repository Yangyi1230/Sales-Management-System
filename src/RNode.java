/**
 * Created by ¾°Ë´ on 2015/11/22.
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
}

