package bg.tu_varna.sit.a1.f23621650;

public class Jedi {
    private String jediName;
    private JediRank jediRank;
    private int age;
    private String lightsaberColor;
    private double strength;

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

    //Objects version 1.7?? Also should there be non-null fields? Which fields should be included to ensure every jedi is unique?
    //this uses the intellij default methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jedi)) return false;

        Jedi jedi = (Jedi) o;

        return jediName != null ? jediName.equals(jedi.jediName) : jedi.jediName == null;
    }

    @Override
    public int hashCode() {
        return jediName != null ? jediName.hashCode() : 0;
    }
}
