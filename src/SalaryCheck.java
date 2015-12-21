import java.util.Iterator;

/**
 * Created by chenhao on 11/13/15.
 */
public class SalaryCheck extends Transition {
    int basicSalary;
    float bonusRate;

    public SalaryCheck() {
        basicSalary = 1000;
        bonusRate = (float) 0.01;
    }


    public SalaryCheck(int basicSalary, float bonusRate) {
        this.basicSalary = basicSalary;
        this.bonusRate = bonusRate;
    }

    float salaryGenerate(int month, String clerkName) {

        float bonus = getClerkTotalSaleAmountPerMonth(month, clerkName) * bonusRate;
        return bonus + basicSalary;

    }

    //计算所有员工各月工资
    Object[][] salaryRowDataProduce(int month) {
        Object rowData[][] = new Object[Transition.clerkList.size()][2];

        int i = 0;
        int j = 0;

        Iterator clerkIterator = Transition.clerkList.iterator();
        while (clerkIterator.hasNext()) {
            Clerk clerk = (Clerk) clerkIterator.next();
            rowData[i][j++] = clerk.getName();

            rowData[i][j] = clerk.getSalary();

            //rowData[i][j] = salaryGenerate(month, clerk.getName());
            //float tempsalary = salaryGenerate(month, clerk.getName());
            //clerk.setSalary(Math.round(tempsalary));

            j = 0;
            i++;

        }
        //SaleSystem.saveData();
        return rowData;
    }
}
