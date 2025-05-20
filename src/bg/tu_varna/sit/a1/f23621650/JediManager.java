package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class responsible for managing all Jedi across planets.
 * Provides methods to add, retrieve, and remove Jedi, ensuring uniqueness
 * of Jedi names throughout the system.
 */
public class JediManager implements Serializable {
    //Singleton implementation
    private static JediManager jediManager;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the internal Jedi storage.
     */
    private JediManager(){
        jedis = new HashMap<>();
    }

    /**
     * Returns the singleton instance of {@code JediManager}.
     * Creates it if it does not yet exist.
     *
     * @return the single instance of {@code JediManager}
     */
    public static JediManager getInstance(){
        if(jediManager == null){
            jediManager = new JediManager();
        }
        return jediManager;
    }

    private Map<String, Jedi> jedis;

    /**
     * Adds a Jedi to the system if a Jedi with the same name does not already exist.
     *
     * @param jedi the {@code Jedi} to add
     * @throws JediManagementException if a Jedi with the same name already exists
     */
    public void addJedi(Jedi jedi) throws JediManagementException {
        if(jedis.containsKey(jedi.getJediName()))
            throw new JediManagementException("Jedi " + jedi.getJediName() + " already exists on this or another planet!");
        jedis.put(jedi.getJediName(), jedi);
        System.out.println("Jedi creation was successful.");
    }

    /**
     * Retrieves a Jedi by name from the system.
     *
     * @param jediName the name of the Jedi to retrieve
     * @return the {@code Jedi} with the specified name
     * @throws JediManagementException if no Jedi with the given name exists
     */
    public Jedi getJedi(String jediName) throws JediManagementException {
        if(!jedis.containsKey(jediName))
            throw new JediManagementException("Jedi doesn't exist anywhere!");
        return jedis.get(jediName);
    }

    /**
     * Removes a Jedi from the system and the specified planet.
     *
     * @param jediName the name of the Jedi to remove
     * @param planet   the {@code Planet} from which to remove the Jedi
     * @throws JediManagementException if the Jedi does not reside on the given planet
     */
    public void removeJedi(String jediName, Planet planet) throws JediManagementException {
        if(!planet.containsJedi(jediName))
        {
            throw new JediManagementException("There is no such jedi on this planet!");
        }
        jedis.remove(jediName);
        planet.removeJedi(jediName);
        System.out.println("Jedi was removed.");
    }

    /**
     * Clears all Jedi from the system.
     */
    public void clear(){
        jedis.clear();
    }

    /**
     * Copies the internal Jedi map from another {@code JediManager}.
     *
     * @param jediManager the {@code JediManager} whose Jedi map to copy
     */
    public void copy(JediManager jediManager) {
        this.jedis = jediManager.jedis;
    }
}