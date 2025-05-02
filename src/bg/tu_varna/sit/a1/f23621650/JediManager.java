package bg.tu_varna.sit.a1.f23621650;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class JediManager {
    //Singleton implementation
    private static JediManager jediManager;
    private JediManager(){
        jedis = new HashMap<>();
    }
    public static JediManager getInstance(){
        if(jediManager == null){
            jediManager = new JediManager();
        }
        return jediManager;
    }

    private Map<String, Jedi> jedis;

    public void addJedi(Jedi jedi) {
        if(jedis.containsKey(jedi.getJediName()))
            throw new JediManagementException("Jedi " + jedi.getJediName() + " already exists on this or another planet!");

        jedis.put(jedi.getJediName(), jedi);
        System.out.println("Jedi creation was successful.");
    }

    public Jedi getJedi(String jediName) {
        if(!jedis.containsKey(jediName))
            throw new JediManagementException("Jedi doesn't exist anywhere!");
        return jedis.get(jediName);
    }

    public void removeJedi(String jediName, Planet planet) {
        if(!planet.containsJedi(jediName))
        {
            throw new JediManagementException("There is no such jedi on this planet!");
        }
        jedis.remove(jediName);
        planet.removeJedi(jediName);
        System.out.println("Jedi was removed.");
    }

    public void promoteJedi(String jediName, double multiplier) {
        Jedi jedi = jedis.get(jediName);
        if(jedi.getJediRank().ordinal() < JediRank.values().length) {
            jedi.setJediRank(JediRank.values()[jedi.getJediRank().ordinal() + 1]);
            jedi.setStrength(multiplier * jedi.getStrength() + jedi.getStrength());
        } else {
            throw new JediManagementException("Jedi is the highest rank!");
        }
    }

    public void demoteJedi(String jediName, double multiplier) {
        Jedi jedi = jedis.get(jediName);
        if(jedi.getJediRank().ordinal() > 0) {
            jedi.setJediRank(JediRank.values()[jedi.getJediRank().ordinal() - 1]);
            jedi.setStrength(jedi.getStrength() - (multiplier * jedi.getStrength()));
        } else {
            throw new JediManagementException("Jedi is the lowest rank!");
        }
    }

    public Jedi getStrongestJedi(Planet planet){
        if(planet.isEmpty()) {
            throw new JediManagementException("There are no jedis on this planet!");
        }
        Jedi strongestJedi = null;
        for(Jedi jedi : planet.getJedis()) {
            if(strongestJedi == null || jedi.getStrength() > strongestJedi.getStrength()) {
                strongestJedi = jedi;
            }
        }
        return strongestJedi;
    }

    public Jedi getYoungestJedi(Planet planet, JediRank jediRank) {
        if(planet.isEmpty()) {
            throw new JediManagementException("There are no jedis on this planet!");
        }
        return planet.getJedis().stream().filter(j -> j.getJediRank() == jediRank).min(Comparator.comparingInt(Jedi::getAge).thenComparing(Jedi::getJediName)).orElse(null);
    }
}