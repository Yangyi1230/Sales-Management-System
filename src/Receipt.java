/**
 * Created by chenhao on 11/13/15.
 */

public class Receipt {
    Clerk clerk;
    Date date;
    int towelMount;
    int pillowMount;
    int curtainMount;
    int bathmatMount;
    int quiltMount;

    Receipt(){
        clerk = new Clerk();
        date = new Date();
        towelMount = 0;
        pillowMount = 0;
        curtainMount = 0;
        bathmatMount = 0;
        quiltMount = 0;
    }
    public void setMountById(int proId, int mount){
        switch(proId){
            case 1:
                pillowMount = mount;
                break;
            case 2:
                curtainMount = mount;
                break;
            case 3:
                towelMount = mount;
                break;
            case 4:
                bathmatMount = mount;
                break;
            case 5:
                quiltMount =mount;
                break;
        }
    }
    public int getBathmatMount() {
        return bathmatMount;
    }

    public int getCurtainMount() {
        return curtainMount;
    }

    public int getPillowMount() {
        return pillowMount;
    }

    public int getQuiltMount() {
        return quiltMount;
    }

    public int getTowelMount() {
        return towelMount;
    }

    public void setBathmatMount(int bathmatMount) {
        this.bathmatMount = bathmatMount;
    }

    public void setCurtainMount(int curtainMount) {
        this.curtainMount = curtainMount;
    }

    public void setPillowMount(int pillowMount) {
        this.pillowMount = pillowMount;
    }

    public void setQuiltMount(int quiltMount) {
        this.quiltMount = quiltMount;
    }

    public void setTowelMount(int towelMount) {
        this.towelMount = towelMount;
    }
}
