package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.*;
import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.EmptyFileException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;

import java.io.IOException;

/**
 * Abstract base class for different states of the application in the
 * Star Wars universe management system. Implements default behavior
 * for all operations by throwing an IOException indicating that no
 * file has been opened, enforcing state-specific behavior in subclasses.
 * <p>
 * Concrete states such as {@code UnopenedState}, {@code SavedState},
 * and {@code UnsavedState} extend this class and override methods
 * to provide appropriate functionality depending on the current state.
 * </p>
 */
public abstract class AbstractState implements State {
    /** Singleton instance of {@link JediManager} shared across states */
    JediManager jediManager;

    /** Singleton instance of {@link PlanetManager} shared across states */
    PlanetManager planetManager;

    /**
     * Constructs an AbstractState initializing references to the
     * singleton JediManager and PlanetManager.
     */
    public AbstractState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet to add
     * @throws PlanetManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void addPlanetToUniverse(String planetName) throws PlanetManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet where the Jedi is created
     * @param jediName the name of the Jedi
     * @param jediRank the rank of the Jedi
     * @param jediAge the age of the Jedi
     * @param saberColor the lightsaber color of the Jedi
     * @param jediStrength the strength of the Jedi
     * @throws PlanetManagementException not thrown in this default implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param jediName the name of the Jedi to remove
     * @param planetName the name of the planet from which to remove the Jedi
     * @throws PlanetManagementException not thrown in this default implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param jediName the name of the Jedi to promote
     * @param multiplier the promotion strength multiplier
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void promote(String jediName, double multiplier) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param jediName the name of the Jedi to demote
     * @param multiplier the demotion strength multiplier
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void demote(String jediName, double multiplier) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet whose strongest Jedi to return
     * @return never returns normally in this implementation
     * @throws PlanetManagementException not thrown in this default implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public Jedi getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet whose youngest Jedi to return
     * @param jediRank the rank filter for Jedi selection
     * @return never returns normally in this implementation
     * @throws PlanetManagementException not thrown in this default implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public Jedi getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet
     * @param jediRank the Jedi rank to filter the saber colors
     * @return never returns normally in this implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public String getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet
     * @return never returns normally in this implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public String getMostUsedSaberColor(String planetName) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param planetName the name of the planet to print information for
     * @return never returns normally in this implementation
     * @throws PlanetManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public String printPlanet(String planetName) throws PlanetManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param jediName the name of the Jedi to print information for
     * @return never returns normally in this implementation
     * @throws JediManagementException not thrown in this default implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public String printJedi(String jediName) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param firstPlanetName the first planet to list Jedis from
     * @param secondPlanetName the second planet to list Jedis from
     * @return never returns normally in this implementation
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public String printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) throws IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @param fileName the file to write the current universe data to
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void writeToFile(String fileName) throws IOException {
        throw new IOException("No file has been opened yet.");
    }

    /**
     * Throws IOException by default to prevent opening a new file before closing
     * the current one in this state.
     *
     * @param fileName the file to read universe data from
     * @throws IOException always thrown to indicate operation is unavailable
     * @throws EmptyFileException not thrown in this default implementation
     * @throws ClassNotFoundException not thrown in this default implementation
     */
    @Override
    public void readFromFile(String fileName) throws IOException, EmptyFileException, ClassNotFoundException {
        throw new IOException("You must close the current file to open another one!");
    }

    /**
     * Throws IOException by default because no file has been opened in this state.
     *
     * @throws IOException always thrown to indicate operation is unavailable
     */
    @Override
    public void close() throws IOException {
        throw new IOException("No file has been opened yet.");
    }
}
