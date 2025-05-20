package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.*;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.EmptyFileException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;

import java.io.IOException;

/**
 * Defines the behavior of the system depending on the current state of the universe file.
 * <p>
 * Implementations of this interface represent different states of the application
 * (e.g., file unopened, file opened and saved, file opened and unsaved).
 * Each method corresponds to an operation that may be enabled, restricted,
 * or behave differently based on the state.
 */
public interface State {
    /**
     * Adds a new planet to the universe.
     * @param planetName the name of the planet to add
     * @throws PlanetManagementException if the planet already exists or other planet-related errors occur
     * @throws IOException if an I/O error occurs during the operation
     */
    void addPlanetToUniverse(String planetName) throws PlanetManagementException, IOException;

    /**
     * Creates a new Jedi and assigns it to a planet.
     * @param planetName the name of the planet the Jedi belongs to
     * @param jediName the name of the Jedi
     * @param jediRank the rank of the Jedi
     * @param jediAge the age of the Jedi
     * @param saberColor the color of the Jedi's lightsaber
     * @param jediStrength the strength value of the Jedi
     * @throws PlanetManagementException if the planet does not exist or other planet-related errors occur
     * @throws JediManagementException if the Jedi cannot be created due to conflicts or validation issues
     * @throws IOException if an I/O error occurs during the operation
     */
    void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException, IOException;

    /**
     * Removes a Jedi from a given planet.
     * @param jediName the name of the Jedi to remove
     * @param planetName the name of the planet from which to remove the Jedi
     * @throws PlanetManagementException if the planet does not exist
     * @throws JediManagementException if the Jedi does not exist or cannot be removed
     * @throws IOException if an I/O error occurs during the operation
     */
    void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException, IOException;

    /**
     * Promotes a Jedi by increasing rank and strength.
     * @param jediName the name of the Jedi to promote
     * @param multiplier the factor by which to increase the Jedi's strength
     * @throws JediManagementException if the Jedi is already at the highest rank or other promotion errors occur
     * @throws IOException if an I/O error occurs during the operation
     */
    void promote(String jediName, double multiplier) throws JediManagementException, IOException;

    /**
     * Demotes a Jedi by decreasing rank and strength.
     * @param jediName the name of the Jedi to demote
     * @param multiplier the factor by which to decrease the Jedi's strength
     * @throws JediManagementException if the Jedi is already at the lowest rank or other demotion errors occur
     * @throws IOException if an I/O error occurs during the operation
     */
    void demote(String jediName, double multiplier) throws JediManagementException, IOException;

    /**
     * Retrieves the strongest Jedi on a given planet.
     * @param planetName the name of the planet
     * @return the Jedi with the highest strength on the planet
     * @throws PlanetManagementException if the planet does not exist
     * @throws JediManagementException if there are no Jedis on the planet
     * @throws IOException if an I/O error occurs during the operation
     */
    Jedi getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException, IOException;

    /**
     * Retrieves the youngest Jedi of a specific rank on a given planet.
     * @param planetName the name of the planet
     * @param jediRank the rank to filter by
     * @return the youngest Jedi matching the rank, or null if none found
     * @throws PlanetManagementException if the planet does not exist
     * @throws JediManagementException if there are no Jedis of the specified rank on the planet
     * @throws IOException if an I/O error occurs during the operation
     */
    Jedi getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException, IOException;

    /**
     * Finds the most commonly used lightsaber color among Jedis of a specific rank on a planet.
     * @param planetName the name of the planet
     * @param jediRank the rank of Jedis to consider
     * @return the name of the most used lightsaber color
     * @throws JediManagementException if there are no Jedis of the specified rank on the planet
     * @throws IOException if an I/O error occurs during the operation
     */
    String getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException, IOException;

    /**
     * Finds the most commonly used lightsaber color among all Jedis on a planet.
     * @param planetName the name of the planet
     * @return the name of the most used lightsaber color
     * @throws JediManagementException if there are no Jedis on the planet
     * @throws IOException if an I/O error occurs during the operation
     */
    String getMostUsedSaberColor(String planetName) throws JediManagementException, IOException;

    /**
     * Prints detailed information about all Jedis on a given planet.
     * @param planetName the name of the planet
     * @return a formatted string representing the planet's Jedi inhabitants
     * @throws PlanetManagementException if the planet does not exist
     * @throws IOException if an I/O error occurs during the operation
     */
    String printPlanet(String planetName) throws PlanetManagementException, IOException;

    /**
     * Prints detailed information about a specific Jedi.
     * @param jediName the name of the Jedi
     * @return a formatted string representing the Jedi
     * @throws JediManagementException if the Jedi does not exist
     * @throws IOException if an I/O error occurs during the operation
     */
    String printJedi(String jediName) throws JediManagementException, IOException;

    /**
     * Prints detailed information about all Jedis on two given planets combined.
     * @param firstPlanetName the name of the first planet
     * @param secondPlanetName the name of the second planet
     * @return a formatted string representing the Jedis on both planets
     * @throws IOException if an I/O error occurs during the operation
     */
    String printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) throws IOException;

    /**
     * Saves the current universe state to the specified file.
     * @param fileName the path of the file to save to
     * @throws IOException if an I/O error occurs during saving
     */
    void writeToFile(String fileName) throws IOException;

    /**
     * Loads the universe state from the specified file.
     * @param fileName the path of the file to read from
     * @throws IOException if an I/O error occurs during reading
     * @throws ClassNotFoundException if the file content is incompatible with the expected classes
     * @throws EmptyFileException if the file exists but contains no data
     */
    void readFromFile(String fileName) throws IOException, ClassNotFoundException, EmptyFileException;

    /**
     * Closes the current universe session, performing any necessary cleanup.
     * @throws IOException if an I/O error occurs during the close operation
     */
    void close() throws IOException;
}
