/**
 * Created by chenhao on 11/13/15.
 */

public class Receipt {
    Clerk clerk;
    Date date;
    int towelAmount;
    int pillowAmount;
    int curtainAmount;
    int bathmatAmount;
    int quiltAmount;

    Receipt(){
        clerk = new Clerk();
        date = new Date();
        towelAmount = 0;
        pillowAmount = 0;
        curtainAmount = 0;
        bathmatAmount = 0;
        quiltAmount = 0;
    }
    public void setAmountById(int proId, int amount){
        switch(proId){
            case 1:
                pillowAmount = amount;
                break;
            case 2:
                curtainAmount = amount;
                break;
            case 3:
                towelAmount = amount;
                break;
            case 4:
                bathmatAmount = amount;
                break;
            case 5:
                quiltAmount =amount;
                break;
        }
    }
    public int getBathmatAmount() {
        return bathmatAmount;
    }

    public int getCurtainAmount() {
        return curtainAmount;
    }

    public int getPillowAmount() {
        return pillowAmount;
    }

    public int getQuiltAmount() {
        return quiltAmount;
    }

    public int getTowelAmount() {
        return towelAmount;
    }

    public void setBathmatAmount(int bathmatAmount) {
        this.bathmatAmount = bathmatAmount;
    }

    public void setCurtainAmount(int curtainAmount) {
        this.curtainAmount = curtainAmount;
    }

    public void setPillowAmount(int pillowAmount) {
        this.pillowAmount = pillowAmount;
    }

    public void setQuiltAmount(int quiltAmount) {
        this.quiltAmount = quiltAmount;
    }

    public void setTowelAmount(int towelAmount) {
        this.towelAmount = towelAmount;
    }
}
