package bg.tu_varna.sit.a1.f23621650;

import java.util.HashMap;
import java.util.Map;

public class JediManager {
    private Map<String, Jedi> jedis;
    public JediManager() {
        jedis = new HashMap<>();
    }

    public void addJedi(Jedi jedi, Planet planet)
    {
        if(jedis.containsKey(jedi.getJediName()))
        {
            throw new JediManagementException("Jedi " + jedi.getJediName() + " already exists on this or another planet!");
        }
        jedis.put(jedi.getJediName(), jedi);
        planet.getJediMap().put(jedi.getJediName(), jedi);
        System.out.println("Jedi creation was successful.");
    }

    public Jedi getJedi(String jediName)
    {
        if(!jedis.containsKey(jediName))
            throw new JediManagementException("Jedi doesn't exist anywhere!");
        return jedis.get(jediName);
    }

    public void removeJedi(String jediName, Planet planet)
    {
        if(!planet.getJediMap().containsKey(jediName))
        {
            throw new JediManagementException("There is no such jedi on this planet!");
        }
        jedis.remove(jediName);
        planet.getJediMap().remove(jediName);
        System.out.println("Jedi was removed.");
    }
}