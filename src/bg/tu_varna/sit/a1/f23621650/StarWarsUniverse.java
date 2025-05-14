package bg.tu_varna.sit.a1.f23621650;

import bg.tu_varna.sit.a1.f23621650.States.SavedState;
import bg.tu_varna.sit.a1.f23621650.States.State;
import bg.tu_varna.sit.a1.f23621650.States.UnopenedState;
import bg.tu_varna.sit.a1.f23621650.States.UnsavedState;

import java.io.IOException;

public class StarWarsUniverse {
    //Singleton implementation
    private static StarWarsUniverse starWarsUniverse;
    private StarWarsUniverse(){
        state = new UnopenedState();
    }
    public static StarWarsUniverse getInstance() {
        if(starWarsUniverse == null) {
            starWarsUniverse = new StarWarsUniverse();
        }
        return starWarsUniverse;
    }

    private State state;
    private String currentFile;

    public void addPlanetToUniverse(String planetName) throws PlanetManagementException {
        try {
            state.addPlanetToUniverse(planetName.toLowerCase());
            setState(new UnsavedState());
            System.out.println("Planet " + planetName + " added to universe.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createJedi(String planetName, String jediName, JediRank jediRank, int jediAge, String saberColor, double jediStrength) throws PlanetManagementException, JediManagementException {
        try {
            state.createJedi(planetName.toLowerCase(), jediName.toLowerCase(), jediRank, jediAge, saberColor, jediStrength);
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " added to universe.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeJediFromPlanet(String jediName, String planetName) throws PlanetManagementException, JediManagementException {
        try {
            state.removeJediFromPlanet(jediName.toLowerCase(), planetName.toLowerCase());
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " removed from universe.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void promote(String jediName, double multiplier) throws JediManagementException {
        try {
            state.promote(jediName.toLowerCase(), multiplier);
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " promoted.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void demote(String jediName, double multiplier) throws JediManagementException {
        try {
            state.demote(jediName.toLowerCase(), multiplier);
            setState(new UnsavedState());
            System.out.println("Jedi " + jediName + " was demoted.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getStrongestJedi(String planetName) throws PlanetManagementException, JediManagementException {
        try {
            System.out.println(state.getStrongestJedi(planetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getYoungestJedi(String planetName, JediRank jediRank) throws PlanetManagementException, JediManagementException {
        try {
            System.out.println(state.getYoungestJedi(planetName.toLowerCase(), jediRank));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getMostUsedSaberColor(String planetName, JediRank jediRank) throws JediManagementException {
        try {
            System.out.println("Most used saber color is: " + state.getMostUsedSaberColor(planetName.toLowerCase(), jediRank));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getMostUsedSaberColor(String planetName) throws JediManagementException {
        try {
            System.out.println("Most used saber color of grandmasters on " + planetName + " is: " + state.getMostUsedSaberColor(planetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printPlanet(String planetName) throws PlanetManagementException {
        try {
            System.out.println(state.printPlanet(planetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printJedi(String jediName) throws JediManagementException {
        try {
            System.out.println(state.printJedi(jediName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printTwoPlanetsJedis(String firstPlanetName, String secondPlanetName) {
        try {
            System.out.println(state.printTwoPlanetsJedis(firstPlanetName.toLowerCase(), secondPlanetName.toLowerCase()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAs(String fileName) {
        try {
            if(!fileName.endsWith(".txt"))
                fileName+=".txt";
            state.writeToFile(fileName);
            setState(new SavedState());
            currentFile = fileName;
            System.out.println("File saved.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save() {
        saveAs(currentFile);
    }

    public void readFromFile(String fileName) {
        try {
            if(!fileName.endsWith(".txt"))
                fileName+=".txt";
            state.readFromFile(fileName);
            setState(new SavedState());
            currentFile = fileName;
            System.out.println("File opened.");
        } catch (EmptyFileException e) {
            setState(new SavedState());
            currentFile = fileName;
            System.out.println("File opened.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        try {
            state.close();
            setState(new UnopenedState());
            currentFile = null;
            System.out.println("File closed.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setState(State state) {
        this.state = state;
    }
}