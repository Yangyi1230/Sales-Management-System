/**
 * Created by 景舜 on 2015/11/15.
 */
//
public class Clerk {
    int id;
    String name;

    public void setId(int id){
        this.id = id;
        switch (id){
            case 1:
                name = "Tom";
                break;
            case 2:
                name = "Mary";
                break;
            case 3:
                name = "Peter";
                break;
            case 4:
                name = "Ann";
                break;
            default:
                name ="";
        }
    }

    public Clerk() {
        this.id = 0;
        this.name = "";
    }
    public Clerk(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
