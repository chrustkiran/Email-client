public class Personal extends Friend {

    String nickname;


    public Personal(){
        this.setMail(new PersonalMail());
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
