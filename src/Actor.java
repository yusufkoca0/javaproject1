
public class Actor extends Performer{

    private String height;


    public Actor() {
        super();
        this.height = "";
        this.PersonType = "Actor";
    }

    public Actor(String userid, String name, String surname, String country,String height) {
        super(userid, name, surname, country);
        this.height = height;
        this.PersonType = "Actor";
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
