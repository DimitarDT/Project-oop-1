package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;

import java.io.Serializable;
import java.util.*;

public class PlanetManager implements Serializable {
    //Singleton implementation
    private static PlanetManager planetManager;
    private PlanetManager(){
        planets = new HashMap<>();
    }
    public static PlanetManager getInstance(){
        if(planetManager == null) {
            planetManager = new PlanetManager();
        }
        return planetManager;
    }

    private Map<String, Planet> planets;

    public void addPlanet(String planetName) throws PlanetManagementException {
        if(planets.containsKey(planetName))
        {
            throw new PlanetManagementException(planetName + " already exists!");
        }
        planets.put(planetName, new Planet(planetName));
    }

    public Planet getPlanet(String planetName) {
        return planets.get(planetName);
    }

    public boolean containsPlanet(String planetName) {
        return planets.containsKey(planetName);
    }

    public String printTwoPlanets(String firstPlanetName, String secondPlanetName) {
        Planet firstPlanet = getPlanet(firstPlanetName);
        Planet secondPlanet = getPlanet(secondPlanetName);
        List<Jedi> allJedis = firstPlanet.getJedis(secondPlanet);
        allJedis.sort(Comparator.comparing(Jedi::getJediName));
        final StringBuilder sb = new StringBuilder("Jedis on planets ").append(CapitalizeWords.capitalize(firstPlanetName)).append(" and ").append(CapitalizeWords.capitalize(secondPlanetName)).append(":\n");
        for(Jedi jedi : allJedis) {
            sb.append(jedi.toString());
        }
        return sb.toString();
    }

    public void clear(){
        planets.clear();
    }

    public void copy(PlanetManager planetManager) {
        this.planets = planetManager.planets;
    }
}
