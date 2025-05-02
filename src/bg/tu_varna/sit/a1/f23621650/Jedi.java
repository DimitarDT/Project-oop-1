package bg.tu_varna.sit.a1.f23621650;

import java.util.Objects;

public class Jedi {
    public enum LightsaberColor {
        BLUE, GREEN, PURPLE, YELLOW, ORANGE, WHITE, BLACK, RED;

        public static LightsaberColor fromString(String input) {
            if (input == null) return null;//???

            try {
                return LightsaberColor.valueOf(input.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }
    private String jediName;
    private JediRank jediRank;
    private int age;
    private LightsaberColor lightsaberColor;
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

    public LightsaberColor getLightsaberColor() {
        return lightsaberColor;
    }

    public Planet getPlanet() {
        return planet;
    }

    private void addSelfToPlanet() {
        planet.addToPlanet(jediName, this);
    }

    public Jedi(String jediName, JediRank jediRank, int age, String lightsaberColor, double strength, Planet planet) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("The jedi ");
        sb.append("jediName='").append(jediName).append('\'');
        sb.append(", jediRank=").append(jediRank);
        sb.append(", age=").append(age);
        sb.append(", lightsaberColor='").append(lightsaberColor).append('\'');
        sb.append(", strength=").append(strength);
        sb.append(", planet=").append(planet.getName());
        sb.append("}\n");
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
