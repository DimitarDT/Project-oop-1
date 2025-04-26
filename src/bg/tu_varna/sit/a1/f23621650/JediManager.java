package bg.tu_varna.sit.a1.f23621650;

import java.util.HashMap;
import java.util.Map;

public class JediManager {
    private Map<String, Jedi> jedis;
    public JediManager() {
        jedis = new HashMap<>();
    }

    public void addJedi(Jedi jedi) {
        if(jedis.containsKey(jedi.getJediName()))
            throw new JediManagementException("Jedi " + jedi.getJediName() + " already exists on this or another planet!");

        jedis.put(jedi.getJediName(), jedi);
        jedi.getPlanet().getJediMap().put(jedi.getJediName(), jedi);//???
        System.out.println("Jedi creation was successful.");
    }

    public Jedi getJedi(String jediName) {
        if(!jedis.containsKey(jediName))
            throw new JediManagementException("Jedi doesn't exist anywhere!");
        return jedis.get(jediName);
    }

    public void removeJedi(String jediName, Planet planet) {
        if(!planet.getJediMap().containsKey(jediName))//rework jedimap//???
        {
            throw new JediManagementException("There is no such jedi on this planet!");
        }
        jedis.remove(jediName);
        planet.getJediMap().remove(jediName);
        System.out.println("Jedi was removed.");
    }

    public void promoteJedi(String jediName, double multiplier) {
        Jedi jedi = jedis.get(jediName);
        if(jedi.getJediRank().ordinal() < JediRank.values().length)
        {
            jedi.setJediRank(JediRank.values()[jedi.getJediRank().ordinal() + 1]);
            jedi.setStrength(multiplier * jedi.getStrength() + jedi.getStrength());
        } else {
            throw new JediManagementException("Jedi is the highest rank!");
        }
    }

    public void demoteJedi(String jediName, double multiplier) {
        Jedi jedi = jedis.get(jediName);
        if(jedi.getJediRank().ordinal() > 0)
        {
            jedi.setJediRank(JediRank.values()[jedi.getJediRank().ordinal() - 1]);
            jedi.setStrength(jedi.getStrength() - (multiplier * jedi.getStrength()));
        } else {
            throw new JediManagementException("Jedi is the lowest rank!");
        }
    }

    public Jedi getStrongestJedi(Planet planet){
        Jedi jediMaxStrength = null;
        for(Jedi jedi : planet.getJediMap().values())
        {
            if(jediMaxStrength == null || jedi.getStrength() > jediMaxStrength.getStrength())
            {
                jediMaxStrength = jedi;
            }
        }
        return jediMaxStrength;
    }
}