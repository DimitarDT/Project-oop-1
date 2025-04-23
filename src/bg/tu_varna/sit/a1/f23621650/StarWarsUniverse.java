package bg.tu_varna.sit.a1.f23621650;

import java.util.HashMap;
import java.util.Map;

public class StarWarsUniverse {
    //Singleton implementation
    private static StarWarsUniverse starWarsUniverse;
    private StarWarsUniverse(){
        jediManager = new JediManager();
        planetManager = new PlanetManager();
    }
    public static StarWarsUniverse getInstance() {
        if(starWarsUniverse == null) {
            starWarsUniverse = new StarWarsUniverse();
        }
        return starWarsUniverse;
    }

    private Map<String, Planet> planets = new HashMap<>(); // is it okay for this to be placed here?
    private JediManager jediManager;//static?
    private PlanetManager planetManager;

    public void addPlanetToUniverse(String planetName) {
        planetManager.addPlanet(planetName);
    }

    public void addJediToPlanet(String planetName, Jedi jedi) {
        if(!(planets.containsKey(planetName)))
        {
            throw new PlanetManagementException("Jedi creation wasn't successful. There is no such planet.");
        }
        jediManager.addJedi(jedi, planets.get(planetName));
    }

    public void removeJediFromPlanet(String jediName, String planetName) {
        if(!(planets.containsKey(planetName)))
        {
            throw new PlanetManagementException("Jedi removal wasn't successful. There is no such planet.");
        }
        jediManager.removeJedi(jediName, planets.get(planetName));
    }

    public void promote(String jediName, double multiplier) { //multiplier must be positive number dobavi!
        jediManager.promoteJedi(jediName, multiplier);
    }

    public void demote(String jediName, double multiplier) {
        jediManager.demoteJedi(jediName, multiplier);
    }

}
