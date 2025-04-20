package bg.tu_varna.sit.a1.f23621650;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Planet {
    private String name;
    private HashMap<String, Jedi> jediMap = new HashMap<>();

    public String getName() {
        return name;
    }

    public HashMap<String, Jedi> getJediMap() {
        return jediMap;
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
}
