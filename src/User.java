

import java.util.ArrayList;


public class User extends People {

    public ArrayList<String[]> allratings = new ArrayList<>();


    public User() {
        super();
        this.PersonType = "User";

    }

    public User(String userid, String name, String surname, String country) {
        super(userid, name, surname, country);
        this.PersonType = "User";
    }


}
