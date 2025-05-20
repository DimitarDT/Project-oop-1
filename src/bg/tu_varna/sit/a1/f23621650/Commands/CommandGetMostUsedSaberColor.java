package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

/**
 * Command to get the most used saber color on a planet, optionally filtered by Jedi rank.
 * Usage:
 * - get_most_used_saber_color planet_name
 * - get_most_used_saber_color planet_name jedi_rank
 */
public class CommandGetMostUsedSaberColor implements Command {
    private final StarWarsUniverse universe;

    public CommandGetMostUsedSaberColor() {
        this.universe = StarWarsUniverse.getInstance();
    }

    /**
     * Executes the get_most_used_saber_color command.
     *
     * @param input command arguments:
     *              [command, planet_name] or
     *              [command, planet_name, jedi_rank]
     */
    @Override
    public void execute(String[] input) {
        if(input.length == 2) {
            try {
                universe.getMostUsedSaberColor(input[1]);
            } catch (JediManagementException e) {
                System.out.println("You searched for the most used saber color by grandmaster jedis. However... ");
                System.out.println(e.getMessage());
            }
        }
        else if(input.length == 3) {
            try {
                universe.getMostUsedSaberColor(input[1], JediRank.valueOf(input[2].toUpperCase()));
            } catch (JediManagementException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }
    }
}