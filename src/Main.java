

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {


    public static ArrayList<String> peoples;
    public static ArrayList<String> films;
    public static ArrayList<String> commands;
    public static String output;

    public Main() {
    }

    public static void main(String[] args) {

        output = args[3];
        peoples = new ArrayList<>();
        films = new ArrayList<>();
        commands = new ArrayList<>();

        //clears the output file at the start
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(output));
            br.close();
        } catch (Exception ex) {
            return;
        }

        //reads people.txt and splits its lines to an arraylist
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String s;
            while ((s = br.readLine()) != null) {
                peoples.add(s);

            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        //reads films.txt and splits its lines to an arraylist
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[1]));
            String s;
            while ((s = br.readLine()) != null) {
                films.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        //reads commands.txt and splits its lines to an arraylist
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[2]));
            String s;
            while ((s = br.readLine()) != null) {
                commands.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        //calls the function to create person objects
        PeopleConstructor.PersonConstruct();

        //calls the function to create film objects
        FilmsConstructor.FilmConstructor();

        //calls the function to execute commands
        Commands.ExecuteCommands();
    }
}
