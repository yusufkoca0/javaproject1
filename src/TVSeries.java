

import java.util.ArrayList;

public class TVSeries extends Films{
    private String startDate;
    private String endDate;
    private String numberofSeasons;
    private String numberofEpisodes;
    private ArrayList<String> filmGenre;
    private ArrayList<String> writers;

    public TVSeries() {
        this.startDate = "";
        this.endDate = "";
        this.numberofSeasons = "";
        this.numberofEpisodes = "";
        this.filmGenre = new ArrayList<>();
        this.writers = new ArrayList<>();
        this.FilmType = "TVSeries";
    }

    public TVSeries(String filmid, String filmtitle, String language, ArrayList<String> directors, String runtime,
                    String country, ArrayList<String> cast, ArrayList<String> genre, ArrayList<String> writers,
                    String startDate, String endDate, String numberofSeasons, String numberofEpisodes
                    ) {
        super(filmid, filmtitle, language, directors, runtime, country, cast);
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberofSeasons = numberofSeasons;
        this.numberofEpisodes = numberofEpisodes;
        this.filmGenre = genre;
        this.writers = writers;
        this.FilmType = "TVSeries";
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNumberofSeasons() {
        return numberofSeasons;
    }

    public void setNumberofSeasons(String numberofSeasons) {
        this.numberofSeasons = numberofSeasons;
    }

    public String getNumberofEpisodes() {
        return numberofEpisodes;
    }

    public void setNumberofEpisodes(String numberofEpisodes) {
        this.numberofEpisodes = numberofEpisodes;
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
