/**
 * Created by chenhao on 11/13/15.
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class InformationInput extends Transition {
    public void oldRecordInpunt(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            String[] data;

            while ((tempString = reader.readLine()) != null) {
                Receipt curRec = new Receipt();
                data = tempString.split(",");

                curRec.clerk.setId(Integer.parseInt(data[0]));
                curRec.date.setMonth(Integer.parseInt( data[1].substring(0, 2)));
                curRec.date.setDate(Integer.parseInt(data[1].substring(2, 4)));
                for (int i = 2; i < 12; i = i + 2)
                    curRec.setMountById(Integer.parseInt(data[i]),Integer.parseInt(data[i+1]));

                super.catalog.add(curRec);
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
    }
}
