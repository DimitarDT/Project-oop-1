package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.*;

import java.io.IOException;

public class SavedState extends AbstractState {
    public SavedState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    @Override
    public void addPlanetToUniverse(String planetName) throws PlanetManagementException {
        planetManager.addPlanet(planetName);
    }

    @Override
    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName)))
        {
            throw new PlanetManagementException("Jedi creation wasn't successful. There is no such planet.");
        }
        jediManager.addJedi(new Jedi(jediName, jediRank, jediAge, saberColor, jediStrength, planetManager.getPlanet(planetName)));
    }

    @Override
    public void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName)))
        {
            throw new PlanetManagementException("Jedi removal wasn't successful. There is no such planet.");
        }
        jediManager.removeJedi(jediName, planetManager.getPlanet(planetName));
    }

    @Override
    public void promote(String jediName, double multiplier) throws JediManagementException {
        if(multiplier <= 0)
            throw new IllegalArgumentException("Multiplier must be positive number!");
        jediManager.getJedi(jediName).promoteJedi(multiplier);
    }

    @Override
    public void demote(String jediName, double multiplier) throws JediManagementException {
        if(multiplier <= 0)
            throw new IllegalArgumentException("Multiplier must be positive number!");
        jediManager.getJedi(jediName).demoteJedi(multiplier);
    }

    @Override
    public Jedi getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        return planetManager.getPlanet(planetName).getStrongestJedi();
    }

    @Override
    public Jedi getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        return planetManager.getPlanet(planetName).getYoungestJedi(jediRank);
    }

    @Override
    public String getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException {
        return planetManager.getPlanet(planetName).getMostUsedSaberColor(jediRank);
    }

    @Override
    public String getMostUsedSaberColor(String planetName) throws JediManagementException {
        return planetManager.getPlanet(planetName).getMostUsedSaberColor(JediRank.GRAND_MASTER);
    }

    @Override
    public String printPlanet(String planetName) throws PlanetManagementException {
        if(!(planetManager.containsPlanet(planetName))) {
            throw new PlanetManagementException("Operation wasn't successful. There is no such planet.");
        }
        return planetManager.getPlanet(planetName).toString();
    }

    @Override
    public String printJedi(String jediName) throws JediManagementException {
        return jediManager.getJedi(jediName).toString();
    }

    @Override
    public String printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) {
        return planetManager.printTwoPlanets(firstPlanetName, secondPlanetName);
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        UniverseWriter universeWriter = new UniverseWriter();
        universeWriter.writeTo(fileName);
    }

    @Override
    public void close() throws IOException {
        jediManager.clear();
        planetManager.clear();
    }
}
