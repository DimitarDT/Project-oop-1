package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JediManager implements Serializable {
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

    public void addJedi(Jedi jedi) throws JediManagementException {
        if(jedis.containsKey(jedi.getJediName()))
            throw new JediManagementException("Jedi " + jedi.getJediName() + " already exists on this or another planet!");
        jedis.put(jedi.getJediName(), jedi);
        System.out.println("Jedi creation was successful.");
    }

    public Jedi getJedi(String jediName) throws JediManagementException {
        if(!jedis.containsKey(jediName))
            throw new JediManagementException("Jedi doesn't exist anywhere!");
        return jedis.get(jediName);
    }

    public void removeJedi(String jediName, Planet planet) throws JediManagementException {
        if(!planet.containsJedi(jediName))
        {
            throw new JediManagementException("There is no such jedi on this planet!");
        }
        jedis.remove(jediName);
        planet.removeJedi(jediName);
        System.out.println("Jedi was removed.");
    }

    public void clear(){
        jedis.clear();
    }

    public void copy(JediManager jediManager) {
        this.jedis = jediManager.jedis;
    }
}