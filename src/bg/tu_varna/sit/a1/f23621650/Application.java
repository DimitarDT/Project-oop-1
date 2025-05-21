package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Commands.CLI;
import bg.tu_varna.sit.a1.f23621650.Commands.CommandLineInterface;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.UnknownCommandException;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        /*StarWarsUniverse starWarsUniverse = StarWarsUniverse.getInstance();
        try {
            starWarsUniverse.addPlanetToUniverse("Coruscant");
            starWarsUniverse.addPlanetToUniverse("Tatooine");
            starWarsUniverse.addPlanetToUniverse("Naboo");
            starWarsUniverse.addPlanetToUniverse("Kashyyyk");
            starWarsUniverse.addPlanetToUniverse("Alderaan");

            starWarsUniverse.createJedi("Coruscant", "Mace Windu", JediRank.GRAND_MASTER, 53, "purple", 1.95);
            starWarsUniverse.createJedi("Coruscant", "Depa", JediRank.GRAND_MASTER, 45, "green", 1.7);
            starWarsUniverse.createJedi("Coruscant", "Drallig", JediRank.GRAND_MASTER, 50, "green", 1.8);

            starWarsUniverse.createJedi("Tatooine", "Anakin", JediRank.KNIGHT, 22, "blue", 1.98);
            starWarsUniverse.createJedi("Tatooine", "Luke", JediRank.KNIGHT, 23, "green", 1.95);
            starWarsUniverse.createJedi("Tatooine", "A'Sharad Hett", JediRank.KNIGHT, 27, "blue", 1.75);

            starWarsUniverse.createJedi("Naboo", "Qui-Gon", JediRank.MASTER, 48, "green", 1.85);
            starWarsUniverse.createJedi("Naboo", "Tera Sinube", JediRank.MASTER, 200, "blue", 1.65);
            starWarsUniverse.createJedi("Naboo", "Yarael Poof", JediRank.MASTER, 300, "blue", 1.7);

            starWarsUniverse.createJedi("Kashyyyk", "Gungi", JediRank.YOUNGLING, 12, "green", 1.2);
            starWarsUniverse.createJedi("Kashyyyk", "Tyvokka", JediRank.MASTER, 250, "green", 1.9);
            starWarsUniverse.createJedi("Kashyyyk", "Jaro Tapal", JediRank.MASTER, 38, "double-bladed blue", 1.85);

            starWarsUniverse.createJedi("Alderaan", "Zett Jukassa", JediRank.PADAWAN, 12, "blue", 1.4);
            starWarsUniverse.createJedi("Alderaan", "Bail", JediRank.INITIATE, 20, "none", 1.3);
            starWarsUniverse.createJedi("Alderaan", "Tynnra Pamlo", JediRank.YOUNGLING, 10, "yellow", 1.2);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        CLI.printTitle();
        CLI.printMenu();
        while (true) {
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equals("exit")) {
                break;
            }
            CLI cli = new CommandLineInterface(input);
            try {
                cli.execute();
            } catch (UnknownCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
