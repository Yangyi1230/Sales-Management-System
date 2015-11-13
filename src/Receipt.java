/**
 * Created by chenhao on 11/13/15.
 */
public class Receipt {

    String clerkName=null;
    Date date;


    Towel towel;
    Pillow pillow;
    Curtain curtain;
    Bathmat bathmat;
    Quilt quilt;


    public String getClerkName() {
        return clerkName;
    }
    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }


    Receipt(){
        towel=new Towel();
        pillow=new Pillow();
        curtain=new Curtain();
        bathmat=new Bathmat();
        quilt=new Quilt();


    }



}
