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

    static public void initial (String ProductInfoDB, String ClerkInfoDB, String OldRecord ) throws Exception{
     //   dataTransition.initialization(ProductInfoDB,productInfoList,ClerkInfoDB,clerkList,OldRecord,productList,catalog);
//        productInfoList = dataTransition.generateProListFromFile(Main.class.getResource(OldRecord).getFile());
//        clerkList = dataTransition.generateClerkList(Main.class.getResource(ClerkInfoDB).getFile());
//        productList = dataTransition.generateProductList(Main.class.getResource(ProductInfoDB).getFile());
//        catalog = dataTransition.generateReceiptCatalog(productInfoList);

        clerkList= dataTransition.SerialFromClerkList();
        productInfoList=dataTransition.SerialFromProductInfoList();
        productList=dataTransition.SerialFromProductList();
        catalog=dataTransition.generateReceiptCatalog(productInfoList);

    }




    //    return ReceiptList of all record of certain clerkName in certain month
    public static ReceiptCatalog getClerkMonthRecord(int month, String clerkName){

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

    public static ReceiptCatalog getClerkDayRecord(int day,int month, String clerkName){
        ReceiptCatalog monthReceipt=new ReceiptCatalog();

        Iterator iterator =catalog.iterator();
        Receipt r;

        while(iterator.hasNext()){
            r=(Receipt)iterator.next();
            if(r.clerk.getName().equals(clerkName)&&r.date.getMonth()==month&&r.date.getDate()==day){
                monthReceipt.add(r);
            }
        }

        return monthReceipt;


    }



        //    计算指定商品在特定Receipt List内销售数量总和
    public static int getProTotalAmountByGivenList(int proId, ReceiptCatalog rc) {
        int amount=0;

        Iterator iter=rc.iterator();
        while(iter.hasNext()){
            Receipt r=(Receipt)iter.next();
            amount+=r.getAmountById(proId);
        }

//        System.out.println("getProTotalAmountByGivenList result: " + amount );
        return amount;

    }

    //计算指定商品指定月份销售数量总和
    public static int getProMonthAmount(int proId,int month, ReceiptCatalog rc){
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

    public static int getProDayAmount(int proId,int day,int month, ReceiptCatalog rc){
        int amount=0;
        Iterator iterator=catalog.iterator();
        while(iterator.hasNext()){
            Receipt r=(Receipt)iterator.next();
            if(r.date.getMonth()==month&&r.date.getDate()==day){
                amount+=r.getAmountById(proId);
            }
        }
        return amount;
    }




        //    get each clerkName total sale product amount every month，每月销售货品总数
    public static int getClerkTotalProAmountPerMonth(int month, String clerkName){

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

    public static int getProPriceById(int proId){
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
    public static int getClerkTotalSaleAmountPerMonth(int month, String clerkName){
        int saleAmount=0;

        ReceiptCatalog monthRecord=getClerkMonthRecord(month,clerkName);
        Iterator iterator=productList.iterator();

        while(iterator.hasNext()){
            Product product=(Product)iterator.next();
            saleAmount+= getProTotalAmountByGivenList(product.getId(), monthRecord)*getProPriceById(product.getId());
        }
        return saleAmount;
    }

    //每日销售所有货物金额总数
    public static int getClerkTotalSaleAmountPerDay(int day, int month, String clerkName) {
        int saleAmount=0;

        ReceiptCatalog dayRecord=getClerkDayRecord(day,month,clerkName);
        Iterator iterator=productList.iterator();

        while(iterator.hasNext()){
            Product product=(Product)iterator.next();
            saleAmount+= getProTotalAmountByGivenList(product.getId(), dayRecord)*getProPriceById(product.getId());
        }
        return saleAmount;
    }


        public static String getClerkNameById(int clerkId){
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
