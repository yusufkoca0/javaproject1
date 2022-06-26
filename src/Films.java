

import java.util.ArrayList;

public class Films {
    public String rating;
    public String filmid;
    public String filmtitle;
    public String language;
    public String runtime;
    public ArrayList<String> directors;
    public ArrayList<String> cast;
    public String country;
    public String FilmType;
    public ArrayList<String[]> allratings = new ArrayList<>();

    public Films() {
        this.rating = "";
        this.filmid = "";
        this.filmtitle = "";
        this.language = "";
        this.runtime = "";
        this.directors = new ArrayList<>();
        this.cast = new ArrayList<>();
        this.country = "";

    }
    public Films(String filmid, String filmtitle, String language, ArrayList<String> directors,
                 String runtime, String country, ArrayList<String > cast) {
        this.filmid = filmid;
        this.filmtitle = filmtitle;
        this.language = language;
        this.runtime = runtime;
        this.directors = directors;
        this.cast = cast;
        this.country = country;
    }

    public void setRating(){
        if (allratings.size() == 0){
            this.rating = "Awaiting for votes";
        }
        else {
            int total = 0;

            for (String[] allrating: allratings){
                total += Integer.parseInt(allrating[0]);
            }
            double average = (double) total/allratings.size();
            average = Math.round(average*10.0)/10.0;
            String[] averagerate = String.valueOf(average).split("\\.");

            if(averagerate[1].equals("0")) {
                this.rating = averagerate[0];
            }
            else {
                this.rating = averagerate[0] + "," + averagerate[1];
            }

        }

    }

}
