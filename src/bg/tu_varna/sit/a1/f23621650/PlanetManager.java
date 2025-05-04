package bg.tu_varna.sit.a1.f23621650;

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

    public boolean containsPlanet(String planetName) {
        return planets.containsKey(planetName);
    }

    public String getMostUsedSaberColor(String planetName, JediRank jediRank){
        Map<Jedi.LightsaberColor, Integer> saberPairs = new HashMap<>();
        for(Jedi jedi : getPlanet(planetName).getJedis()) {
            if(jedi.getJediRank().equals(jediRank)) {
                Jedi.LightsaberColor color = jedi.getLightsaberColor();
                saberPairs.put(color, saberPairs.getOrDefault(color, 0) + 1);
            }
        }
        if(saberPairs.isEmpty()){
            throw new JediManagementException("There are no jedis with this rank on this planet!");
        }

        Jedi.LightsaberColor mostUsedColor = null;
        int maxCount = 0;
        for(Map.Entry<Jedi.LightsaberColor, Integer> entry: saberPairs.entrySet()){
            Jedi.LightsaberColor color = entry.getKey();
            int count = entry.getValue();

            if (mostUsedColor == null || count > maxCount) {
                maxCount = count;
                mostUsedColor = color;
            }
        }
        return mostUsedColor.toString();
    }

    public String printTwoPlanets(String firstPlanetName, String secondPlanetName) {
        Planet firstPlanet = getPlanet(firstPlanetName);
        Planet secondPlanet = getPlanet(secondPlanetName);
        List<Jedi> allJedis = firstPlanet.getJedis(secondPlanet);
        allJedis.sort(Comparator.comparing(Jedi::getJediName));
        final StringBuilder sb = new StringBuilder("Jedis on planets ").append(firstPlanetName).append(" and ").append(secondPlanetName).append(":\n");
        for(Jedi jedi : allJedis) {
            sb.append(jedi.toString());
        }
        return sb.toString();
    }
}
