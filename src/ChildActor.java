

public class ChildActor extends  Performer{

    private String age;

    public ChildActor() {
        super();
        this.age = "";
        this.PersonType = "ChildActor";
    }

    public ChildActor(String userid, String name, String surname, String country, String age) {
        super(userid, name, surname, country);
        this.age = age;
        this.PersonType = "ChildActor";
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
