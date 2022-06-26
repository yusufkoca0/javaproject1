

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ListFilmSeriesCommand {

    public static String command;

    //this function sets up to ListFilmSeries command proccess and checks if any tvseries exist
    //if it does it calls Listing method
    //if it does not it calls Failed method
    public static void ExecuteListFilmSeriesCommand(String cmd){
        command = cmd;
        if (FilmsConstructor.tvseriesobjects.size() != 0) {
            Listing();
        }
        else {
            Failed();
        }
    }

    //gives the correct output for the working command
    private static void  Listing(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n");

            for (TVSeries series: FilmsConstructor.tvseriesobjects){
                String[] startyear = series.getStartDate().split("\\.");
                String[] endyear = series.getEndDate().split("\\.");

                br.write(series.filmtitle + " (" + startyear[2] + "-" + endyear[2] + ")\n");
                br.write(series.getNumberofSeasons() + " seasons and " + series.getNumberofEpisodes() + " episodes\n\n");

            }

            br.write("-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //gives the correct output if there's no tvseries
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
