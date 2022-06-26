

import java.util.ArrayList;

public class ShortFilm extends Films{
    private String releaseDate;
    private ArrayList<String> filmGenre;
    private ArrayList<String> writers;

    public ShortFilm() {
        super();
        this.filmGenre = new ArrayList<>();
        this.releaseDate = "";
        this.writers = new ArrayList<>();
        this.FilmType = "ShortFilm";
    }

    public ShortFilm(String filmid, String filmtitle, String language, ArrayList<String> directors, String runtime,  String country,
                     ArrayList<String> cast, ArrayList<String> filmGenre, String releaseDate, ArrayList<String> writers) {
        super(filmid, filmtitle, language, directors, runtime, country, cast);
        this.filmGenre = filmGenre;
        this.releaseDate = releaseDate;
        this.writers = writers;
        this.FilmType = "ShortFilm";
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
