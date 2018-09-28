public class PersonalMail extends Mail {

    private Handler handler;

    public PersonalMail() {
        handler = new Handler();
        super.setSubject("Birthday wish");
        super.setBody("Hugs ans love on your birthday "+ handler.getMyname());
    }
}
