

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;


public class ListFilmsByRateCommand {

    public static String command;
    public static String[] listcommand;
    public static ArrayList<FeatureFilm> featureFilms;
    public static ArrayList<ShortFilm> shortFilms;
    public static ArrayList<Documentary> documentaries;
    public static ArrayList<TVSeries> tvSeries;

    //this function sets up to ListFilmsByRateCommand command proccess and and calls Sorter method
    //Then it calls Listing methed
    public static void ExecuteListFilmsByRateCommand(String cmd){


        command = cmd;
        listcommand = command.split("\t");
        featureFilms = new ArrayList<>();
        shortFilms = new ArrayList<>();
        documentaries = new ArrayList<>();
        tvSeries = new ArrayList<>();

        featureFilms = FilmsConstructor.featurefilmobjects;
        shortFilms = FilmsConstructor.shortfilmobjects;
        documentaries = FilmsConstructor.documentaryobjects;
        tvSeries = FilmsConstructor.tvseriesobjects;

        Sorter();

        Listing();
    }

    //first it sets the ratings for all objects of all class types
    //then it sorts them accordin to their ratings
    private static void Sorter(){


        for (FeatureFilm film: featureFilms){
            film.setRating();
            if(film.rating.equals("Awaiting for votes")){
                film.rating = "0";
            }
        }
        for (ShortFilm film: shortFilms){
            film.setRating();
            if(film.rating.equals("Awaiting for votes")){
                film.rating = "0";
            }
        }
        for (Documentary film: documentaries){
            film.setRating();
            if(film.rating.equals("Awaiting for votes")){
                film.rating = "0";
            }
        }
        for (TVSeries film: tvSeries){
            film.setRating();
            if(film.rating.equals("Awaiting for votes")){
                film.rating = "0";
            }
        }

        featureFilms.sort(new Comparator<FeatureFilm>() {
            @Override
            public int compare(FeatureFilm o1, FeatureFilm o2) {
                return Double.compare(Double.parseDouble(o2.rating.replace(',', '.')),
                        Double.parseDouble(o1.rating.replace(',', '.')));


            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        shortFilms.sort(new Comparator<ShortFilm>() {
            @Override
            public int compare(ShortFilm o1, ShortFilm o2) {
                return Double.compare(Double.parseDouble(o2.rating.replace(',', '.')),
                        Double.parseDouble(o1.rating.replace(',', '.')));
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        documentaries.sort(new Comparator<Documentary>() {
            @Override
            public int compare(Documentary o1, Documentary o2) {
                return Double.compare(Double.parseDouble(o2.rating.replace(',', '.')),
                        Double.parseDouble(o1.rating.replace(',', '.')));
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

        tvSeries.sort(new Comparator<TVSeries>() {
            @Override
            public int compare(TVSeries o1, TVSeries o2) {
                return Double.compare(Double.parseDouble(o2.rating.replace(',', '.')),
                        Double.parseDouble(o1.rating.replace(',', '.')));
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });

    }

    //gives the correct output for the command
    private static void  Listing(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(Main.output, true));

            br.write(command + "\n\n");

            //writes featureFilms
            br.write("FeatureFilm:\n");
            if(featureFilms.size() != 0) {
                for (FeatureFilm film : featureFilms) {
                    String[] year;
                    year = film.getReleaseDate().split("\\.");

                    br.write(film.filmtitle + " (" + year[2] + ") " + "Ratings: " + film.rating + "/10 from " +
                             film.allratings.size() + " users" + "\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes ShortFilm
            br.write("\nShortFilm:\n");
            if(featureFilms.size() != 0) {
                for (ShortFilm film : shortFilms) {
                    String[] year;
                    year = film.getReleaseDate().split("\\.");

                    br.write(film.filmtitle + " (" + year[2] + ") " + "Ratings: " + film.rating + "/10 from " +
                            film.allratings.size() + " users" + "\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes Documentary
            br.write("\nDocumentary:\n");
            if(featureFilms.size() != 0) {
                for (Documentary film : documentaries) {
                    String[] year;
                    year = film.getReleaseDate().split("\\.");

                    br.write(film.filmtitle + " (" + year[2] + ") " + "Ratings: " + film.rating + "/10 from " +
                            film.allratings.size() + " users" + "\n");
                }
            }else {
                br.write("No result\n");
            }

            //writes TVSeries
            br.write("\nTVSeries:\n");
            if(featureFilms.size() != 0) {
                for (TVSeries film : tvSeries) {
                    String[] start;
                    String[] end;
                    start = film.getStartDate().split("\\.");
                    end = film.getEndDate().split("\\.");

                    br.write(film.filmtitle + " (" + start[2] + "-" + end[2] + ") " + "Ratings: " + film.rating + "/10 from " +
                            film.allratings.size() + " users" +"\n");
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
