package bg.tu_varna.sit.a1.f23621650;

import java.util.Objects;

public class Jedi {
    private String jediName;
    private JediRank jediRank;
    private int age;
    private String lightsaberColor;
    private double strength;
    private String planetName;

    public String getJediName() {
        return jediName;
    }

    public Jedi(String jediName, JediRank jediRank, int age, String lightsaberColor, double strength) {
        this.jediName = jediName;
        this.jediRank = jediRank;
        this.age = age;
        this.lightsaberColor = lightsaberColor;
        this.strength = strength;
    }

    //Objects version 1.7?? Also, should there be non-null fields? Which fields should be included to ensure every jedi is unique?
    //this uses the intellij default methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jedi jedi)) return false;
        return Objects.equals(jediName, jedi.jediName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jediName);
    }
}
