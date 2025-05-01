package bg.tu_varna.sit.a1.f23621650;

import java.util.Objects;

public class Jedi {
    private String jediName;
    private JediRank jediRank;
    private int age;
    private String lightsaberColor;
    private double strength;
    private Planet planet;

    public String getJediName() {
        return jediName;
    }

    public JediRank getJediRank() {
        return jediRank;
    }

    public void setJediRank(JediRank jediRank) {
        this.jediRank = jediRank;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getAge() {
        return age;
    }

    public String getLightsaberColor() {
        return lightsaberColor;
    }

    public Planet getPlanet() {
        return planet;
    }

    public Jedi(String jediName, JediRank jediRank, int age, String lightsaberColor, double strength, Planet planet) {
        this.jediName = jediName;
        this.jediRank = jediRank;
        this.age = age;
        this.lightsaberColor = lightsaberColor;
        this.strength = strength;
        this.planet = planet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("The jedi ");
        sb.append("jediName='").append(jediName).append('\'');
        sb.append(", jediRank=").append(jediRank);
        sb.append(", age=").append(age);
        sb.append(", lightsaberColor='").append(lightsaberColor).append('\'');
        sb.append(", strength=").append(strength);
        sb.append(", planet=").append(planet);
        sb.append('}');
        return sb.toString();
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
