package bg.tu_varna.sit.a1.f23621650;

public class StarWarsUniverse {
    //Singleton implementation
    private static StarWarsUniverse starWarsUniverse;
    private StarWarsUniverse(){
        jediManager = JediManager.getInstance();
        planetManager = PlanetManager.getInstance();
    }
    public static StarWarsUniverse getInstance() {
        if(starWarsUniverse == null) {
            starWarsUniverse = new StarWarsUniverse();
        }
        return starWarsUniverse;
    }

    private JediManager jediManager;
    private PlanetManager planetManager;

    public void addPlanetToUniverse(String planetName) {
        planetManager.addPlanet(planetName);
    }

    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) {
        if(!(planetManager.containsPlanet(planetName)))
        {
            throw new PlanetManagementException("Jedi creation wasn't successful. There is no such planet.");
        }
        jediManager.addJedi(new Jedi(jediName, jediRank, jediAge, saberColor, jediStrength, planetManager.getPlanet(planetName)));
    }

    public void removeJediFromPlanet(String jediName, String planetName) {
        if(!(planetManager.containsPlanet(planetName)))
        {
            throw new PlanetManagementException("Jedi removal wasn't successful. There is no such planet.");
        }
        jediManager.removeJedi(jediName, planetManager.getPlanet(planetName));
    }

    public void promote(String jediName, double multiplier) { //multiplier must be positive number dobavi!
        jediManager.promoteJedi(jediName, multiplier);
    }

    public void demote(String jediName, double multiplier) {
        jediManager.demoteJedi(jediName, multiplier);
    }

    public void getStrongestJedi(String planetName) {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        System.out.println(jediManager.getStrongestJedi(planetManager.getPlanet(planetName)).toString());
    }

    public void getYoungestJedi(String planetName, JediRank jediRank) {
        if(!(planetManager.containsPlanet(planetName))) {       //this repeats
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        System.out.println(jediManager.getYoungestJedi(planetManager.getPlanet(planetName), jediRank));
    }

    public void getMostUsedSaberColor(String planetName, JediRank jediRank) {
        System.out.println("Most used saber color is: " + planetManager.getMostUsedSaberColor(planetName, jediRank));
    }

    public void getMostUsedSaberColor(String planetName) {
        System.out.println("Most used saber color of grandmasters on " + planetName + " is: " + planetManager.getMostUsedSaberColor(planetName, JediRank.GRAND_MASTER));
    }

    public void printPlanet(String planetName) {
        System.out.println(planetManager.getPlanet(planetName).toString());
    }

    public void printJedi(String jediName) {
        System.out.println(jediManager.getJedi(jediName).toString());
    }

    public void printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) {
        System.out.println(planetManager.printTwoPlanets(firstPlanetName, secondPlanetName));
    }
}
