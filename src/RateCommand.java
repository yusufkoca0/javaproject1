

import java.io.BufferedWriter;
import java.io.FileWriter;

public class RateCommand {

    public static String command;
    public static String[] ratecommand;
    public static User ratinguser;
    public static Films ratedfilm;

    //this function sets up to rate command proccess and calls CheckRateCommand method
    //if that method is true it calls RatingFilm method, if it is false it calls RateFailed method
    public static void ExecuteRateCommand(String cmd){
        command = cmd;
        ratecommand = command.split("\t",4);

        if(CheckRateCommand()){
            RatingFilm();
        }
        else {
            RateFailed();
        }
    }

    //this emthod checks if the given userid and filmid exists in the system
    //if it exists it returns true if it does not exist it returns false
    private static boolean CheckRateCommand(){


        for (User user: PeopleConstructor.userobjects){
            if(user.userid.equals(ratecommand[1])){

                for (Films film: FilmsConstructor.filmobjects){
                    if(film.filmid.equals(ratecommand[2])){
                        ratinguser = user;
                        ratedfilm = film;
                        return true;
                    }

                }

            }
        }

        return false;
    }

    //this method is called when CheckRateCommand is false
    //it writes the failed output into the output file in the correct form
    private static void RateFailed(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] +  "\t" + ratecommand[2] +  "\t" + ratecommand[3] + "\n\n" +
                    "Command Failed\n" + "User ID: " + ratecommand[1] + "\nFilm ID: " + ratecommand[2]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //this method is called when CheckRateCommand is true
    //this method once again does a checking operation, it checks if the film is already rated or not
    //if the film is already rated then it calls AlreadyRated method, if it is not then it calls Rating method
    private static void RatingFilm(){
        //if the user already rated the film

            for (int i = 0; i < ratinguser.allratings.size(); i++) {
                if (ratinguser.allratings.get(i)[1].equals(ratecommand[2])) {
                    AlreadyRated();
                    return;
                }
            }
            Rating();

    }

    //it writes the already rated output into the output file in the correct form
    private static void AlreadyRated(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] +  "\t" + ratecommand[2] +  "\t" + ratecommand[3] + "\n\n" +
                    "This film was earlier rated");

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //it writes the rate output into the output file in the correct form
    //it also adds the rating to the related attribute of the user and film
    private static void Rating(){
        String[] rateResult_user = new String[]{ratecommand[3], ratecommand[2]};
        String[] rateResult_film = new String[]{ratecommand[3], ratinguser.userid};
        ratinguser.allratings.add(rateResult_user);
        ratedfilm.allratings.add(rateResult_film);

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] + "\t" + ratecommand[2] + "\t" + ratecommand[3] + "\n\n" +
                    "Film rated successfully\n" + "Film type: " + ratedfilm.FilmType + "\nFilm Title: " + ratedfilm.filmtitle);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }

    }

}
