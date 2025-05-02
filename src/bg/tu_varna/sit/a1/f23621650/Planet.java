package bg.tu_varna.sit.a1.f23621650;

import java.util.*;

public class Planet { // целият клас е под въпрос, има ли смисъл от него?
    private String name;// do we need the name in here?
    private HashMap<String, Jedi> jediMap = new HashMap<>();//do we need the jedis here

    public String getName() {
        return name;
    }

    public HashMap<String, Jedi> getJediMap() {
        return jediMap;
    }

    public Planet(String name) {
        this.name = name;
    }

    //public void addToPlanet(Jedi jedi) for encapsulation
    //printPlanet here
    public List<Jedi> getJedis(Planet planet) {
        List<Jedi> allJedis = new ArrayList<>(this.jediMap.values());
        allJedis.addAll(planet.jediMap.values());
        return allJedis;
    }

    @Override
    public String toString() {
        List<Jedi> jediList = new ArrayList<>(jediMap.values());
        jediList.sort(Comparator.comparing(Jedi::getJediRank).thenComparing(Jedi::getJediName));
        final StringBuilder sb = new StringBuilder("Planet{");
        sb.append("name='").append(name).append('\'');
        sb.append(", jedis=").append(jediList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet planet)) return false;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
