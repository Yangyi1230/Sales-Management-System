/**
 * Created by chenhao on 11/24/15.
 */

public class SaleSystem {

    public MonthSaleCalculator monthSaleCalculator;
    public InformationInput informationInput;
    public ReportProducer reportProducer;
    public PercentageCounter percentageCounter;
    public TotalSaleCalculator totalSaleCalculator;
    public Account account;
    public SaleSystem() {
        String or =new String("/TXT/OldRecord.txt") ;
        String ci =new String("/TXT/ClerkInfoDB.txt") ;
        String pid=new String("/TXT/ProductInfoDB.txt");
        try {

            Transition.initial(pid, ci, or);

        }catch (Exception e){
            System.out.print("initial fail");
        }
        monthSaleCalculator=new MonthSaleCalculator();
        informationInput =new InformationInput();
        reportProducer=new ReportProducer();
        percentageCounter=new PercentageCounter();
        totalSaleCalculator=new TotalSaleCalculator();
        account=new Account("Tom");
    }

    public void SaveData(){
        try {
            Transition.dataTransition.SerialToFile(Transition.productInfoList, Transition.catalog, Transition.clerkList, Transition.productList);
        }catch (Exception e){
            System.out.print("save data error");
        }
    }
}
