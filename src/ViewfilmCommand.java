
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ViewfilmCommand {

    public static String command;
    public static String[] viewcommand;
    public static Films viewingfilm;
    public static FeatureFilm featureFilm;
    public static ShortFilm shortFilm;
    public static Documentary documentary;
    public static TVSeries tvSeries;

    //this function sets up to viewfilm command proccess and calls CheckViewfilmCommand method
    //if that method is true it calls ViewingFilm method, if it is false it calls ViewFailed method
    public static void ExecuteViewFilmCommand(String cmd){

        command = cmd;
        viewcommand = command.split("\t",2);

        if(CheckViewfilmCommand()){
            ViewingFilm();
        }
        else {
            ViewFailed();
        }
    }

    //this method checks if the given filmid exists in the system
    //if it exists it returns true if it does not exist it returns false
    private static boolean CheckViewfilmCommand(){
        for (FeatureFilm film: FilmsConstructor.featurefilmobjects){
            if(film.filmid.equals(viewcommand[1])){
                viewingfilm = film;
                featureFilm = film;
                return true;
            }

        }

        for (ShortFilm film: FilmsConstructor.shortfilmobjects){
            if(film.filmid.equals(viewcommand[1])){
                viewingfilm = film;
                shortFilm = film;
                return true;
            }
        }

        for (Documentary film: FilmsConstructor.documentaryobjects){
            if(film.filmid.equals(viewcommand[1])){
                viewingfilm = film;
                documentary = film;
                return true;
            }
        }

        for (TVSeries film: FilmsConstructor.tvseriesobjects){
            if(film.filmid.equals(viewcommand[1])){
                viewingfilm = film;
                tvSeries = film;
                return true;
            }
        }
        return false;
    }

    //this method checks the filmtype amd calls the necessary method
    private static void ViewingFilm(){

        if(viewingfilm.FilmType.equals("FeatureFilm")){
            ViewFeaturefilm();
        }
        else if(viewingfilm.FilmType.equals("ShortFilm")){
            ViewShortfilm();
        }
        else if(viewingfilm.FilmType.equals("Documentary")){
            ViewDocumentary();
        }
        else if(viewingfilm.FilmType.equals("TVSeries")){
            ViewTVSeries();
        }
    }

    //this method writes the featurefilm output into the output file in the correct form
    private static void ViewFeaturefilm(){

        //sets the rating
        featureFilm.setRating();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            String[] year = featureFilm.getReleaseDate().split("\\.");

            br.write(viewcommand[0] + "\t" + viewcommand[1] + "\n\n" + featureFilm.filmtitle + " (" + year[2] + ")\n");

            //writes the genre
            for(int i = 0; i<featureFilm.getFilmGenre().size(); i++){
                if(i!= featureFilm.getFilmGenre().size()-1){
                    br.write(featureFilm.getFilmGenre().get(i) + ", ");
                }
                else{
                    br.write(featureFilm.getFilmGenre().get(i));
                }

            }

            //writes the writers
            br.write("\nWriters: ");

            for(int i = 0; i<featureFilm.getWriters().size(); i++){
                for(Writer obj: PeopleConstructor.writerobjects){
                    if(obj.userid.equals(featureFilm.getWriters().get(i)) && i!=featureFilm.getWriters().size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(featureFilm.getWriters().get(i)) && i==featureFilm.getWriters().size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            br.write("\nDirectors: ");

            //writes the directors
            for(int i = 0; i<featureFilm.directors.size(); i++){
                for(Director obj: PeopleConstructor.directorobjects){
                    if(obj.userid.equals(featureFilm.directors.get(i)) && i!=featureFilm.directors.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(featureFilm.directors.get(i)) && i==featureFilm.directors.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            br.write("\nStars: ");

            //writes the stars
            for(int i = 0; i<featureFilm.cast.size(); i++){

                for(Performer obj: PeopleConstructor.performerobjects){
                    if(obj.userid.equals(featureFilm.cast.get(i)) && i!=featureFilm.cast.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(featureFilm.cast.get(i)) && i==featureFilm.cast.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }

            }

            //writes the rating


            if(featureFilm.rating.equals("Awaiting for votes")){
                br.write("\n" + featureFilm.rating);
            }
            else {
                br.write("\nRatings: ");
                br.write(featureFilm.rating + "/10 from " + String.valueOf(featureFilm.allratings.size()) +
                        " users");
            }

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //this method writes the shortfilm output into the output file in the correct form
    private static void ViewShortfilm(){

        shortFilm.setRating();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            String[] year = shortFilm.getReleaseDate().split("\\.");

            br.write(viewcommand[0] + "\t" + viewcommand[1] + "\n\n" + shortFilm.filmtitle + " (" + year[2] + ")\n");

            //writes the genre
            for(int i = 0; i<shortFilm.getFilmGenre().size(); i++){
                if(i!= shortFilm.getFilmGenre().size()-1){
                    br.write(shortFilm.getFilmGenre().get(i) + ", ");
                }
                else{
                    br.write(shortFilm.getFilmGenre().get(i));
                }

            }

            //writes the writers
            br.write("\nWriters: ");

            for(int i = 0; i<shortFilm.getWriters().size(); i++){
                for(Writer obj: PeopleConstructor.writerobjects){
                    if(obj.userid.equals(shortFilm.getWriters().get(i)) && i!=shortFilm.getWriters().size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(shortFilm.getWriters().get(i)) && i==shortFilm.getWriters().size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the directors
            br.write("\nDirectors: ");

            for(int i = 0; i<shortFilm.directors.size(); i++){
                for(Director obj: PeopleConstructor.directorobjects){
                    if(obj.userid.equals(shortFilm.directors.get(i)) && i!=shortFilm.directors.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(shortFilm.directors.get(i)) && i==shortFilm.directors.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the stars
            br.write("\nStars: ");

            for(int i = 0; i<shortFilm.cast.size(); i++){

                for(Performer obj: PeopleConstructor.performerobjects){
                    if(obj.userid.equals(shortFilm.cast.get(i)) && i!=shortFilm.cast.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(shortFilm.cast.get(i)) && i==shortFilm.cast.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the rating


            if(shortFilm.rating.equals("Awaiting for votes")){
                br.write("\n" + shortFilm.rating);
            }
            else {
                br.write("\nRatings: ");
                br.write(shortFilm.rating + "/10 from " + String.valueOf(shortFilm.allratings.size()) +
                        " users");
            }

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //this method writes the documentary output into the output file in the correct form
    private static void ViewDocumentary(){

        documentary.setRating();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            String[] year = documentary.getReleaseDate().split("\\.");

            br.write(viewcommand[0] + "\t" + viewcommand[1] + "\n\n" + documentary.filmtitle + " (" + year[2] + ")\n");


            //writes the directors
            br.write("Directors: ");

            for(int i = 0; i<documentary.directors.size(); i++){
                for(Director obj: PeopleConstructor.directorobjects){
                    if(obj.userid.equals(documentary.directors.get(i)) && i!=documentary.directors.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(documentary.directors.get(i)) && i==documentary.directors.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the stars
            br.write("\nStars: ");

            for(int i = 0; i<documentary.cast.size(); i++){

                for(Performer obj: PeopleConstructor.performerobjects){
                    if(obj.userid.equals(documentary.cast.get(i)) && i!=documentary.cast.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(documentary.cast.get(i)) && i==documentary.cast.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the rating


            if(documentary.rating.equals("Awaiting for votes")){
                br.write("\n" + documentary.rating);
            }
            else {
                br.write("\nRatings: ");
                br.write(documentary.rating + "/10 from " + String.valueOf(documentary.allratings.size()) +
                        " users");
            }

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //this method writes the tvseries output into the output file in the correct form
    private static void ViewTVSeries(){

        tvSeries.setRating();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            String[] startyear = tvSeries.getStartDate().split("\\.");
            String[] endyear = tvSeries.getEndDate().split("\\.");

            br.write(viewcommand[0] + "\t" + viewcommand[1] + "\n\n" + tvSeries.filmtitle + " (" + startyear[2] +
                    "-" + endyear[2] + ")\n");

            br.write(tvSeries.getNumberofSeasons() + " seasons, " + tvSeries.getNumberofEpisodes() + " episodes\n");

            //writes the genre
            for(int i = 0; i<tvSeries.getFilmGenre().size(); i++){
                if(i!= tvSeries.getFilmGenre().size()-1){
                    br.write(tvSeries.getFilmGenre().get(i) + ", ");
                }
                else{
                    br.write(tvSeries.getFilmGenre().get(i));
                }

            }

            //writes the writers
            br.write("\nWriters: ");

            for(int i = 0; i<tvSeries.getWriters().size(); i++){
                for(Writer obj: PeopleConstructor.writerobjects){
                    if(obj.userid.equals(tvSeries.getWriters().get(i)) && i!=tvSeries.getWriters().size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(tvSeries.getWriters().get(i)) && i==tvSeries.getWriters().size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the directors
            br.write("\nDirectors: ");

            for(int i = 0; i<tvSeries.directors.size(); i++){
                for(Director obj: PeopleConstructor.directorobjects){
                    if(obj.userid.equals(tvSeries.directors.get(i)) && i!=tvSeries.directors.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(tvSeries.directors.get(i)) && i==tvSeries.directors.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the stars
            br.write("\nStars: ");

            for(int i = 0; i<tvSeries.cast.size(); i++){

                for(Performer obj: PeopleConstructor.performerobjects){
                    if(obj.userid.equals(tvSeries.cast.get(i)) && i!=tvSeries.cast.size()-1){
                        br.write(obj.name + " " + obj.surname + ", ");
                    }
                    else if (obj.userid.equals(tvSeries.cast.get(i)) && i==tvSeries.cast.size()-1){
                        br.write(obj.name + " " + obj.surname);
                    }
                }
            }

            //writes the ratings


            if(tvSeries.rating.equals("Awaiting for votes")){
                br.write("\n" + tvSeries.rating);
            }

            else {
                br.write("\nRatings: ");
                br.write(tvSeries.rating + "/10 from " + String.valueOf(tvSeries.allratings.size()) +
                        " users");
            }

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //this method writes the failed output into the output file in the correct form
    private static void ViewFailed(){

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(viewcommand[0] + "\t" + viewcommand[1] + "\n\nCommand Failed" + "\nFilm ID: " + viewcommand[1]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }

    }

}
