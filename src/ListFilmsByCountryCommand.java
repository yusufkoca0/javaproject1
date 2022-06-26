

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ListFilmsByCountryCommand {

    public static String command;
    public static String[] listcommand;
    public static ArrayList<Films> films_by_country;

    //this function sets up to ListFilmsByCountry command proccess and and calls Checker method
    //Then it checks if there is any films with the correct country
    //if there is then it calls Listing method
    //if there is not it calls Failed method
    public static void ExecuteListFilmsByCountryCommand(String cmd){
        command = cmd;
        listcommand = command.split("\t");
        films_by_country = new ArrayList<>();

        Checker();

        if (films_by_country.size() != 0) {
            Listing();
        }
        else {
            Failed();
        }
    }

    //checks the films and if there is any films with the correct country it adds them into films_by_country
    private static void Checker(){
        for (Films film: FilmsConstructor.filmobjects){
            if(film.country.equals(listcommand[4])){
                films_by_country.add(film);
            }
        }
    }

    //gives the correct output for the working command
    private static void  Listing(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n");

            for (Films film: films_by_country){

                br.write("Film Title: " + film.filmtitle +"\n");
                br.write(film.runtime + " min\n");
                br.write("Language: "+ film.language + "\n\n");

            }

            br.write("-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //gives the correct output if there's films with that country
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
