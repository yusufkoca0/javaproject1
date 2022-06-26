

public class Director extends Artist{

    private String agent;

    public Director() {
        super();
        this.agent = "";
        this.PersonType = "Director";

    }

    public Director(String userid, String name, String surname, String country, String agent) {
        super(userid, name, surname, country);
        this.agent = agent;
        this.PersonType = "Director";
    }


    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }


}
