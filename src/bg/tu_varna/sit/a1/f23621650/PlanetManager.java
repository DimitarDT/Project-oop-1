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

    public boolean containsPlanet(String planetName) {
        return planets.containsKey(planetName);
    }

    public String getMostUsedSaberColor(String planetName, JediRank jediRank){
        Map<String, Integer> saberPairs = new HashMap<>();
        for(Jedi jedi : getPlanet(planetName).getJediMap().values()) {//encapsulation breaks here i think
            if(jedi.getJediRank().equals(jediRank)) {
                String color = jedi.getLightsaberColor().toLowerCase();
                saberPairs.put(color, saberPairs.getOrDefault(color, 0) + 1);
            }
        }
        if(saberPairs.isEmpty()){
            throw new JediManagementException("There are no jedis with this rank on this planet!");
        }

        String mostUsedColor = null;
        int maxCount = 0;
        for(Map.Entry<String, Integer> entry: saberPairs.entrySet()){
            String color = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                mostUsedColor = color;
            }
        }
        return mostUsedColor;
    }
}
