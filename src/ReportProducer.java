import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class ReportProducer extends Transition {


    public ReportProducer() {
    }

    public ReportProducer(ReceiptCatalog rc, ClerkList clerkList, ProductList productList) {
        super(rc, clerkList, productList);
    }

    void generateReport(int month){


        Iterator iterator=productList.iterator();
        while(iterator.hasNext()){
            Product proForName=(Product)iterator.next();
            System.out.print(proForName.getId()+"  ");
        }
        System.out.println();


        Iterator clerkIterator=clerkList.iterator();
        while(clerkIterator.hasNext()){
            Clerk clerk=(Clerk)clerkIterator.next();


            System.out.print(clerk.getName() + ":  ");
            ReceiptCatalog monthCatalog=getClerkMonthRecord(month,clerk.getName());

            int tempSaleAmount=0;

            Iterator proIterator=productList.iterator();
            while(proIterator.hasNext()){
                Product product=(Product)proIterator.next();
                tempSaleAmount= getProTotalAmountByGivenList(product.getId(), monthCatalog)*getProPriceById(product.getId());
                System.out.print(tempSaleAmount+"  ");
            }

            System.out.print(getClerkTotalSaleAmountPerMonth(month,clerk.getName()));
            System.out.println();

        }

        System.out.print("     ");
        Iterator iterator1=productList.iterator();
        int tempProAmount=0;
        while(iterator1.hasNext()){
            Product product=(Product)iterator1.next();
            tempProAmount=getProMonthAmount(product.getId(),month,catalog);
            System.out.print(tempProAmount+"  ");
        }


    }


    //生成按月份查找的表格内容

    Object [][] monthRowDataProducer(int month){

        Object rowData[][]=new Object[Transition.clerkList.size()+1][Transition.productList.size()+2];

        int i=0;
        int j=0;

        Iterator clerkIterator=Transition.clerkList.iterator();
        while(clerkIterator.hasNext()){
            Clerk clerk=(Clerk)clerkIterator.next();


            rowData[i][j++]=clerk.getName();

            ReceiptCatalog monthCatalog=Transition.getClerkMonthRecord(month, clerk.getName());

            int tempSaleAmount=0;


            for(Product product:Transition.productList){
                tempSaleAmount= Transition.getProTotalAmountByGivenList(product.getId(), monthCatalog)*Transition.getProPriceById(product.getId());
                rowData[i][j++]= tempSaleAmount;
            }

            rowData[i][j]=Transition.getClerkTotalSaleAmountPerMonth(month, clerk.getName());


            j=0;
            i++;

        }

        int x=0;
        rowData[i][x++]="商品总销量";
        Iterator iterator1=Transition.productList.iterator();
        int tempProAmount=0;
        while(iterator1.hasNext()){
            Product product=(Product)iterator1.next();
            tempProAmount=Transition.getProMonthAmount(product.getId(), month, Transition.catalog);
            rowData[i][x++]= tempProAmount;
        }
        return rowData;
    }


    //生成按天查找的表格内容
    Object [][] dayRowDataProducer(int month,int day) {

        Object rowData[][]=new Object[Transition.clerkList.size()+1][Transition.productList.size()+2];
        int i=0;
        int j=0;

        Iterator clerkIterator=Transition.clerkList.iterator();
        while(clerkIterator.hasNext()){
            Clerk clerk=(Clerk)clerkIterator.next();
            rowData[i][j++]=clerk.getName();
            ReceiptCatalog monthCatalog=Transition.getClerkDayRecord(day, month, clerk.getName());

            int tempSaleAmount=0;
            for(Product product:Transition.productList){
                //Product product=(Product)proIterator.next();
                tempSaleAmount= Transition.getProTotalAmountByGivenList(product.getId(), monthCatalog)*Transition.getProPriceById(product.getId());
                rowData[i][j++]= tempSaleAmount;
            }

            rowData[i][j]=Transition.getClerkTotalSaleAmountPerDay(day, month, clerk.getName());
            j=0;
            i++;

        }


        int x=0;
        rowData[i][x++]="商品总销量";
        Iterator iterator1=Transition.productList.iterator();
        int tempProAmount=0;
        while(iterator1.hasNext()){
            Product product=(Product)iterator1.next();
            tempProAmount=Transition.getProDayAmount(product.getId(), day, month, Transition.catalog);
            rowData[i][x++]= tempProAmount;
        }

        return rowData;
    }


    Object [][] quaterRowDataProducer(int quater) {

        Object rowData[][]=new Object[Transition.clerkList.size()+1][Transition.productList.size()+2];

        int i=0;
        int j=0;

        Iterator clerkIterator=Transition.clerkList.iterator();
        while(clerkIterator.hasNext()){
            Clerk clerk=(Clerk)clerkIterator.next();


            rowData[i][j++]=clerk.getName();

            ReceiptCatalog monthCatalog=new ReceiptCatalog();
            monthCatalog.addAll(Transition.getClerkMonthRecord(quater*3, clerk.getName()));
            monthCatalog.addAll(Transition.getClerkMonthRecord(quater*3+1, clerk.getName()));
            monthCatalog.addAll(Transition.getClerkMonthRecord(quater*3+2, clerk.getName()));

            int tempSaleAmount=0;


            for(Product product:Transition.productList){
                tempSaleAmount= Transition.getProTotalAmountByGivenList(product.getId(), monthCatalog)*Transition.getProPriceById(product.getId());
                rowData[i][j++]= tempSaleAmount;
            }

            rowData[i][j]=Transition.getClerkTotalSaleAmountPerMonth(quater*3, clerk.getName())+Transition.getClerkTotalSaleAmountPerMonth(quater*3+1, clerk.getName())+Transition.getClerkTotalSaleAmountPerMonth(quater*3+2, clerk.getName());


            j=0;
            i++;

        }

        int x=0;
        rowData[i][x++]="商品总销量";
        Iterator iterator1=Transition.productList.iterator();
        int tempProAmount=0;
        while(iterator1.hasNext()){
            Product product=(Product)iterator1.next();
            tempProAmount=Transition.getProMonthAmount(product.getId(), quater*3, Transition.catalog)+Transition.getProMonthAmount(product.getId(), quater*3+1, Transition.catalog)+Transition.getProMonthAmount(product.getId(), quater*3+2, Transition.catalog);
            rowData[i][x++]= tempProAmount;
        }

        return rowData;
    }

    }






















