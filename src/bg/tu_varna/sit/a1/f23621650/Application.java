package bg.tu_varna.sit.a1.f23621650;

public class Application {

    public static void main(String[] args) {
        StarWarsUniverse starWarsUniverse = StarWarsUniverse.getInstance();
        /*starWarsUniverse.addPlanetToUniverse("Tattoine");
        starWarsUniverse.createJedi("Tattoine", "Anakin", JediRank.KNIGHT, 20, "Red", 1.5);
        starWarsUniverse.createJedi("Tattoine", "Obi-wan", JediRank.KNIGHT, 30, "Green", 1.5);
        starWarsUniverse.createJedi("Tattoine", "Ashoka", JediRank.KNIGHT, 18, "Green", 1);

        starWarsUniverse.addPlanetToUniverse("Bomboclat");
        starWarsUniverse.createJedi("Bomboclat", "JAnakin", JediRank.KNIGHT, 21, "Green", 1.6);
        starWarsUniverse.createJedi("Bomboclat", "WaObi-waan", JediRank.GRAND_MASTER, 30, "Orange", 1.6);
        starWarsUniverse.createJedi("Bomboclat", "RasclatAshoka", JediRank.PADAWAN, 19, "Green", 1.2);*/

        starWarsUniverse.readFromFile("universe");
        starWarsUniverse.printTwoPlanetsJedis("Tattoine", "Bomboclat");
    }
}
