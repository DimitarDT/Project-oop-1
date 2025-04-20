package bg.tu_varna.sit.a1.f23621650;

import java.util.HashMap;
import java.util.Map;

public class StarWarsUniverse {
    //Singleton implementation
    private static StarWarsUniverse starWarsUniverse;
    private StarWarsUniverse(){
        jediManager = new JediManager();
    }
    public static StarWarsUniverse getInstance()
    {
        if(starWarsUniverse == null)
        {
            starWarsUniverse = new StarWarsUniverse();
        }
        return starWarsUniverse;
    }

    Map<String, Planet> planets = new HashMap<>(); // is it okay for this to be placed here?
    private JediManager jediManager;//static?

    public void addPlanet(String planetName)
    {
        if(planets.containsKey(planetName))
        {
            throw new PlanetManagementException(planetName + " already exists!");
        }
        planets.put(planetName, new Planet(planetName));
    }

    public void addJediToPlanet(String planetName, Jedi jedi)
    {
        if(!(planets.containsKey(planetName)))
        {
            throw new PlanetManagementException("Jedi creation wasn't successful. There is no such planet.");
        }
        jediManager.addJedi(jedi, planets.get(planetName));
    }// when is the jedi going to be initialised from the command line arguments?

    public void removeJediFromPlanet(String jediName, String planetName)
    {
        if(!(planets.containsKey(planetName)))
        {
            throw new PlanetManagementException("Jedi removal wasn't successful. There is no such planet.");
        }
        jediManager.removeJedi(jediManager.getJedi(jediName), planets.get(planetName));

    }//add message for no such jedi/planet exists
}
