package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Enums.LightsaberColor;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a planet in the Star Wars universe where Jedi reside.
 * Each planet maintains a collection of Jedi currently residing on it,
 * allowing operations such as adding or removing Jedi, and querying details
 * like the strongest Jedi or the most common lightsaber color among Jedi of a specific rank.
 */
public class Planet implements Serializable {
    private final String name;
    private final HashMap<String, Jedi> jediMap = new HashMap<>();

    /**
     * Returns the name of the planet.
     *
     * @return the planet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Constructs a new {@code Planet} with the specified name.
     *
     * @param name the name of the planet
     */
    public Planet(String name) {
        this.name = name;
    }

    /**
     * Adds a Jedi to this planet's collection.
     *
     * @param jediName the name of the Jedi to add
     * @param jedi     the {@code Jedi} instance to add
     */
    public void addToPlanet(String jediName, Jedi jedi) {
        jediMap.put(jediName, jedi);
    }

    /**
     * Removes the Jedi with the specified name from this planet.
     *
     * @param jediName the name of the Jedi to remove
     */
    public void removeJedi(String jediName) {
        jediMap.remove(jediName);
    }

    /**
     * Checks if a Jedi with the given name resides on this planet.
     *
     * @param jediName the name of the Jedi to check
     * @return {@code true} if the Jedi is present; {@code false} otherwise
     */
    public boolean containsJedi(String jediName){
        return jediMap.containsKey(jediName);
    }

    /**
     * Returns a list of all Jedi currently residing on this planet.
     *
     * @return a list of Jedi on the planet
     */
    public List<Jedi> getJedis() {
        return new ArrayList<>(this.jediMap.values());
    }

    /**
     * Finds and returns the Jedi with the highest strength on this planet.
     *
     * @return the strongest Jedi on the planet
     * @throws JediManagementException if there are no Jedi on this planet
     */
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

    /**
     * Returns the youngest Jedi of the specified rank residing on this planet.
     * If multiple Jedi share the youngest age, the one with the lexicographically smallest name is returned.
     *
     * @param jediRank the rank of Jedi to filter by
     * @return the youngest Jedi with the specified rank, or {@code null} if none found
     * @throws JediManagementException if there are no Jedi on this planet
     */
    public Jedi getYoungestJedi(JediRank jediRank) throws JediManagementException {
        if(jediMap.isEmpty()) {
            throw new JediManagementException("There are no jedis on this planet!");
        }
        return jediMap.values().stream().filter(j -> j.getJediRank() == jediRank).min(Comparator.comparingInt(Jedi::getAge).thenComparing(Jedi::getJediName)).orElse(null);
    }

    /**
     * Determines the most commonly used lightsaber color among Jedi of a specified rank on this planet.
     *
     * @param jediRank the rank of Jedi to consider
     * @return the string representation of the most used lightsaber color
     * @throws JediManagementException if there are no Jedi with the specified rank on this planet
     */
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

    /**
     * Returns a string representation of the planet and the Jedi residing on it,
     * sorted by their rank and name.
     *
     * @return a formatted string describing the planet and its Jedi
     */
    @Override
    public String toString() {
        List<Jedi> jediList = new ArrayList<>(jediMap.values());
        jediList.sort(Comparator.comparing(Jedi::getJediRank).thenComparing(Jedi::getJediName));
        final StringBuilder sb = new StringBuilder("Planet");
        sb.append(" '").append(CapitalizeWords.capitalize(name)).append("' ");
        sb.append("has the following jedis residing on it: \n").append(jediList);
        return sb.toString();
    }

    /**
     * Checks equality based on the planet's name.
     *
     * @param o the object to compare
     * @return {@code true} if the planets have the same name; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Planet planet)) return false;
        return Objects.equals(name, planet.name);
    }

    /**
     * Returns the hash code for this planet based on its name.
     *
     * @return the hash code of the planet
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
