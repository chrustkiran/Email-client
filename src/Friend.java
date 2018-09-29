import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public abstract class Friend extends Persons {

    private String dob;
    private Mail mail;
    private SendingEmail sendingEmail;
    private Serializer serializer;

    public Friend(){
        sendingEmail = new SendingEmail();
        serializer = new Serializer();
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public  void receiveBirthdayMail(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
        if(this.getDob().substring(5).equals(sdf.format(Calendar.getInstance().getTimeInMillis()))){
            this.mail.setReceiverAddress(this.getEmail());
            sendingEmail.sendMail(this.mail);
            serializer.save(this.mail); //saving into hard disk
        }
    }
}
