package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.UnknownCommandException;

import java.util.Map;

public class CommandLineInterface implements CLI{
    private final Map<CommandEnum, Command> commands;
    private final String input;

    public CommandLineInterface(String input) {
        this.commands = Map.ofEntries(
                Map.entry(CommandEnum.ADD_PLANET, new CommandAddPlanet()),
                Map.entry(CommandEnum.CREATE_JEDI, new CommandCreateJedi()),
                Map.entry(CommandEnum.REMOVE_JEDI, new CommandRemoveJedi()),
                Map.entry(CommandEnum.PROMOTE_JEDI, new CommandPromoteJedi()),
                Map.entry(CommandEnum.DEMOTE_JEDI, new CommandDemoteJedi()),
                Map.entry(CommandEnum.GET_STRONGEST_JEDI, new CommandGetStrongestJedi()),
                Map.entry(CommandEnum.GET_YOUNGEST_JEDI, new CommandGetYoungestJedi()),
                Map.entry(CommandEnum.GET_MOST_USED_SABER_COLOR, new CommandGetMostUsedSaberColor()),
                Map.entry(CommandEnum.PRINT, new CommandPrint()),
                Map.entry(CommandEnum.PRINT_TWO_PLANETS, new CommandPrintTwoPlanets()),
                Map.entry(CommandEnum.SAVE_AS, new CommandSaveAs()),
                Map.entry(CommandEnum.SAVE, new CommandSave()),
                Map.entry(CommandEnum.OPEN, new CommandReadFromFile()),
                Map.entry(CommandEnum.CLOSE, new CommandClose()),
                Map.entry(CommandEnum.MENU, new CommandMenu()),
                Map.entry(CommandEnum.HELP, new CommandHelp())
        );
        this.input = input;
    }

    @Override
    public void execute() throws UnknownCommandException {
        if(input.matches("\\b\\w+\\b\\s*\\+\\s*\\b\\w+\\b")) {
            commands.get(CommandEnum.PRINT_TWO_PLANETS).execute(input.split("\\s+"));
            return;
        }
        String[] splitInput = input.trim().split("\\s+");

        try {
            if(!(commands.containsKey(CommandEnum.valueOf(splitInput[0].toUpperCase())))) {
                throw new UnknownCommandException("Unknown command. Type help for a list of commands.");
            }
            commands.get(CommandEnum.valueOf(splitInput[0].toUpperCase())).execute(splitInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument type or count. Please, refer to \"help\" for a list of commands.");
        }
    }
}