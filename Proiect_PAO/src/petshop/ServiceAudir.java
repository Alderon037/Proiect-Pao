package petshop;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceAudir {

    public void WriteToAudit(String data) {

        try {
            FileWriter file = new FileWriter("audit.csv", true);
            file.append(data);
            file.flush();
            file.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
