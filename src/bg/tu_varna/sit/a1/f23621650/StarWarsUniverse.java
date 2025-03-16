package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.List;

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

    List<Planet> planets = new ArrayList<Planet>(); // is it okay for this to be placed here?

    public void addPlanet(String planetName)
    {
        planets.add(new Planet(planetName));
    }//Message for already existing planets and jedi (contains and equals?)

    public void addJediToPlanet(String planetName, String jediName, JediRank jediRank, int age, String lightsaberColor, double strength)
    {
        for(Planet planet: planets)
        {
            if(planet.getName() == planetName)
            {
                planet.addJedi(new Jedi(jediName, jediRank, age, lightsaberColor,strength));//a lot of arguments are being repeated here
                break;
            } //add message for when there is no such planet or if there is already such a jedi
        }
    }// when is the jedi gonna be initialised from the command line arguments?

    public void removeJediFromPlanet(String jediName, String planetName)
    {
        for(Planet planet: planets)
        {
            if(planet.getName() == planetName)
            {
                planet.removeJedi(jediName);
                break;
            }
        }
    }//add message for no such jedi/planet exists
}
