package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarWarsUniverse {
    //Singleton implementation
    private static StarWarsUniverse starWarsUniverse;
    private StarWarsUniverse(){}
    public StarWarsUniverse getInstance()
    {
        if(starWarsUniverse == null)
        {
            starWarsUniverse = new StarWarsUniverse();
        }
        return starWarsUniverse;
    }

    Map<String, Planet> planets = new HashMap<String, Planet>(); // is it okay for this to be placed here?

    public void addPlanet(String planetName)
    {
        if(planets.containsKey(planetName))
        {
            System.out.println("This planet already exists!");
        }
        else
        {
            planets.put(planetName, new Planet(planetName));
        }
    }

    public void addJediToPlanet(String planetName, String jediName, JediRank jediRank, int age, String lightsaberColor, double strength)
    {
        if(!(planets.containsKey(planetName)))
        {
            System.out.println("Jedi creation wasn't successful. There is no such planet.");
            return;
        }

        if(planets.get(planetName).addJedi(new Jedi(jediName, jediRank, age, lightsaberColor, strength))) //a lot of arguments are being repeated here
        {
            System.out.println("Jedi creation was successful.");
        }
        else
        {
            System.out.println("Jedi creation wasn't successful. There is already a jedi with this name on this or another planet.");
        }
    }// when is the jedi gonna be initialised from the command line arguments?

    public void removeJediFromPlanet(String jediName, String planetName)
    {
        if(!(planets.containsKey(planetName)))
        {
            System.out.println("Jedi removal wasn't successful. There is no such planet.");
            return;
        }

        if(planets.get(planetName).removeJedi(jediName))
        {
            System.out.println("Jedi was removed.");
        }
        else
        {
            System.out.println("There is no such jedi on this planet!");

        }
        /*for(Planet planet: planets)
        {
            if(planet.getName() == planetName)
            {
                planet.removeJedi(jediName);
                break;
            }
        }*/
    }//add message for no such jedi/planet exists
}
