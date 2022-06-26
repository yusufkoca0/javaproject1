
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RemoveRateCommand {

    public static String command;
    public static String[] ratecommand;
    public static User ratinguser;
    public static Films ratedfilm;
    public static String[] remove_rate_user;
    public static String[] remove_rate_film;

    //this function sets up to rate command proccess and calls CheckRemoveRateCommand method
    //if that method is true it calls RatingFilm method, if it is false it calls RemoveRateFailed method
    public static void ExecuteRemoveRateCommand(String cmd){
        command = cmd;
        ratecommand = command.split("\t",4);

        if(CheckRemoveRateCommand()){
            RemovingRateFilm();
        }
        else {
            RemoveRateFailed();
        }
    }

    //this emthod checks if the given userid and filmid exists in the system
    //if it exists it returns true if it does not exist it returns false
    private static boolean CheckRemoveRateCommand(){

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

    //this method is called when CheckRemoveRateCommand is true
    //this method once again does a checking operation, it checks if the film is already rated or not
    //if the film is already rated then it calls Removing method, if it is not then it calls RemoveRateFailed method
    private static void RemovingRateFilm(){
        //if the user already rated the film

        for (int i = 0; i < ratinguser.allratings.size(); i++) {

            if (ratinguser.allratings.get(i)[1].equals(ratecommand[3])) {
                remove_rate_user = ratinguser.allratings.get(i);
                Removing();
                return;
            }
        }
        RemoveRateFailed();

    }

    //this method is called when CheckRemoveRateCommand is false or when CheckEditRemoveCommand is true but film is not rated
    //it writes the failed output into the output in the correct form
    private static void RemoveRateFailed(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] +  "\t" + ratecommand[2] +  "\t" + ratecommand[3] +
                    "\n\n" + "Command Failed\n" + "User ID: " + ratecommand[2] + "\nFilm ID: " + ratecommand[3]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //it writes the remove rate output into the output file in the correct form
    //it also removes the rating in the related attribute of the user and film
    private static void Removing(){
        for (int i = 0; i < ratedfilm.allratings.size(); i++) {
            if (ratedfilm.allratings.get(i)[1].equals(ratecommand[2])) {
                remove_rate_film = ratedfilm.allratings.get(i);
            }
        }

        ratinguser.allratings.remove(remove_rate_user);
        ratedfilm.allratings.remove(remove_rate_film);

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(ratecommand[0] + "\t" + ratecommand[1] + "\t" + ratecommand[2] + "\t" + ratecommand[3] +
                    "\n\n" + "Your film rating was removed successfully" + "\nFilm Title: " + ratedfilm.filmtitle);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }


    }
}
