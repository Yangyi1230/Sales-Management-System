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
                ProductInfomation proInfo = new ProductInfomation();

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
        ProductInfomation proInfo;

        for(int i = 0; i < productInfoList.size(); i++){
            Receipt receipt =new Receipt();
            proInfo = productInfoList.get(i);

            catalog.add(receipt);
        }
        return catalog;
    }
    public SaleLineList  generateSaleLineList(ProductInfoList productInfoList){
        SaleLineList list = new SaleLineList();
        ProductInfomation proInfo;

        for(int i = 0; i < productInfoList.size(); i++){
            SaleLineItem  item =new SaleLineItem();

            proInfo = productInfoList.get(i);
            item.setCount(proInfo.getAmount());
            item.product.setId(proInfo.product.getId());

            list.add(item);
        }
        return list;
    }
}
