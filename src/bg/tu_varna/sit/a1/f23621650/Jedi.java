package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.Enums.JediRank;
import bg.tu_varna.sit.a1.f23621650.Enums.LightsaberColor;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a Jedi character in the system.
 * Each Jedi has a name, rank, age, lightsaber color, strength, and is associated with a planet.
 * This class provides methods to promote or demote a Jedi, and ensures proper validation of attributes.
 * <p>
 * Upon creation, the Jedi is automatically added to their respective planet.
 * </p>
 */

public class Jedi implements Serializable {
    private final String jediName;
    private JediRank jediRank;
    private final int age;
    private final LightsaberColor lightsaberColor;
    private double strength;
    private final Planet planet;

    /**
     * Returns the name of the Jedi.
     *
     * @return the Jedi's name
     */
    public String getJediName() {
        return jediName;
    }

    /**
     * Returns the rank of the Jedi.
     *
     * @return the Jedi's rank
     */
    public JediRank getJediRank() {
        return jediRank;
    }

    /**
     * Returns the strength of the Jedi.
     *
     * @return the Jedi's strength
     */
    public double getStrength() { return strength; }

    /**
     * Returns the age of the Jedi.
     *
     * @return the Jedi's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the lightsaber color of the Jedi.
     *
     * @return the Jedi's lightsaber color
     */
    public LightsaberColor getLightsaberColor() {
        return lightsaberColor;
    }

    private void addSelfToPlanet() {
        planet.addToPlanet(jediName, this);
    }

    /**
     * Constructs a new {@code Jedi} instance with the specified parameters.
     *
     * @param jediName        the name of the Jedi
     * @param jediRank        the rank of the Jedi
     * @param age             the age of the Jedi
     * @param lightsaberColor the color of the Jedi's lightsaber (as a string)
     * @param strength        the strength of the Jedi; must be between 1 and 2
     * @param planet          the planet where the Jedi resides
     * @throws JediManagementException if the strength is out of the valid range
     */
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

    /**
     * Promotes the Jedi to the next rank and increases strength based on a multiplier.
     *
     * @param multiplier the multiplier to apply to the Jedi's strength
     * @throws JediManagementException if the Jedi is already at the highest rank
     */
    public void promoteJedi(double multiplier) throws JediManagementException {
        if(jediRank.ordinal() < JediRank.values().length) {
            jediRank = JediRank.values()[jediRank.ordinal() + 1];
            strength = multiplier * strength + strength;
        } else {
            throw new JediManagementException("Jedi is the highest rank!");
        }
    }

    /**
     * Demotes the Jedi to the previous rank and decreases strength based on a multiplier.
     *
     * @param multiplier the multiplier to apply to the Jedi's strength
     * @throws JediManagementException if the Jedi is already at the lowest rank
     */
    public void demoteJedi(double multiplier) throws JediManagementException {
        if(jediRank.ordinal() > 0) {
            jediRank = JediRank.values()[jediRank.ordinal() - 1];
            strength = strength - (multiplier * strength);
        } else {
            throw new JediManagementException("Jedi is the lowest rank!");
        }
    }

    /**
     * Returns a string representation of the Jedi with all relevant details.
     *
     * @return a formatted string describing the Jedi
     */
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

    /**
     * Checks whether two Jedi objects are equal based on their names.
     *
     * @param o the object to compare
     * @return {@code true} if the Jedi names are equal; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jedi jedi)) return false;
        return Objects.equals(jediName, jedi.jediName);
    }

    /**
     * Returns the hash code for this Jedi, based on the Jedi's name.
     *
     * @return the hash code of the Jedi
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(jediName);
    }
}
