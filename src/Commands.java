
public class Commands {

    public static void ExecuteCommands() {

        for (String command : Main.commands) {
            if (command.startsWith("ADD")) {
                AddCommand.ExecuteAddCommand(command);
            } else if (command.startsWith("VIEWFILM")) {
                ViewfilmCommand.ExecuteViewFilmCommand(command);
            } else if (command.startsWith("RATE")) {
                RateCommand.ExecuteRateCommand(command);
            } else if (command.startsWith("EDIT")) {
                EditRateCommand.ExecuteEditRateCommand(command);
            } else if (command.startsWith("REMOVE")) {
                RemoveRateCommand.ExecuteRemoveRateCommand(command);
            } else if (command.startsWith("LIST\tUSER")) {
                ListUserRatesCommand.ExecuteListUserRateCommand(command);
            } else if (command.startsWith("LIST\tFILM\tSERIES")) {
                ListFilmSeriesCommand.ExecuteListFilmSeriesCommand(command);
            } else if (command.startsWith("LIST\tFILMS\tBY\tCOUNTRY")) {
                ListFilmsByCountryCommand.ExecuteListFilmsByCountryCommand(command);
            } else if (command.startsWith("LIST\tFEATUREFILMS\tAFTER")){
                ListFeaturefilmAfterCommand.ExecuteListFeaturefilmAfterCommand(command);
            } else if (command.startsWith("LIST\tFEATUREFILMS\tBEFORE")){
                ListFeaturefilmBeforeCommand.ExecuteListFeaturefilmBeforeCommand(command);
            } else if (command.startsWith("LIST\tFILMS\tBY\tRATE")){
                ListFilmsByRateCommand.ExecuteListFilmsByRateCommand(command);
            }else if (command.startsWith("LIST\tARTISTS\tFROM")){
                ListArtistsFromCountryCommand.ExecuteListArtistsByCountryCommand(command);
            }
        }
    }
}
