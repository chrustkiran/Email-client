public class OfficalFriendMail extends Mail{

    private Handler handler;

    public OfficalFriendMail(){
        handler = new Handler();
        super.setSubject("Birthay Wish");
        super.setBody("Wish you a happy birthday "+handler.getMyname());
    }

}
