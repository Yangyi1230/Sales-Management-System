import java.io.Serializable;

/**
 * Created by chenhao on 11/13/15.
 */
public class Account implements Serializable {
    public String userName;
    String clerkName;
    int  clerkID;
    String password;
    int level ;

    public Account(String userName, String clerkName, int clerkID, String password, int level) {
        this.userName = userName;
        this.clerkName = clerkName;
        this.clerkID = clerkID;
        this.password = password;
        this.level = level;
    }

    public String getUserName() {
        return userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public void setClerkID(int clerkID) {
        this.clerkID = clerkID;
    }

    public int getClerkID() {
        return clerkID;
    }
}
