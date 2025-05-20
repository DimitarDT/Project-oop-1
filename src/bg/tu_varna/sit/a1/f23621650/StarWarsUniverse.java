package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Exceptions.EmptyFileException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;
import bg.tu_varna.sit.a1.f23621650.States.SavedState;
import bg.tu_varna.sit.a1.f23621650.States.State;
import bg.tu_varna.sit.a1.f23621650.States.UnopenedState;
import bg.tu_varna.sit.a1.f23621650.States.UnsavedState;

import java.io.IOException;

/**
 * The {@code StarWarsUniverse} class serves as the central controller and application context for
 * managing Jedi and Planet data in a fictional Star Wars-themed universe.
 * <p>
 * It functions as:
 * <ul>
 *     <li><strong>Context in the State pattern</strong>: Delegates behavior to internal state implementations
 *     such as {@code UnopenedState}, {@code UnsavedState}, and {@code SavedState}.</li>
 *     <li><strong>Receiver in the Command pattern</strong>: Invoked by command classes to carry out operations.</li>
 * </ul>
 *
 * <p>
 * The class maintains a reference to the <strong>currently opened file</strong> using the {@code currentFile}
 * variable. This is updated whenever a file is opened or saved using {@code readFromFile} or {@code saveAs}.
 * The {@code save} method reuses this file path for saving.
 * </p>
 */
public class StarWarsUniverse {
    //Singleton implementation
    private static StarWarsUniverse starWarsUniverse;
    private StarWarsUniverse(){
        state = new UnopenedState();
    }

    /**
     * Returns the singleton instance of StarWarsUniverse.
     */
    public static StarWarsUniverse getInstance() {
        if(starWarsUniverse == null) {
            starWarsUniverse = new StarWarsUniverse();
        }
        return starWarsUniverse;
    }

    private State state;
    private String currentFile;

    /**
     * Adds a new planet to the universe.
     * Transitions the state to {@code UnsavedState} upon success.
     *
     * @param planetName the name of the planet
     * @throws PlanetManagementException if the operation fails logically
     */
    public void addPlanetToUniverse(String planetName) throws PlanetManagementException {
        try {
            state.addPlanetToUniverse(planetName.toLowerCase());
            setState(new UnsavedState());
            System.out.println("Planet " + planetName + " added to universe.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a new Jedi and associates them with a planet.
     *
     * @param planetName   the name of the planet
     * @param jediName     the name of the Jedi
     * @param jediRank     the rank of the Jedi
     * @param jediAge      the age of the Jedi
     * @param saberColor   the color of the lightsaber
     * @param jediStrength the strength value of the Jedi
     * @throws PlanetManagementException if the specified planet is invalid
     * @throws JediManagementException   if Jedi creation fails
     */
    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException {
        try {
            state.createJedi(planetName.toLowerCase(), jediName.toLowerCase(), jediRank, jediAge, saberColor, jediStrength);
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " added to universe.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes a Jedi from a specified planet.
     *
     * @param jediName   the name of the Jedi
     * @param planetName the name of the planet
     * @throws PlanetManagementException if the planet is not found
     * @throws JediManagementException   if the Jedi is not found
     */
    public void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException {
        try {
            state.removeJediFromPlanet(jediName.toLowerCase(), planetName.toLowerCase());
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " removed from universe.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Promotes a Jedi by applying a strength multiplier.
     *
     * @param jediName   the name of the Jedi
     * @param multiplier the strength multiplier
     * @throws JediManagementException if the Jedi cannot be promoted
     */
    public void promote(String jediName, double multiplier) throws JediManagementException {
        try {
            state.promote(jediName.toLowerCase(), multiplier);
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " promoted.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Demotes a Jedi by applying a negative strength multiplier.
     *
     * @param jediName   the name of the Jedi
     * @param multiplier the strength multiplier
     * @throws JediManagementException if the Jedi cannot be demoted
     */
    public void demote(String jediName, double multiplier) throws JediManagementException {
        try {
            state.demote(jediName.toLowerCase(), multiplier);
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " was demoted.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieves and prints the strongest Jedi from a planet.
     *
     * @param planetName the name of the planet
     * @throws PlanetManagementException if the planet is not found
     * @throws JediManagementException   if no Jedi are found
     */
    public void getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException {
        try {
            System.out.println(state.getStrongestJedi(planetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieves and prints the youngest Jedi with a specific rank from a planet.
     *
     * @param planetName the name of the planet
     * @param jediRank   the rank to filter by
     * @throws PlanetManagementException if the planet is not found
     * @throws JediManagementException   if no Jedi match the criteria
     */
    public void getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException {
        try {
            System.out.println(state.getYoungestJedi(planetName.toLowerCase(), jediRank));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieves the most used saber color among Jedi of a specific rank on a planet.
     *
     * @param planetName the name of the planet
     * @param jediRank   the rank of Jedi to consider
     * @throws JediManagementException if no Jedi match the criteria
     */
    public void getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException {
        try {
            System.out.println("Most used saber color is: " + state.getMostUsedSaberColor(planetName.toLowerCase(), jediRank));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieves the most used saber color among Grand Masters on a planet.
     *
     * @param planetName the name of the planet
     * @throws JediManagementException if the operation fails
     */
    public void getMostUsedSaberColor(String planetName) throws JediManagementException {
        try {
            System.out.println("Most used saber color of grandmasters on " + planetName + " is: " + state.getMostUsedSaberColor(planetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints details about a specific planet.
     *
     * @param planetName the name of the planet
     * @throws PlanetManagementException if the planet is not found
     */
    public void printPlanet(String planetName) throws PlanetManagementException {
        try {
            System.out.println(state.printPlanet(planetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints details about a specific Jedi.
     *
     * @param jediName the name of the Jedi
     * @throws JediManagementException if the Jedi is not found
     */
    public void printJedi(String jediName) throws JediManagementException {
        try {
            System.out.println(state.printJedi(jediName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints Jedi from two different planets.
     *
     * @param firstPlanetName  the name of the first planet
     * @param secondPlanetName the name of the second planet
     */
    public void printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) {
        try {
            System.out.println(state.printTwoPlanetsJedis(firstPlanetName.toLowerCase(), secondPlanetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves the current data to the specified file.
     * <p>
     * If the file name does not end with ".txt", the extension is appended automatically.
     * On successful save, the {@code currentFile} variable is updated to this file,
     * and the internal state transitions to {@code SavedState}.
     * </p>
     *
     * @param fileName the file name to save to
     */
    public void saveAs(String fileName) {
        try {
            if(!fileName.endsWith(".txt"))
                fileName+=".txt";
            state.writeToFile(fileName);
            setState(new SavedState());
            currentFile = fileName;
            System.out.println("File saved.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves data to the currently opened file tracked by {@code currentFile}.
     * <p>
     * This method delegates to {@code saveAs(currentFile)}.
     * If no file has been opened previously, this may result in an error.
     * </p>
     */
    public void save() {
        saveAs(currentFile);
    }

    /**
     * Reads universe data from a file.
     * <p>
     * If the file does not end with ".txt", the extension is appended automatically.
     * On successful read, the {@code currentFile} variable is updated to track this file,
     * and the internal state is set to {@code SavedState}.
     * </p>
     *
     * @param fileName the file name to read from
     */
    public void readFromFile(String fileName) {
        try {
            if(!fileName.endsWith(".txt"))
                fileName+=".txt";
            state.readFromFile(fileName);
            setState(new SavedState());
            currentFile = fileName;
            System.out.println("File opened.");
        } catch (EmptyFileException e) {
            setState(new SavedState());
            currentFile = fileName;
            System.out.println("File opened.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Closes the currently opened file and resets the application state.
     */
    public void close(){
        try {
            state.close();
            setState(new UnopenedState());
            currentFile = null;
            System.out.println("File closed.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets the current application state.
     *
     * @param state the new state to switch to
     */
    private void setState(State state) {
        this.state = state;
    }
}