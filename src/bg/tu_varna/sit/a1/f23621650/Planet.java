package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;

import java.io.Serializable;
import java.util.*;

public class Planet implements Serializable {
    private final String name;
    private final HashMap<String, Jedi> jediMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public Planet(String name) {
        this.name = name;
    }

    public void addToPlanet(String jediName, Jedi jedi) {
        jediMap.put(jediName, jedi);
    }

    public void removeJedi(String jediName) {
        jediMap.remove(jediName);
    }

    public boolean containsJedi(String jediName){
        return jediMap.containsKey(jediName);
    }

    public List<Jedi> getJedis() {
        return new ArrayList<>(this.jediMap.values());
    }

    public Jedi getStrongestJedi() throws JediManagementException {
        if(jediMap.isEmpty()) {
            throw new JediManagementException("There are no jedis on this planet!");
        }
        Jedi strongestJedi = null;
        for(Jedi jedi : jediMap.values()) {
            if(strongestJedi == null || jedi.getStrength() > strongestJedi.getStrength()) {
                strongestJedi = jedi;
            }
        }
        return strongestJedi;
    }

    public Jedi getYoungestJedi(JediRank jediRank) throws JediManagementException {
        if(jediMap.isEmpty()) {
            throw new JediManagementException("There are no jedis on this planet!");
        }
        return jediMap.values().stream().filter(j -> j.getJediRank() == jediRank).min(Comparator.comparingInt(Jedi::getAge).thenComparing(Jedi::getJediName)).orElse(null);
    }

    public String getMostUsedSaberColor(JediRank jediRank) throws JediManagementException {
        Map<LightsaberColor, Integer> saberPairs = new HashMap<>();
        for(Jedi jedi : jediMap.values()) {
            if(jedi.getJediRank().equals(jediRank)) {
                LightsaberColor color = jedi.getLightsaberColor();
                saberPairs.put(color, saberPairs.getOrDefault(color, 0) + 1);
            }
        }
        if(saberPairs.isEmpty()){
            throw new JediManagementException("There are no jedis with this rank on this planet!");
        }

        LightsaberColor mostUsedColor = null;
        int maxCount = 0;
        for(Map.Entry<LightsaberColor, Integer> entry: saberPairs.entrySet()){
            LightsaberColor color = entry.getKey();
            int count = entry.getValue();

            if (mostUsedColor == null || count > maxCount) {
                maxCount = count;
                mostUsedColor = color;
            }
        }
        return mostUsedColor.toString();
    }

    @Override
    public String toString() {
        List<Jedi> jediList = new ArrayList<>(jediMap.values());
        jediList.sort(Comparator.comparing(Jedi::getJediRank).thenComparing(Jedi::getJediName));
        final StringBuilder sb = new StringBuilder("Planet");
        sb.append(" '").append(CapitalizeWords.capitalize(name)).append("' ");
        sb.append("has the following jedis residing on it: \n").append(jediList);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Planet planet)) return false;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
