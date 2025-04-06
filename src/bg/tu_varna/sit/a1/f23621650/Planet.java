package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private String name;
    private List<Jedi> jediList = new ArrayList<>();

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
        for(Jedi jedi1: jediList)
        {
            if(jedi.getJediName().equals(jedi1.getJediName()))
            {
                return false;
            }
        }
        jediList.add(jedi);
        return true;
    }

    public boolean removeJedi(String name)
    {
        for(Jedi jedi: jediList)
        {
            if(jedi.getJediName().equals(name))
            {
                return jediList.remove(jedi);
            }
        }
        return false;
    }
}
