

import java.util.ArrayList;
import java.util.Collections;

public class PeopleConstructor {
    //Three arraylist to hold superclass objects
    public static ArrayList<People> peopleobjects;
    public static ArrayList<User> userobjects;
    public static ArrayList<Artist> artistobjects;
    //Six different arraylists for each person class
    public static ArrayList<Performer> performerobjects;
    public static ArrayList<Director> directorobjects;
    public static ArrayList<Writer> writerobjects;
    public static ArrayList<Actor> actorobjects;
    public static ArrayList<ChildActor> childactorobjects;
    public static ArrayList<StuntPerformer> stuntperformerobjects;

    //This function takes the arraylist of each line of people.txt from Main class
    //and calls object const functions according to the part before the first \t
    public static void PersonConstruct(){
        peopleobjects = new ArrayList<>();
        artistobjects = new ArrayList<>();
        performerobjects = new ArrayList<>();
        userobjects = new ArrayList<>();
        directorobjects = new ArrayList<>();
        writerobjects = new ArrayList<>();
        actorobjects = new ArrayList<>();
        childactorobjects= new ArrayList<>();
        stuntperformerobjects = new ArrayList<>();


        for (String people: Main.peoples){

            if (people.startsWith("User:")){
                UserConst(people);
            }

            else if (people.startsWith("Director:")) {
                DirectorConst(people);
            }

            else if (people.startsWith("Writer:")) {
                WriterConst(people);
            }

            else if (people.startsWith("Actor:")) {
                ActorConst(people);
            }

            else if (people.startsWith("ChildActor:")) {
                ChildActorConst(people);
            }

            else if (people.startsWith("StuntPerformer:")) {
                StuntPerformerConst(people);
            }


        }
    }

    //Six different person constructor for each person class

    //Each constructor takes the line and splits it into parts according to \t
    //and creates objects from that splitted parts
    private static void UserConst(String user){

        String[] UserArray;
        UserArray = user.split("\t", 5);
        userobjects.add(new User(UserArray[1], UserArray[2], UserArray[3], UserArray[4]));
        peopleobjects.add(userobjects.get(userobjects.size()-1));
    }

    private static void DirectorConst(String director){

        String[] DirectorArray;
        DirectorArray = director.split("\t", 6);
        directorobjects.add(new Director(DirectorArray[1], DirectorArray[2], DirectorArray[3], DirectorArray[4], DirectorArray[5]));
        peopleobjects.add(directorobjects.get(directorobjects.size()-1));
        artistobjects.add(directorobjects.get(directorobjects.size()-1));
    }

    private static void WriterConst(String writer){

        String[] WriterArray;
        WriterArray = writer.split("\t",6);
        writerobjects.add(new Writer(WriterArray[1], WriterArray[2], WriterArray[3], WriterArray[4], WriterArray[5]));
        peopleobjects.add(writerobjects.get(writerobjects.size()-1));
        artistobjects.add(writerobjects.get(writerobjects.size()-1));
    }

    private static void ActorConst(String actor){

        String[] ActorArray;
        ActorArray = actor.split("\t", 6);
        actorobjects.add(new Actor(ActorArray[1], ActorArray[2], ActorArray[3], ActorArray[4], ActorArray[5]));
        peopleobjects.add(actorobjects.get(actorobjects.size()-1));
        artistobjects.add(actorobjects.get(actorobjects.size()-1));
        performerobjects.add(actorobjects.get(actorobjects.size()-1));
    }

    private static void ChildActorConst(String childactor){

        String[] ChildActorArray;
        ChildActorArray = childactor.split("\t",6);
        childactorobjects.add(new ChildActor(ChildActorArray[1], ChildActorArray[2], ChildActorArray[3], ChildActorArray[4], ChildActorArray[5]));
        peopleobjects.add(childactorobjects.get(childactorobjects.size()-1));
        artistobjects.add(childactorobjects.get(childactorobjects.size()-1));
        performerobjects.add(childactorobjects.get(childactorobjects.size()-1));
    }

    private static void StuntPerformerConst(String stuntperformer){
        String[] StuntPerformerArray;
        StuntPerformerArray = stuntperformer.split("\t", 7);

        //Only this class has this algorithm that takes the real actor ids splits them
        //according to "," and then makes that array an arraylist for the constructor
        String[] real_actor_ids_array = StuntPerformerArray[6].split(",");
        ArrayList<String> real_actor_ids = new ArrayList<>();
        Collections.addAll(real_actor_ids, real_actor_ids_array);
        //
        stuntperformerobjects.add(new StuntPerformer(StuntPerformerArray[1], StuntPerformerArray[2], StuntPerformerArray[3],
                StuntPerformerArray[4], StuntPerformerArray[5], real_actor_ids));
        peopleobjects.add(stuntperformerobjects.get(stuntperformerobjects.size()-1));
        artistobjects.add(stuntperformerobjects.get(stuntperformerobjects.size()-1));
        performerobjects.add(stuntperformerobjects.get(stuntperformerobjects.size()-1));
    }

}
