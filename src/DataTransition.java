/**
 * Created by 景舜 on 2015/11/16.
 */

import java.io.*;


//处理底层数据库文件生成 clerkList, productList, productInfoList,accountList
public class DataTransition{

//    public void initialization(String OldRecord, ProductInfoList productInfoList, String ClerkInfoDB, ClerkList clerkList,
//                               String ProductInfoDB, ProductList pdList, ReceiptCatalog catalog){
//        productInfoList = generateProListFromFile(Main.class.getResource(OldRecord).getFile());
//        clerkList = generateClerkList(Main.class.getResource(ClerkInfoDB).getFile());
//        pdList = generateProductList(Main.class.getResource(ProductInfoDB).getFile());
//        catalog = generateReceiptCatalog(productInfoList);
//    }

    public ClerkList generateClerkList(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;

        ClerkList clerkList = new ClerkList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            String[] data;

            while ((tempString = reader.readLine()) != null) {
                data = tempString.split(",");
                Clerk clerk = new Clerk(Integer.parseInt(data[0]), data[1]);
                clerkList.add(clerk);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return clerkList;
    }

    public ProductList generateProductList(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;

        ProductList productList=new ProductList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            String[] data;

            while ((tempString = reader.readLine()) != null) {
                data = tempString.split(",");
                Product product = new Product(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
                productList.add(product);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return productList;
    }

    public ProductInfoList generateProListFromFile(String fileName){

        File file = new File(fileName);
        BufferedReader reader = null;
        ProductInfoList proInfoList = new ProductInfoList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            String[] data;

            while ((tempString = reader.readLine()) != null) {
                if(!tempString.equals("")) {
                    data = tempString.split(",");
                    ProductInformation proInfo = new ProductInformation();

                    proInfo.clerk.setId(Integer.parseInt(data[0]));
                    proInfo.date.setMonth(Integer.parseInt(data[1].substring(0, 2)));
                    proInfo.date.setDate(Integer.parseInt(data[1].substring(2, 4)));
                    proInfo.product.setId(Integer.parseInt(data[2]));
                    proInfo.setAmount(Integer.parseInt(data[3]));

                    proInfoList.add(proInfo);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
//                    System.out.println("reader close error");
                    e1.printStackTrace();
                }
            }
        }
        return proInfoList;
    }

    public ReceiptCatalog generateReceiptCatalog(ProductInfoList productInfoList){
        ReceiptCatalog catalog = new ReceiptCatalog();
        ProductInformation proInfo;
        MidList list = new MidList();
        boolean isFind;

        for(int i = 0; i < productInfoList.size(); i++){
            proInfo = productInfoList.get(i);
            isFind = false;
            for(int j = 0; j< list.size(); j++){
                RNode node = list.get(j);
                if(node.clerk.getId() == proInfo.clerk.getId()&&
                        node.date.getMonth() == proInfo.date.getMonth()&&
                        node.date.getDate() == proInfo.date.getDate()){
                    SaleLineItem item =new SaleLineItem(proInfo.product, proInfo.amount);
                    node.saleList.add(item);
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                SaleLineItem item = new SaleLineItem(proInfo.product, proInfo.amount);
                SaleLineList salelist = new SaleLineList();
                salelist.add(item);
                RNode node = new RNode(proInfo.clerk, proInfo.date, salelist);
                list.add(node);
            }
        }
        for(int i = 0; i<list.size(); i++){
            RNode node = list.get(i);
            Receipt receipt =new Receipt(node.clerk, node.date);
            for(int j = 0; j < node.saleList.size(); j++){
                receipt.setAmountById(node.saleList.get(j).product.getId(), node.saleList.get(j).getCount());
            }
            catalog.add(receipt);
        }
        return catalog;
    }


    public MidList generateMidList(ProductInfoList productInfoList){
        ProductInformation proInfo;
        MidList list = new MidList();
        boolean isFind;

        for(int i = 0; i < productInfoList.size(); i++){
            proInfo = productInfoList.get(i);
            isFind = false;
            for(int j = 0; j< list.size(); j++){
                RNode node = list.get(j);
                if(node.clerk.getId() == proInfo.clerk.getId()&&
                        node.date.getMonth() == proInfo.date.getMonth()&&
                        node.date.getDate() == proInfo.date.getDate()){
                    SaleLineItem item =new SaleLineItem(proInfo.product, proInfo.amount);
                    node.saleList.add(item);
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                SaleLineItem item = new SaleLineItem(proInfo.product, proInfo.amount);
                SaleLineList salelist = new SaleLineList();
                salelist.add(item);
                RNode node = new RNode(proInfo.clerk, proInfo.date, salelist);
                list.add(node);
            }
        }
        return list;
    }


    public AccountList generateAccountList(){

        File file = new File(DataTransition.class.getResource("/TXT/AccountDB.txt").getFile());
        BufferedReader reader = null;
        AccountList al = new AccountList();
        String tempString;
        String[] data;

        try {
            reader = new BufferedReader(new FileReader(file));

            while ((tempString = reader.readLine()) != null) {
                data = tempString.split(",");
                Account  account = new Account(data[0],data[1],  Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                al.add(account);
            }
            reader.close();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return al;
    }

    public SaleLineList  generateSaleLineList(ProductInfoList productInfoList){
        SaleLineList list = new SaleLineList();
        ProductInformation proInfo;

        for(int i = 0; i < productInfoList.size(); i++){
            proInfo = productInfoList.get(i);
            SaleLineItem  item =new SaleLineItem(proInfo.product, proInfo.getAmount());
            list.add(item);
        }
        return list;
    }

    public  void SerialToFile(ProductInfoList productInfoList) throws Exception {
//        File file = new File("productInfoList.obj");
//        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
//
//        Iterator iter = productInfoList.iterator();
//        while(iter.hasNext()){
//            ProductInformation proInfo = (ProductInformation) iter.next();
//            oout.writeObject(proInfo);
//        }

        File file = new File("productInfoList.obj");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(productInfoList);
        oout.close();

    }
    public  void SerialToFile( ReceiptCatalog receiptCatalog) throws Exception{
        File file = new File("receiptCatalog.obj");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(receiptCatalog);
        oout.close();
    }
    public  void SerialToFile(ClerkList clerkList) throws Exception{
        File file = new File("clerkList.obj");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(clerkList);
        oout.close();
    }
    public  void SerialToFile(ProductList productList) throws Exception{
        File file = new File("productList.obj");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(productList);
        oout.close();
    }
    public static void SerialToFile(AccountList accountList) throws Exception{
        File file = new File("accountList.obj");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        oout.writeObject(accountList);
        oout.close();
    }
    public  void SerialToFile(ProductInfoList productInfoList, ReceiptCatalog receiptCatalog, ClerkList clerkList, ProductList productList, AccountList accountList) throws Exception {
        SerialToFile(productInfoList);
        SerialToFile(receiptCatalog);
        SerialToFile(productList);
        SerialToFile(clerkList);
        SerialToFile(accountList);
    }
    public  ProductInfoList SerialFromProductInfoList() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("productInfoList.obj"));
        ProductInfoList productInfoList = (ProductInfoList)oin.readObject();
        oin.close();
        return productInfoList;
    }

    public  ReceiptCatalog SerialFromReceiptCatalog() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("receiptCatalog.obj"));
        ReceiptCatalog receiptCatalog = (ReceiptCatalog)oin.readObject();
        oin.close();
        return receiptCatalog;
    }
    public  ClerkList SerialFromClerkList() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("clerkList.obj"));
        ClerkList clerkList = (ClerkList)oin.readObject();
        oin.close();
        return clerkList;
    }
    public  ProductList SerialFromProductList() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("productList.obj"));
        ProductList productList = (ProductList)oin.readObject();
        oin.close();
        return productList;
    }
    public static AccountList SerialFromAccountList() throws Exception {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("accountList.obj"));
        AccountList accountList = (AccountList)oin.readObject();
        oin.close();
        return accountList;
    }
}
