/**
 * Created by chenhao on 11/13/15.
 */
public class Date {

    int date;
    int month;

    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public Date(int date) {
        this.date = date;
    }

    public Date() {
        date=0;
        month=0;
    }

}
