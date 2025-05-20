package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;

import java.io.Serializable;
import java.util.*;

/**
 * Singleton class responsible for managing planets within the Star Wars system.
 * Allows adding, retrieving, and checking planets by name,
 * and provides utilities to work with Jedis residing on planets.
 */
public class PlanetManager implements Serializable {
    //Singleton implementation
    private static PlanetManager planetManager;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the internal planet storage.
     */
    private PlanetManager(){
        planets = new HashMap<>();
    }

    /**
     * Returns the singleton instance of {@code PlanetManager}.
     * Creates it if it does not yet exist.
     *
     * @return the single instance of {@code PlanetManager}
     */
    public static PlanetManager getInstance(){
        if(planetManager == null) {
            planetManager = new PlanetManager();
        }
        return planetManager;
    }

    private Map<String, Planet> planets;

    /**
     * Adds a new planet with the specified name to the system.
     *
     * @param planetName the name of the planet to add
     * @throws PlanetManagementException if a planet with the same name already exists
     */
    public void addPlanet(String planetName) throws PlanetManagementException {
        if(planets.containsKey(planetName))
        {
            throw new PlanetManagementException(planetName + " already exists!");
        }
        planets.put(planetName, new Planet(planetName));
    }

    /**
     * Retrieves the planet with the specified name.
     *
     * @param planetName the name of the planet to retrieve
     * @return the {@code Planet} object or {@code null} if no planet exists with that name
     */
    public Planet getPlanet(String planetName) {
        return planets.get(planetName);
    }

    /**
     * Checks if a planet with the specified name exists in the system.
     *
     * @param planetName the name of the planet to check
     * @return {@code true} if the planet exists, {@code false} otherwise
     */
    public boolean containsPlanet(String planetName) {
        return planets.containsKey(planetName);
    }

    /**
     * Returns a formatted string listing all Jedis residing on two specified planets,
     * sorted alphabetically by Jedi name.
     *
     * @param firstPlanetName  the name of the first planet
     * @param secondPlanetName the name of the second planet
     * @return a formatted string listing Jedis on both planets
     */
    public String printTwoPlanets(String firstPlanetName, String secondPlanetName) {
        Planet firstPlanet = getPlanet(firstPlanetName);
        Planet secondPlanet = getPlanet(secondPlanetName);
        List<Jedi> allJedis = firstPlanet.getJedis();
        allJedis.addAll(secondPlanet.getJedis());
        allJedis.sort(Comparator.comparing(Jedi::getJediName));
        final StringBuilder sb = new StringBuilder("Jedis on planets ").append(CapitalizeWords.capitalize(firstPlanetName)).append(" and ").append(CapitalizeWords.capitalize(secondPlanetName)).append(":\n");
        for(Jedi jedi : allJedis) {
            sb.append(jedi.toString());
        }
        return sb.toString();
    }

    /**
     * Clears all planets from the system.
     */
    public void clear(){
        planets.clear();
    }

    /**
     * Copies the internal planet map from another {@code PlanetManager}.
     *
     * @param planetManager the {@code PlanetManager} whose planet map to copy
     */
    public void copy(PlanetManager planetManager) {
        this.planets = planetManager.planets;
    }
}