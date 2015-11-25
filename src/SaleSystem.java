/**
 * Created by chenhao on 11/24/15.
 */

public class SaleSystem {

    public MonthSaleCalculator monthSaleCalculator;
    public InformationInput informationInput;
    public ReportProducer reportProducer;
    public PercentageCounter percentageCounter;
    public Account account;
    public SaleSystem() {
        String or =new String("/TXT/OldRecord.txt") ;
        String ci =new String("/TXT/ClerkInfoDB.txt") ;
        String pid=new String("/TXT/ProductInfoDB.txt");
        Transition.initial(pid, ci, or);
        monthSaleCalculator=new MonthSaleCalculator();
        informationInput =new InformationInput();
        reportProducer=new ReportProducer();
        percentageCounter=new PercentageCounter();
        account=new Account("Tom");
    }
}
