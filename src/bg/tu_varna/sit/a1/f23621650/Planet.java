package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private String name;
    private List<Jedi> jediList = new ArrayList<Jedi>();

    public String getName() {
        return name;
    }

    public Planet(String name) {
        this.name = name;
    }

    public void addJedi(Jedi jedi)
    {
        jediList.add(jedi);
    }

    public void removeJedi(String name)
    {
        for(Jedi jedi: jediList)
        {
            if(jedi.getJediName() == name)
            {
                jediList.remove(jedi);
                break;
            }
        }
    }
}
