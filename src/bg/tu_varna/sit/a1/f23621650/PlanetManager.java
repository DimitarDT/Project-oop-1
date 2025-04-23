package bg.tu_varna.sit.a1.f23621650;

import java.util.HashMap;
import java.util.Map;

public class PlanetManager {
    private Map<String, Planet> planets;

    public PlanetManager() {
        this.planets = new HashMap<>();
    }

    public void addPlanet(String planetName) {
        if(planets.containsKey(planetName))
        {
            throw new PlanetManagementException(planetName + " already exists!");
        }
        planets.put(planetName, new Planet(planetName));
    }

    public Planet getPlanet(String planetName) {
        return planets.get(planetName);
    }
}
