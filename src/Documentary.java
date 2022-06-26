

import java.util.ArrayList;

public class Documentary extends Films{
    private String releaseDate;

    public Documentary() {
        super();
        this.releaseDate = "";
        this.FilmType = "Documentary";
    }

    public Documentary(String filmid, String filmtitle, String language, ArrayList<String> directors, String runtime,
                       String country, ArrayList<String> cast, String releaseDate) {
        super(filmid, filmtitle, language, directors, runtime, country, cast);
        this.releaseDate = releaseDate;
        this.FilmType = "Documentary";
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
