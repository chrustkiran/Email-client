import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class OfficialFriend extends Friend {
    private String designation ;

    public OfficialFriend(){
        this.setMail(new OfficalFriendMail());
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
