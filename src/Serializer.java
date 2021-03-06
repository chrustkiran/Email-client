import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Serializer {
    private Mail mail;
    private SimpleDateFormat sdf;
    public Serializer(){
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
    }
    public void save(Mail mail){
        this.mail = mail;

        try {

            String savedName = uniquefileName();
            FileOutputStream fileOut =
                    new FileOutputStream("tmp/"+savedName+".ser");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(mail);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in "+savedName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private String uniquefileName(){
        String filename  = sdf.format(Calendar.getInstance().getTimeInMillis());
        int count = 1;
        while(new File("tmp/"+filename+".ser").exists()){

            if(filename.length() == 10 ) {
                filename = filename + "-" + count;
            }
            else{
                filename = filename.substring(0,10)+"-"+count;
            }
            count++;
        }
        return filename;
    }


}
