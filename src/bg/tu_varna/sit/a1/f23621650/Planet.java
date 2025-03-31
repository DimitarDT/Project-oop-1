package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Planet {
    private String name;
    private Set<Jedi> jediSet = new HashSet<Jedi>();

    public String getName() {
        return name;
    }

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; //getclass or getinstance?
        Planet planet = (Planet) o;
        return name.equals(planet.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode(); //Objects version 1.7??
    }

    public boolean addJedi(Jedi jedi)
    {
        return jediSet.add(jedi);
    }

    public boolean removeJedi(String name)
    {
        for(Jedi jedi: jediSet)
        {
            if(jedi.getJediName().equals(name))
            {
                return jediSet.remove(jedi);
            }
        }
        return false;
    }
}
