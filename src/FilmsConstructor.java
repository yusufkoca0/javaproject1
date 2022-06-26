

import java.util.ArrayList;
import java.util.Collections;

public class FilmsConstructor {

    //One arraylist to hold all film objects
    public static ArrayList<Films> filmobjects;
    //Four different arraylists for each film class
    public static ArrayList<FeatureFilm> featurefilmobjects;
    public static ArrayList<ShortFilm> shortfilmobjects;
    public static ArrayList<Documentary> documentaryobjects;
    public static ArrayList<TVSeries> tvseriesobjects;


    //This function takes the arraylist of each line of films.txt from Main class
    //and calls object const functions according to the part before the first \t
    public static void FilmConstructor(){

        filmobjects = new ArrayList<>();
        featurefilmobjects = new ArrayList<>();
        shortfilmobjects = new ArrayList<>();
        documentaryobjects = new ArrayList<>();
        tvseriesobjects = new ArrayList<>();


        for(String film: Main.films){

            if(film.startsWith("FeatureFilm:")){
                FeatureFilmConst(film);
            }
            else if(film.startsWith("ShortFilm:")){
                ShortFilmConst(film);
            }
            else if(film.startsWith("Documentary:")){
                DocumentaryConst(film);
            }
            else if(film.startsWith("TVSeries:")){
                TVSeriesConst(film);
            }
        }



    }


    //Methods that creates film objects
    private static void FeatureFilmConst(String featurefilm){
        //Splits the line according to "\t"
        String[] filmarray;
        filmarray = featurefilm.split("\t", 12);

        //creates arraylists for the required attributes
        String[] directorarray = filmarray[4].split(",");
        String[] castarray = filmarray[7].split(",");
        String[] filmgenrearray = filmarray[8].split(",");
        String[] writerarray = filmarray[10].split(",");

        ArrayList<String> directorarray_list = new ArrayList<>();
        Collections.addAll(directorarray_list, directorarray);

        ArrayList<String> castarray_list = new ArrayList<>();
        Collections.addAll(castarray_list, castarray);

        ArrayList<String> filmgenrearray_list = new ArrayList<>();
        Collections.addAll(filmgenrearray_list, filmgenrearray);

        ArrayList<String> writerarray_list = new ArrayList<>();
        Collections.addAll(writerarray_list, writerarray);
        //

        featurefilmobjects.add(new FeatureFilm(filmarray[1], filmarray[2], filmarray[3], directorarray_list,
                filmarray[5],filmarray[6], castarray_list, filmgenrearray_list, filmarray[9], writerarray_list, filmarray[11]));

        filmobjects.add(featurefilmobjects.get(featurefilmobjects.size()-1));
    }

    private static void ShortFilmConst(String shortfilm){
        //Splits the line according to "\t"
        String[] filmarray;
        filmarray = shortfilm.split("\t", 11);

        //creates arraylists for the required attributes
        String[] directorarray = filmarray[4].split(",");
        String[] castarray = filmarray[7].split(",");
        String[] filmgenrearray = filmarray[8].split(",");
        String[] writerarray = filmarray[10].split(",");

        ArrayList<String> directorarray_list = new ArrayList<>();
        Collections.addAll(directorarray_list, directorarray);

        ArrayList<String> castarray_list = new ArrayList<>();
        Collections.addAll(castarray_list, castarray);

        ArrayList<String> filmgenrearray_list = new ArrayList<>();
        Collections.addAll(filmgenrearray_list, filmgenrearray);

        ArrayList<String> writerarray_list = new ArrayList<>();
        Collections.addAll(writerarray_list, writerarray);
        //
        if(Integer.parseInt(filmarray[5])<41){
            shortfilmobjects.add(new ShortFilm(filmarray[1], filmarray[2], filmarray[3], directorarray_list,
                    filmarray[5], filmarray[6], castarray_list, filmgenrearray_list, filmarray[9], writerarray_list));
            filmobjects.add(shortfilmobjects.get(shortfilmobjects.size()-1));
        }
        else{
            System.out.println("Short film must be shorter than 40 minutes.");
        }
    }

    private static void DocumentaryConst(String documentary){
        //Splits the line according to "\t"
        String[] filmarray;
        filmarray = documentary.split("\t", 9);

        //creates arraylists for the required attributes
        String[] directorarray = filmarray[4].split(",");
        String[] castarray = filmarray[7].split(",");

        ArrayList<String> directorarray_list = new ArrayList<>();
        Collections.addAll(directorarray_list, directorarray);

        ArrayList<String> castarray_list = new ArrayList<>();
        Collections.addAll(castarray_list, castarray);

        //

        documentaryobjects.add(new Documentary(filmarray[1], filmarray[2], filmarray[3], directorarray_list,
                filmarray[5],filmarray[6], castarray_list, filmarray[8]));
        filmobjects.add(documentaryobjects.get(documentaryobjects.size()-1));
    }

    private static void TVSeriesConst(String tvseries){
        //Splits the line according to "\t"
        String[] filmarray;
        filmarray = tvseries.split("\t", 14);

        //creates arraylists for the required attributes
        String[] directorarray = filmarray[4].split(",");
        String[] castarray = filmarray[7].split(",");
        String[] filmgenrearray = filmarray[8].split(",");
        String[] writerarray = filmarray[9].split(",");

        ArrayList<String> directorarray_list = new ArrayList<>();
        Collections.addAll(directorarray_list, directorarray);

        ArrayList<String> castarray_list = new ArrayList<>();
        Collections.addAll(castarray_list, castarray);

        ArrayList<String> filmgenrearray_list = new ArrayList<>();
        Collections.addAll(filmgenrearray_list, filmgenrearray);

        ArrayList<String> writerarray_list = new ArrayList<>();
        Collections.addAll(writerarray_list, writerarray);
        //

        tvseriesobjects.add(new TVSeries(filmarray[1], filmarray[2], filmarray[3], directorarray_list,
                filmarray[5],filmarray[6], castarray_list, filmgenrearray_list, writerarray_list, filmarray[10],
                filmarray[11], filmarray[12], filmarray[13]));
        filmobjects.add(tvseriesobjects.get(tvseriesobjects.size()-1));
    }


}
