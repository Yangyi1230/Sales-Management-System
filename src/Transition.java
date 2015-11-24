import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class Transition {

    public static ReceiptCatalog catalog;

    public static ClerkList clerkList;

    public static ProductList productList;

    public static ProductInfoList productInfoList;

    public static DataTransition dataTransition=new DataTransition();

    public Transition(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        this.catalog=rc;
        this.clerkList=clerkList;
        this.productList=productList;
    }

    public Transition() {
    }

    static public void initial(String ProductInfoDB, String ClerkInfoDB, String OldRecord ){
     //   dataTransition.initialization(ProductInfoDB,productInfoList,ClerkInfoDB,clerkList,OldRecord,productList,catalog);
        productInfoList = dataTransition.generateProListFromFile(Main.class.getResource(OldRecord).getFile());
        clerkList = dataTransition.generateClerkList(Main.class.getResource(ClerkInfoDB).getFile());
        productList = dataTransition.generateProductList(Main.class.getResource(ProductInfoDB).getFile());
        catalog = dataTransition.generateReceiptCatalog(productInfoList);
    }




    //    return ReceiptList of all record of certain clerkName in certain month
    ReceiptCatalog getClerkMonthRecord(int month, String clerkName){

        //initialise
        ReceiptCatalog monthReceipt=new ReceiptCatalog();

        Iterator iterator =catalog.iterator();
        Receipt r;

        while(iterator.hasNext()){
            r=(Receipt)iterator.next();

//            System.out.println(r.clerk.getName()+" "+r.date.getMonth());

            if(r.clerk.getName().equals(clerkName)&&r.date.getMonth()==month){
                monthReceipt.add(r);
            }
        }

        //System.out.println(" getClerkMonthRecord complete ");

        return monthReceipt;
    }

    //    计算指定商品在特定Receipt List内销售数量总和
    int getProTotalAmount(int proId, ReceiptCatalog rc) {
        int amount=0;

        Iterator iter=rc.iterator();
        while(iter.hasNext()){
            Receipt r=(Receipt)iter.next();
            amount+=r.getAmountById(proId);
        }

//        System.out.println("getProTotalAmount result: " + amount );
        return amount;

    }

    //计算指定商品指定月份销售数量总和
    int getProMonthAmount(int proId,int month, ReceiptCatalog rc){
        int amount=0;
        Iterator iterator=catalog.iterator();
        while(iterator.hasNext()){
            Receipt r=(Receipt)iterator.next();
            if(r.date.getMonth()==month){
                amount+=r.getAmountById(proId);
            }
        }
        return amount;
    }



    //    get each clerkName total sale product amount every month，每月销售货品总数
    int getClerkTotalProAmountPerMonth(int month, String clerkName){

        int total=0;

        ReceiptCatalog temp=getClerkMonthRecord(month,clerkName);

        Iterator iterator=temp.iterator();
        while(iterator.hasNext()){
            Receipt r=(Receipt) iterator.next();
            total+=r.getTotalProAmountPerReceipt();
        }

//        System.out.println("getClerkTotalProAmountPerMonth result: "+total);

        return total;
    }

    int getProPriceById(int proId){
        int price=0;
        Iterator iterator=productList.iterator();
        while(iterator.hasNext()){
            Product product=(Product)iterator.next();
            if(product.getId()==proId){
                price=product.getPrice();
                break;
            }
        }
        return price;
    }

    //每月销售所有货品金额总数
    int getClerkTotalSaleAmountPerMonth(int month, String clerkName){
        int saleAmount=0;

        ReceiptCatalog monthRecord=getClerkMonthRecord(month,clerkName);
        Iterator iterator=productList.iterator();

        while(iterator.hasNext()){
            Product product=(Product)iterator.next();
            saleAmount+= getProTotalAmount(product.getId(), monthRecord)*getProPriceById(product.getId());
        }

//        System.out.println("getClerkTotalSaleAmountPerMonth: "+saleAmount);
        return saleAmount;
    }

    String getClerkNameById(int clerkId){
        String name="";
        Clerk temp;
        Iterator iterator=clerkList.iterator();
        while(iterator.hasNext()){
            temp=(Clerk)iterator.next();
            if(temp.getId()==clerkId){
                name=temp.getName();
            }
        }
        return name;
    }

}
