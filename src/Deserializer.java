import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializer {
    public void read(String date) {
        Mail mail = null;
        boolean checker = true;
        String fileName = date;
        while (checker) {

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
                break;
            } catch (ClassNotFoundException c) {
                System.out.println("Mail class not found");
                c.printStackTrace();
                break;
            }
            System.out.println("Deserialized Mail...");
            System.out.println("Receiver: " + mail.getReceiverAddress());
            System.out.println("Subject: " + mail.getSubject());
            System.out.println("Body: " + mail.getBody());

            fileName = fileName + "-" + count;

        }

    }


}
