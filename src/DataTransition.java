/**
 * Created by 景舜 on 2015/11/16.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataTransition {
    public ProductInfoList generateProListFromFile(String fileName){

        File file = new File(fileName);
        BufferedReader reader = null;
        ProductInfoList proInfoList = new ProductInfoList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            String[] data;

            while ((tempString = reader.readLine()) != null) {

                data = tempString.split(",");
                ProductInformation proInfo = new ProductInformation();

                proInfo.clerk.setId(Integer.parseInt(data[0]));
                proInfo.date.setMonth(Integer.parseInt( data[1].substring(0, 2)));
                proInfo.date.setDate(Integer.parseInt(data[1].substring(2, 4)));
                proInfo.product.setId(Integer.parseInt(data[3]));
                proInfo.setAmount(Integer.parseInt(data[3]));

                proInfoList.add(proInfo);
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
}
