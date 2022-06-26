

import java.io.BufferedWriter;
import java.io.FileWriter;


public class ListUserRatesCommand{

    public static String command;
    public static String[] listcommand;
    public static User userobj;

    //this function sets up to ListUserRate command proccess and calls CheckListUserRateCommand method
    //if that method is true it checks if the user have amy rated films so far if it doesnt it calls NoRating method
    //if it does have, it calls Listing method
    // if CheckRateCommand method is false it calls ListFailed method
    public static void ExecuteListUserRateCommand(String cmd){
        command = cmd;
        listcommand = command.split("\t",4);

        if(CheckUser()){
            if(userobj.allratings.size() != 0) {
                Listing();
            }
            else {
                NoRating();
            }
        }
        else {
            ListFailed();
        }
    }

    //Checks if the user exists
    private static boolean CheckUser(){
        for(User user: PeopleConstructor.userobjects){
            if(user.userid.equals(listcommand[2])){
                userobj = user;
                return true;
            }
        }
        return false;
    }

    //gives the correct output for the working command
    private static void Listing(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(listcommand[0] + "\t" + listcommand[1] + "\t" + listcommand[2] + "\t" + listcommand[3] + "\n\n");

            for(String[] rate: userobj.allratings) {
                for (Films film : FilmsConstructor.filmobjects) {
                    if (film.filmid.equals(rate[1])){
                        br.write(film.filmtitle + ": " + rate[0] + "\n");
                    }
                }
            }

            br.write("\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //gives the correct output if there is no rating
    private static void NoRating(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\nThere is not any ratings so far");

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //gives the correct output if the command fails
    private static void ListFailed(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(listcommand[0] + "\t" + listcommand[1] + "\t" + listcommand[2] + "\t" + listcommand[3] + "\n\n" +
                    "Command Failed\n" + "User ID: " + listcommand[2]);


            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }
}


