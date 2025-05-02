package bg.tu_varna.sit.a1.f23621650;

import java.util.*;

public class Planet {
    private String name;
    private HashMap<String, Jedi> jediMap = new HashMap<>();

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

    public boolean isEmpty(){
        return jediMap.isEmpty();
    }

    public Collection<Jedi> getJedis(){
        return jediMap.values();
    }

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
        if (!(o instanceof Planet planet)) return false;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
