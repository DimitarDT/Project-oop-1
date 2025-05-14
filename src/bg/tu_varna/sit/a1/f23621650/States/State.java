package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.*;

import java.io.IOException;

public interface State {
    void addPlanetToUniverse(String planetName) throws PlanetManagementException, IOException;

    void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException, IOException;

    void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException, IOException;

    void promote(String jediName, double multiplier) throws JediManagementException, IOException;

    void demote(String jediName, double multiplier) throws JediManagementException, IOException;

    Jedi getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException, IOException;

    Jedi getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException, IOException;

    String getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException, IOException;

    String getMostUsedSaberColor(String planetName) throws JediManagementException, IOException;

    String printPlanet(String planetName) throws PlanetManagementException, IOException;

    String printJedi(String jediName) throws JediManagementException, IOException;

    String printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) throws IOException;

    void writeToFile(String fileName) throws IOException;

    void readFromFile(String fileName) throws IOException, ClassNotFoundException, EmptyFileException;

    void close() throws IOException;
}
