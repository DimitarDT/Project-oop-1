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
}
