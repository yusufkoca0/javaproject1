

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EditRateCommand {

    public static String command;
    public static String[] ratecommand;
    public static User ratinguser;
    public static Films ratedfilm;
    public static String[] edit_rate_user;
    public static String[] edit_rate_film;

    //this function sets up to edit rate command proccess and calls CheckEditRateCommand method
    //if that method is true it calls EditingRateFilm method, if it is false it calls EditRateFailed method
    public static void ExecuteEditRateCommand(String cmd){
        command = cmd;
        ratecommand = command.split("\t",5);

        if(CheckEditRateCommand()){
            EditingRateFilm();
        }
        else {
            EditRateFailed();
        }
    }

    //this emthod checks if the given userid and filmid exists in the system
    //if it exists it returns true if it does not exist it returns false
    private static boolean CheckEditRateCommand(){

        for (User user: PeopleConstructor.userobjects){
            if(user.userid.equals(ratecommand[2])){

                for (Films film: FilmsConstructor.filmobjects){
                    if(film.filmid.equals(ratecommand[3])){
                        ratinguser = user;
                        ratedfilm = film;
                        return true;
                    }

                }

            }
        }
        return false;
    }

    //this method is called when CheckEditRateCommand is true
    //this method once again does a checking operation, it checks if the film is already rated or not
    //if the film is already rated then it calls Editing method, if it is not then it calls EditRateFailed method
    private static void EditingRateFilm(){
        //if the user already rated the film

            for (int i = 0; i < ratinguser.allratings.size(); i++) {

                if (ratinguser.allratings.get(i)[1].equals(ratecommand[3])) {
                    edit_rate_user = ratinguser.allratings.get(i);
                    Editing();
                    return;
                }
            }
            EditRateFailed();

    }

    //this method is called when CheckEditRateCommand is false or when CheckEditRateCommand is true but film is not rated
    //it writes the failed output into the output in the correct form
    private static void EditRateFailed(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] +  "\t" + ratecommand[2] +  "\t" +
                    ratecommand[3] + "\t" + ratecommand[4] + "\n\n" +
                    "Command Failed\n" + "User ID: " + ratecommand[2] + "\nFilm ID: " + ratecommand[3]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //it writes the edit rate output into the output file in the correct form
    //it also edits the rating in the related attribute of the user and film
    private static void Editing(){
        for (int i = 0; i < ratedfilm.allratings.size(); i++) {
            if (ratedfilm.allratings.get(i)[1].equals(ratecommand[2])) {
                edit_rate_film = ratedfilm.allratings.get(i);
            }
        }

        edit_rate_user[0] = ratecommand[4];
        edit_rate_film[0] = ratecommand[4];

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] + "\t" + ratecommand[2] + "\t" + ratecommand[3] +
                    "\t" + ratecommand[4] +"\n\n" + "New ratings done successfully" + "\nFilm Title: " +
                    ratedfilm.filmtitle + "\nYour rating: " + edit_rate_user[0]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }


    }
}
