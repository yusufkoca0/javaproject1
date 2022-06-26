

public class Writer extends Artist{
    private String writingStyle;

    public Writer() {
        super();
        this.writingStyle = "";
        this.PersonType = "Writer";
    }

    public Writer(String userid, String name, String surname, String country, String writingStyle) {
        super(userid, name, surname, country);
        this.writingStyle = writingStyle;
        this.PersonType = "Writer";
    }

    public String getWritingStyle() {
        return writingStyle;
    }

    public void setWritingStyle(String writingStyle) {
        this.writingStyle = writingStyle;
    }


}
