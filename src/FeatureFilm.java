

import java.util.ArrayList;

public class FeatureFilm extends Films{
    private String releaseDate;
    private String budget;
    private ArrayList<String> filmGenre;
    private ArrayList<String> writers;

    public FeatureFilm() {
        super();
        this.filmGenre = new ArrayList<>();
        this.releaseDate = "";
        this.writers = new ArrayList<>();
        this.budget = "";
        this.FilmType = "FeatureFilm";
    }

    public FeatureFilm(String filmid, String filmtitle, String language, ArrayList<String> directors, String runtime,
                       String country, ArrayList<String> cast, ArrayList<String> filmGenre, String releaseDate,
                       ArrayList<String> writers, String budget) {
        super(filmid, filmtitle, language, directors, runtime, country, cast);
        this.filmGenre = filmGenre;
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.budget = budget;
        this.FilmType = "FeatureFilm";
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public ArrayList<String> getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(ArrayList<String> filmGenre) {
        this.filmGenre = filmGenre;
    }

    public ArrayList<String> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<String> writers) {
        this.writers = writers;
    }

}
