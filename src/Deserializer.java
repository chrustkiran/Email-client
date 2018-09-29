import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializer {
    public void read(String date) {
        Mail mail = null;
        boolean checker = true;
        String fileName = String.join("-",date.split("/"));     //getting file name as yyyy-MM-dd format
        int count = 1;
        while (checker) {

            try {
                FileInputStream fileIn = new FileInputStream("tmp/"+fileName+".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                mail = (Mail) in.readObject();
                in.close();
                fileIn.close();
            } catch (FileNotFoundException e){
                break;

            } catch (IOException i) {
                i.printStackTrace();
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

            if(fileName.length() == 10 ) {
                fileName = fileName + "-" + count;
            }
            else{
                fileName = fileName.substring(0,10)+"-"+count;
            }

            count++;
        }

    }




}
