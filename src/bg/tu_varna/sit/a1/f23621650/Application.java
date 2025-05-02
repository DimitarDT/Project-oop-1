package bg.tu_varna.sit.a1.f23621650;

public class Application {

    public static void main(String[] args) {
        StarWarsUniverse starWarsUniverse = StarWarsUniverse.getInstance();
        starWarsUniverse.addPlanetToUniverse("Tattoine");
        starWarsUniverse.addJediToPlanet("Tattoine", "Anakin", JediRank.KNIGHT, 20, "Red", 1.5);
        starWarsUniverse.addJediToPlanet("Tattoine", "Obi-wan", JediRank.MASTER, 30, "Green", 1.5);
        starWarsUniverse.addJediToPlanet("Tattoine", "Ashoka", JediRank.KNIGHT, 18, "Green", 1);

        starWarsUniverse.addPlanetToUniverse("Bomboclat");
        starWarsUniverse.addJediToPlanet("Bomboclat", "JAnakin", JediRank.KNIGHT, 21, "Green", 1.6);
        starWarsUniverse.addJediToPlanet("Bomboclat", "WaObi-waan", JediRank.GRAND_MASTER, 30, "Orange", 1.6);
        starWarsUniverse.addJediToPlanet("Bomboclat", "RasclatAshoka", JediRank.PADAWAN, 19, "Green", 1.2);

        starWarsUniverse.removeJediFromPlanet("Anakin", "Tattoine");
        starWarsUniverse.removeJediFromPlanet("Ashoka", "Tattoine");
        starWarsUniverse.removeJediFromPlanet("Obi-wan", "Tattoine");
        starWarsUniverse.printPlanet("Tattoine");
    }
}
