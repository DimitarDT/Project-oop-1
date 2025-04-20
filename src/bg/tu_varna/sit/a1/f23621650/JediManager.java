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
        return jedis.get(jediName);
    }

    public void removeJedi(Jedi jedi, Planet planet) //Jedi jedi or String jediName???
    {
        if(!planet.getJediMap().containsKey(jedi.getJediName()))
        {
            throw new JediManagementException("There is no such jedi on this planet!");
        }
        jedis.remove(jedi.getJediName());
        planet.getJediMap().remove(jedi.getJediName());
        System.out.println("Jedi was removed.");
    }
}