
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ListArtistsFromCountryCommand {

    public static String command;
    public static String[] listcommand;
    public static ArrayList<Director> directors_by_country;
    public static ArrayList<Writer> writers_by_country;
    public static ArrayList<Actor> actors_by_country;
    public static ArrayList<ChildActor> childActors_by_country;
    public static ArrayList<StuntPerformer> stuntPerformers_by_country;

    //this function sets up to ListArtistsByCountry command proccess and and calls Checker method
    //Then it calls Listing methed
    public static void ExecuteListArtistsByCountryCommand(String cmd){
        command = cmd;
        listcommand = command.split("\t");
        directors_by_country = new ArrayList<>();
        writers_by_country = new ArrayList<>();
        actors_by_country = new ArrayList<>();
        childActors_by_country = new ArrayList<>();
        stuntPerformers_by_country = new ArrayList<>();

        Checker();

        Listing();
    }

    //checks the artists and if there is any artist with the correct country it adds them into correct type of arraylist
    //according to their personType
    private static void Checker(){
        for (Director director: PeopleConstructor.directorobjects){
            if(director.country.equals(listcommand[3])){
                directors_by_country.add(director);

            }
        }
        for (Writer writer: PeopleConstructor.writerobjects){
            if(writer.country.equals(listcommand[3])){
                writers_by_country.add(writer);

            }
        }
        for (Actor actor: PeopleConstructor.actorobjects){
            if(actor.country.equals(listcommand[3])){
                actors_by_country.add(actor);

            }
        }
        for (ChildActor childActor: PeopleConstructor.childactorobjects){
            if(childActor.country.equals(listcommand[3])){
                childActors_by_country.add(childActor);

            }
        }
        for (StuntPerformer stuntPerformer: PeopleConstructor.stuntperformerobjects){
            if(stuntPerformer.country.equals(listcommand[3])){
                stuntPerformers_by_country.add(stuntPerformer);
            }
        }
    }

    //gives the correct output for the command
    private static void  Listing(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n");

            //writes directors
            br.write("Directors:\n");
            if(directors_by_country.size() != 0) {
                for (Director director : directors_by_country) {
                    br.write(director.name + " " + director.surname + " " + director.getAgent() + "\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes writers
            br.write("\nWriters:\n");
            if(writers_by_country.size() != 0) {
                for (Writer writer : writers_by_country) {
                    br.write(writer.name + " " + writer.surname + " " + writer.getWritingStyle() + "\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes actors
            br.write("\nActors:\n");
            if(actors_by_country.size() != 0) {
                for (Actor actor : actors_by_country) {
                    br.write(actor.name + " " + actor.surname + " " + actor.getHeight() + " cm\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes childActors
            br.write("\nChildActors:\n");
            if(childActors_by_country.size() != 0) {
                for (ChildActor childActor : childActors_by_country) {
                    br.write(childActor.name + " " + childActor.surname + " " + childActor.getAge() + "\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes stuntPerformers
            br.write("\nStuntPerformers:\n");
            if(stuntPerformers_by_country.size() != 0) {
                for (StuntPerformer stuntPerformer : stuntPerformers_by_country) {
                    br.write(stuntPerformer.name + " " + stuntPerformer.surname + " " + stuntPerformer.getHeight() + " cm\n");
                }
            }else {
                br.write("No result\n");
            }



            br.write("\n-----------------------------------------------------------------------------------------------------\n");
            br.close();
        } catch (Exception ex) {
            return;
        }
    }

}
