package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.*;
import bg.tu_varna.sit.a1.f23621650.Exceptions.EmptyFileException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.JediManagementException;
import bg.tu_varna.sit.a1.f23621650.Exceptions.PlanetManagementException;

import java.io.IOException;

public abstract class AbstractState implements State {
    JediManager jediManager;
    PlanetManager planetManager;

    public AbstractState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    @Override
    public void addPlanetToUniverse(String planetName) throws PlanetManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public void promote(String jediName, double multiplier) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public void demote(String jediName, double multiplier) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public Jedi getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public Jedi getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public String getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public String getMostUsedSaberColor(String planetName) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public String printPlanet(String planetName) throws PlanetManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public String printJedi(String jediName) throws JediManagementException, IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public String printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) throws IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        throw new IOException("No file has been opened yet.");
    }

    @Override
    public void readFromFile(String fileName) throws IOException, EmptyFileException, ClassNotFoundException {
        throw new IOException("You must close the current file to open another one!");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("No file has been opened yet.");
    }
}
