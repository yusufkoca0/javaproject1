

import java.util.ArrayList;

public class StuntPerformer extends Performer{

    private String height;
    private ArrayList<String> real_actor_ids;

    public StuntPerformer() {
        super();
        this.height = "";
        this.real_actor_ids = new ArrayList<>();
        this.PersonType = "StuntPerformer";
    }

    public StuntPerformer(String userid, String name, String surname, String country,String height, ArrayList<String> real_actor_ids) {
        super(userid, name, surname, country);
        this.height = height;
        this.real_actor_ids = real_actor_ids;
        this.PersonType = "StuntPerformer";
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public ArrayList<String> getReal_actor_ids() {
        return real_actor_ids;
    }

    public void setReal_actor_ids(ArrayList<String> real_actor_ids) {
        this.real_actor_ids = real_actor_ids;
    }

}
