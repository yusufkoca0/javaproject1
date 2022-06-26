
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class AddCommand {

    public static String command;
    public static String[] addcommand;
    public static Films addingfilm;
    public static ArrayList<String> directorarray_list;
    public static ArrayList<String> writerarray_list;
    public static ArrayList<String> castarray_list;
    public static ArrayList<String> genrearray_list;

    //this function sets up to add command proccess and calls CheckAddCommand method
    //if that method is true it calls AddingFilm method, if it is false it calls AddingFailed method
    public static void ExecuteAddCommand(String cmd){
        command = cmd;
        addcommand = command.split("\t",13);

        if(CheckAddCommand()){
            AddingFilm();
        }
        else {
            AddingFailed();
        }
    }

    //this emthod checks if the given filmid exists in the system
    //if it exists it returns false if it does not exist it returns true
    private static boolean CheckAddCommand(){
        for (FeatureFilm film: FilmsConstructor.featurefilmobjects){
            if(film.filmid.equals(addcommand[2])){
                addingfilm = film;
                return false;
            }

        }

        for (ShortFilm film: FilmsConstructor.shortfilmobjects){
            if(film.filmid.equals(addcommand[2])){
                addingfilm = film;
                return false;
            }
        }

        for (Documentary film: FilmsConstructor.documentaryobjects){
            if(film.filmid.equals(addcommand[2])){
                addingfilm = film;
                return false;
            }
        }

        for (TVSeries film: FilmsConstructor.tvseriesobjects){
            if(film.filmid.equals(addcommand[2])){
                addingfilm = film;
                return false;
            }
        }
        return true;
    }

    //this method is called when CheckAddCommand is true
    //this method once again does a checking operation, it checks if the directors, writers and cast ids exist
    //if the stated ids exist it calls Adding function, if not it calls AddingFailed function
    private static void AddingFilm(){
        if(CheckDirector()){
            if(CheckWriter()){
                if(CheckCast()){
                    Adding();
                }
                else {
                    AddingFailed();
                }
            }
            else {
                AddingFailed();
            }
        }
        else {
            AddingFailed();
        }
    }

    //Checks if stated directors exist
    private static boolean CheckDirector(){

        boolean checker = true;

        //Splits the director part of the command into an arraylist
        String[] directors = addcommand[5].split(",");
        directorarray_list = new ArrayList<>();
        Collections.addAll(directorarray_list, directors);

        //Starts looping ids in the command
        for(String id: directorarray_list){
            // if checker is true it checks the directors
            // this prevents it looping for example if there's 3 directors but first one is already dont exist
            //then it simply doesnt check other directors in the command
            if(checker) {
                for (Director obj : PeopleConstructor.directorobjects) {
                    //if the directors id and the id in the command matches it assigns checker to true
                    //and stops the loop and starts checking the other id in the command
                    //if it does not match it makes the checker false but continues to search a matching one
                    //if it does not find a matching one then checker stays false so it doesnt check other other ids
                    //and function returns false
                    if (obj.userid.equals(id)) {
                        checker = true;
                        break;
                    }
                    else {
                        checker = false;
                    }
                }
            }
        }
        return checker;
    }

    //Checks if stated writers exist
    private static boolean CheckWriter(){

        boolean checker = true;

        //Splits the writer part of the command into an arraylist
        String[] writers = addcommand[11].split(",");
        writerarray_list = new ArrayList<>();
        Collections.addAll(writerarray_list, writers);

        //Starts looping ids in the command
        for(String id: writerarray_list){
            // if checker is true it checks the writers
            // this prevents it looping for example if there's 3 directors but first one is already dont exist
            //then it simply doesnt check other writers in the command
            if(checker) {
                for (Writer obj : PeopleConstructor.writerobjects) {
                    //if the writers id and the id in the command matches it assigns checker to true
                    //and stops the loop and starts checking the other id in the command
                    //if it does not match it makes the checker false but continues to search a matching one
                    //if it does not find a matching one then checker stays false so it doesnt check other other ids
                    //and function returns false
                    if (obj.userid.equals(id)) {
                        checker = true;
                        break;
                    }
                    else {
                        checker = false;
                    }
                }
            }
        }
        return checker;
    }

    //Checks if stated cast members exist
    private static boolean CheckCast(){
        boolean checker = true;

        //Splits the cast part of the command into an arraylist
        String[] cast = addcommand[8].split(",");
        castarray_list = new ArrayList<>();
        Collections.addAll(castarray_list, cast);

        //Starts looping ids in the command
        for(String id: castarray_list){
            // if checker is true it checks the objects of performer class
            //this prevents it looping for example if there's 3 directors but first one is already dont exist
            //then it simply doesnt check other cast members in the command
            if(checker) {

                //if the performers id and the id in the command matches it assigns checker to true
                //and stops the loop and starts checking the other id in the command
                //if it does not match it makes the checker false but continues to search a matching one
                //if it does not find a matching one then checker stays false so it returns false

                for (Performer obj : PeopleConstructor.performerobjects) {
                    if (obj.userid.equals(id)) {
                        checker = true;
                        break;
                    }
                    else {
                        checker = false;
                    }
                }
            }
        }
        return checker;
    }

    //this method is called when CheckAddCommand is false
    //or when it is true but a director, writer or cast member does not exist in the system
    //it writes the failed output into the output file in the correct form
    private static void AddingFailed(){

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n" + "Command Failed\n" + "Film ID: " + addcommand[2] + "\nFilm title: " + addcommand[3]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

    //it writes the add output into the output file in the correct form
    //it also creates the FeatureFilm object for the stated film in the command
    private static void Adding(){

        String[] genre = addcommand[9].split(",");
        genrearray_list = new ArrayList<>();
        Collections.addAll(genrearray_list, genre);

        FilmsConstructor.featurefilmobjects.add(new FeatureFilm(addcommand[2], addcommand[3], addcommand[4],
                directorarray_list, addcommand[6], addcommand[7], castarray_list,
                genrearray_list, addcommand[10], writerarray_list, addcommand[12]));
        FilmsConstructor.filmobjects.add(FilmsConstructor.featurefilmobjects.get(FilmsConstructor.featurefilmobjects.size()-1));


        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n" + "FeatureFilm added successfully\n" + "Film ID: " + addcommand[2] + "\nFilm title: " + addcommand[3]);

            br.write("\n\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }
}

