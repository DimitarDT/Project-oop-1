package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.UnknownCommandException;

/**
 * Interface representing a command in the Star Wars Jedi system's CLI.
 * Provides static methods for printing the application title,
 * command menu, and help information.
 * Each implementing class must define the {@link #execute()} method,
 * which executes the command logic.
 */
public interface CLI {

    /**
     * Prints the Star Wars styled title banner to the console.
     */
    static void printTitle(){
        System.out.println("\nA long time ago in a galaxy far, far away...\n\n");
        System.out.println("     _______.___________.    ___      .______         ____    __    ____  ___      .______          _______.");
        System.out.println("    /       |           |   /   \\     |   _  \\        \\   \\  /  \\  /   / /   \\     |   _  \\        /       |");
        System.out.println("   |   (----`---|  |----`  /  ^  \\    |  |_)  |        \\   \\/    \\/   / /  ^  \\    |  |_)  |      |   (----`");
        System.out.println("    \\   \\       |  |      /  /_\\  \\   |      /          \\            / /  /_\\  \\   |      /        \\   \\    ");
        System.out.println(".----)   |      |  |     /  _____  \\  |  |\\  \\----.      \\    /\\    / /  _____  \\  |  |\\  \\----.----)   |   ");
        System.out.println("|_______/       |__|    /__/     \\__\\ | _| `._____|       \\__/  \\__/ /__/     \\__\\ | _| `._____|_______/    ");
        System.out.println("                                      === THE PROJECT STRIKES BACK ===\n");
    }

    /**
     * Prints the list of all available commands and their usage formats.
     */
    static void printMenu(){
        System.out.println("=== COMMAND MENU ===");
        System.out.println("add_planet <planet_name>");
        System.out.println("create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength>");
        System.out.println("remove_jedi <jedi_name> <planet_name>");
        System.out.println("promote_jedi <jedi_name> <multiplier>");
        System.out.println("demote_jedi <jedi_name> <multiplier>");
        System.out.println("get_strongest_jedi <planet_name>");
        System.out.println("get_youngest_jedi <planet_name> <jedi_rank>");
        System.out.println("get_most_used_saber_color <planet_name>");
        System.out.println("get_most_used_saber_color <planet_name> <jedi_rank>");
        System.out.println("print <planet_name>");
        System.out.println("print <jedi_name>");
        System.out.println("<planet_name> + <planet_name>");
        System.out.println("open <filename>");
        System.out.println("close");
        System.out.println("save_as <filename>");
        System.out.println("save");
        System.out.println("menu");
        System.out.println("help");
        System.out.println("exit");
    }

    /**
     * Prints detailed help information describing each command.
     */
    static void printHelp(){
        System.out.println("=== STAR WARS JEDI SYSTEM - HELP ===");
        System.out.println("Available commands:");
        System.out.println();

        System.out.println("add_planet <planet_name>");
        System.out.println("    - Adds a new planet to the system.");
        System.out.println();

        System.out.println("create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength>");
        System.out.println("    - Creates a new Jedi on the specified planet.");
        System.out.println();

        System.out.println("remove_jedi <jedi_name> <planet_name>");
        System.out.println("    - Removes a Jedi from the specified planet.");
        System.out.println();

        System.out.println("promote_jedi <jedi_name> <multiplier>");
        System.out.println("    - Promotes the Jedi to the next rank and increases strength.");
        System.out.println();

        System.out.println("demote_jedi <jedi_name> <multiplier>");
        System.out.println("    - Demotes the Jedi to the previous rank and decreases strength.");
        System.out.println();

        System.out.println("get_strongest_jedi <planet_name>");
        System.out.println("    - Prints the strongest Jedi on the specified planet.");
        System.out.println();

        System.out.println("get_youngest_jedi <planet_name> <jedi_rank>");
        System.out.println("    - Prints the youngest Jedi of the specified rank on the planet.");
        System.out.println();

        System.out.println("get_most_used_saber_color <planet_name>");
        System.out.println("    - Shows the most used saber color by GRAND_MASTERs on the planet.");
        System.out.println();

        System.out.println("get_most_used_saber_color <planet_name> <jedi_rank>");
        System.out.println("    - Shows the most used saber color among Jedi of the given rank on the planet.");
        System.out.println();

        System.out.println("print <planet_name>");
        System.out.println("    - Prints the planet and its Jedi sorted by rank and name.");
        System.out.println();

        System.out.println("print <jedi_name>");
        System.out.println("    - Prints the details of a Jedi");
        System.out.println();

        System.out.println("<planet_name> + <planet_name>");
        System.out.println("    - Prints all Jedi from both planets sorted alphabetically.");
        System.out.println();

        System.out.println("open <filename>");
        System.out.println("    - Loads data from the specified file.");
        System.out.println();

        System.out.println("close");
        System.out.println("    - Clears current data and closes file.");
        System.out.println();

        System.out.println("save_as <filename>");
        System.out.println("    - Saves all data to the specified file.");
        System.out.println();

        System.out.println("save");
        System.out.println("    - Saves all data to the already opened file.");
        System.out.println();

        System.out.println("menu");
        System.out.println("    - Shows main menu.");
        System.out.println();

        System.out.println("help");
        System.out.println("    - Shows this help message.");
        System.out.println();

        System.out.println("exit");
        System.out.println("    - Exits the program.");
        System.out.println();
    }

    /**
     * Executes the command.
     *
     * @throws UnknownCommandException if the command is not recognized or cannot be executed
     */
    void execute() throws UnknownCommandException;
}
