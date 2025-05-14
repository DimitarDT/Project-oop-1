package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;

import java.io.Serializable;
import java.util.Objects;

public class Jedi implements Serializable {
    private final String jediName;
    private JediRank jediRank;
    private final int age;
    private final LightsaberColor lightsaberColor;
    private double strength;
    private final Planet planet;

    public String getJediName() {
        return jediName;
    }

    public JediRank getJediRank() {
        return jediRank;
    }

    public double getStrength() { return strength; }

    public int getAge() {
        return age;
    }

    public LightsaberColor getLightsaberColor() {
        return lightsaberColor;
    }

    private void addSelfToPlanet() {
        planet.addToPlanet(jediName, this);
    }

    public Jedi(String jediName, JediRank jediRank, int age, String lightsaberColor, double strength, Planet planet) throws JediManagementException {
        if(strength < 1 || strength > 2)
            throw new JediManagementException("Strength must be between 1 and 2.");
        this.jediName = jediName;
        this.jediRank = jediRank;
        this.age = age;
        this.lightsaberColor = LightsaberColor.fromString(lightsaberColor);
        this.strength = strength;
        this.planet = planet;
        addSelfToPlanet();
    }

    public void promoteJedi(double multiplier) throws JediManagementException {
        if(jediRank.ordinal() < JediRank.values().length) {
            jediRank = JediRank.values()[jediRank.ordinal() + 1];
            strength = multiplier * strength + strength;
        } else {
            throw new JediManagementException("Jedi is the highest rank!");
        }
    }

    public void demoteJedi(double multiplier) throws JediManagementException {
        if(jediRank.ordinal() > 0) {
            jediRank = JediRank.values()[jediRank.ordinal() - 1];
            strength = strength - (multiplier * strength);
        } else {
            throw new JediManagementException("Jedi is the lowest rank!");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Jedi ");
        sb.append('\'').append(CapitalizeWords.capitalize(jediName)).append("' has: ");
        sb.append("Rank - ").append(jediRank);
        sb.append(", Age - ").append(age);
        sb.append(", lightsaber color - '").append(lightsaberColor).append('\'');
        sb.append(", strength - ").append(strength);
        sb.append(" and lives on planet - ").append(CapitalizeWords.capitalize(planet.getName()));
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jedi jedi)) return false;
        return Objects.equals(jediName, jedi.jediName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jediName);
    }
}
