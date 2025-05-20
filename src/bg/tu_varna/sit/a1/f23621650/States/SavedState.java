package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.*;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.FileHandling.UniverseWriter;

import java.io.IOException;

/**
 * Represents the state of the application when a universe file is currently opened
 * and no unsaved changes exist.
 * <p>
 * This state allows full access to Jedi and Planet management operations.
 * All methods in this state operate on singleton instances of {@link JediManager} and {@link PlanetManager}.
 * The system supports adding/removing jedis and planets, promotions/demotions,
 * querying data, printing details, saving to file, and closing the file.
 * </p>
 * <p>
 * Operations assume a valid universe file is loaded, so exceptions are thrown
 * if requested planets or jedis do not exist.
 * </p>
 */
public class SavedState extends AbstractState {

    /**
     * Constructs a new SavedState initializing references to the singleton managers.
     */
    public SavedState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    /**
     * Adds a new planet to the universe.
     *
     * @param planetName the name of the planet to add
     * @throws PlanetManagementException if the planet already exists
     */
    @Override
    public void addPlanetToUniverse(String planetName) throws PlanetManagementException {
        planetManager.addPlanet(planetName);
    }

    /**
     * Creates and adds a new Jedi to the specified planet.
     *
     * @param planetName the name of the planet to add the Jedi to
     * @param jediName the name of the Jedi
     * @param jediRank the rank of the Jedi
     * @param jediAge the age of the Jedi
     * @param saberColor the color of the Jedi's saber
     * @param jediStrength the strength value of the Jedi
     * @throws PlanetManagementException if the planet does not exist
     * @throws JediManagementException if the Jedi already exists or other Jedi-related errors occur
     */
    @Override
    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName)))
        {
            throw new PlanetManagementException("Jedi creation wasn't successful. There is no such planet.");
        }
        jediManager.addJedi(new Jedi(jediName, jediRank, jediAge, saberColor, jediStrength, planetManager.getPlanet(planetName)));
    }

    /**
     * Removes a Jedi from the specified planet.
     *
     * @param jediName the name of the Jedi to remove
     * @param planetName the name of the planet the Jedi belongs to
     * @throws PlanetManagementException if the planet does not exist
     * @throws JediManagementException if the Jedi does not exist on the planet
     */
    @Override
    public void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName)))
        {
            throw new PlanetManagementException("Jedi removal wasn't successful. There is no such planet.");
        }
        jediManager.removeJedi(jediName, planetManager.getPlanet(planetName));
    }

    /**
     * Promotes a Jedi by increasing their strength.
     *
     * @param jediName   The name of the Jedi to promote.
     * @param multiplier The multiplier to increase strength by.
     * @throws JediManagementException if the Jedi is not found.
     * @throws IllegalArgumentException if the multiplier is not positive.
     */
    @Override
    public void promote(String jediName, double multiplier) throws JediManagementException {
        if(multiplier <= 0)
            throw new IllegalArgumentException("Multiplier must be positive number!");
        jediManager.getJedi(jediName).promoteJedi(multiplier);
    }

    /**
     * Demotes a Jedi by decreasing their strength.
     *
     * @param jediName   The name of the Jedi to demote.
     * @param multiplier The multiplier to reduce strength by.
     * @throws JediManagementException if the Jedi is not found.
     * @throws IllegalArgumentException if the multiplier is not positive.
     */
    @Override
    public void demote(String jediName, double multiplier) throws JediManagementException {
        if(multiplier <= 0)
            throw new IllegalArgumentException("Multiplier must be positive number!");
        jediManager.getJedi(jediName).demoteJedi(multiplier);
    }

    /**
     * Gets the strongest Jedi on a planet.
     *
     * @param planetName The name of the planet.
     * @return The strongest Jedi.
     * @throws PlanetManagementException if the planet doesn't exist.
     * @throws JediManagementException if no Jedis exist on the planet.
     */
    @Override
    public Jedi getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        return planetManager.getPlanet(planetName).getStrongestJedi();
    }

    /**
     * Gets the youngest Jedi of a specific rank on a planet.
     *
     * @param planetName The planet name.
     * @param jediRank   The Jedi rank.
     * @return The youngest Jedi of that rank.
     * @throws PlanetManagementException if the planet doesn't exist.
     * @throws JediManagementException if no Jedis of that rank exist.
     */
    @Override
    public Jedi getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        return planetManager.getPlanet(planetName).getYoungestJedi(jediRank);
    }

    /**
     * Gets the most used saber color by Jedi of a given rank on a planet.
     *
     * @param planetName The planet name.
     * @param jediRank   The rank of Jedi to consider.
     * @return Most used saber color.
     * @throws JediManagementException if retrieval fails.
     */
    @Override
    public String getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException {
        return planetManager.getPlanet(planetName).getMostUsedSaberColor(jediRank);
    }

    /**
     * Gets the most used saber color overall (defaulted to GRAND_MASTER rank).
     *
     * @param planetName The planet name.
     * @return Most used saber color.
     * @throws JediManagementException if retrieval fails.
     */
    @Override
    public String getMostUsedSaberColor(String planetName) throws JediManagementException {
        return planetManager.getPlanet(planetName).getMostUsedSaberColor(JediRank.GRAND_MASTER);
    }

    /**
     * Prints all Jedi and planet data for the specified planet.
     *
     * @param planetName The planet name.
     * @return String representation.
     * @throws PlanetManagementException if the planet doesn't exist.
     */
    @Override
    public String printPlanet(String planetName) throws PlanetManagementException {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        return planetManager.getPlanet(planetName).toString();
    }

    /**
     * Prints details of a specific Jedi.
     *
     * @param jediName The Jedi name.
     * @return String representation.
     * @throws JediManagementException if the Jedi doesn't exist.
     */
    @Override
    public String printJedi(String jediName) throws JediManagementException {
        return jediManager.getJedi(jediName).toString();
    }

    /**
     * Prints and sorts Jedi from two planets.
     *
     * @param firstPlanetName  First planet name.
     * @param secondPlanetName Second planet name.
     * @return Sorted Jedi comparison string.
     */
    @Override
    public String printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) {
        return planetManager.printTwoPlanets(firstPlanetName, secondPlanetName);
    }

    /**
     * Saves the current state to a file.
     *
     * @param fileName The file path.
     * @throws IOException if the file cannot be written.
     */
    @Override
    public void writeToFile(String fileName) throws IOException {
        UniverseWriter universeWriter = new UniverseWriter();
        universeWriter.writeTo(fileName);
    }

    /**
     * Clears all loaded Jedi and planet data.
     *
     * @throws IOException if an I/O error occurs (placeholder, no actual file operation here).
     */
    @Override
    public void close() throws IOException {
        jediManager.clear();
        planetManager.clear();
    }
}
