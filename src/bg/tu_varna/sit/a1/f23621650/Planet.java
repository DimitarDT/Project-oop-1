package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (!(o instanceof Planet planet)) return false;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
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
