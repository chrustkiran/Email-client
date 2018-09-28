import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializer {
    public void read(String date) {
        Mail mail = null;
        boolean checker = true;
        while (checker) {
            String fileName = date;
            int count = 1;
            try {
                FileInputStream fileIn = new FileInputStream("/tmp/"+fileName+".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                mail = (Mail) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                checker = false;
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Employee class not found");
                c.printStackTrace();
                return;
            }

            System.out.println("Deserialized Mail...");
       System.out.println("Receiver: " + mail.getRecevierMail());
        System.out.println("Subject: " + mail.getSubject());
        System.out.println("Body: " + mail.getBody());


        fileName = fileName+"-"+count;
        }

    }


}
