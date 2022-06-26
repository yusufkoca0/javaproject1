
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ListFeaturefilmAfterCommand {

    public static String command;
    public static String[] listcommand;
    public static ArrayList<FeatureFilm> films_after;

    //this function sets up to ListFeaturefilmAfter command proccess and and calls Checker method
    //Then it checks if there is any films with the correct date
    //if there is then it calls Listing method
    //if there is not it calls Failed method
    public static void ExecuteListFeaturefilmAfterCommand(String cmd){
        command = cmd;
        listcommand = command.split("\t");
        films_after = new ArrayList<>();

        Checker();

        if (films_after.size() != 0) {
            Listing();
        }
        else {
            Failed();
        }
    }

    //checks the films and if there is any films with the correct date it adds them into films_after
    private static void Checker(){
        for (FeatureFilm film: FilmsConstructor.featurefilmobjects){

            String[] year;
            year = film.getReleaseDate().split("\\.");

            if(Integer.parseInt(year[2]) >= Integer.parseInt(listcommand[3])){
                films_after.add(film);
            }
        }
    }

    //gives the correct output for the working command
    private static void  Listing(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n");

            for (FeatureFilm film: films_after){

                String[] year;
                year = film.getReleaseDate().split("\\.");

                br.write("Film Title: " + film.filmtitle + " (" + year[2] + ")" +"\n");
                br.write(film.runtime + " min\n");
                br.write("Language: "+ film.language + "\n\n");

            }

            br.write("-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //gives the correct output if there's no films after the date
    private static void Failed(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\nNo result");

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

}
