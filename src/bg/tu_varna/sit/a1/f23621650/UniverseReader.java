package bg.tu_varna.sit.a1.f23621650;

import java.io.*;

public class UniverseReader {
    JediManager jediManager;
    PlanetManager planetManager;
    JediManager jediManagerTemp;
    PlanetManager planetManagerTemp;

    public UniverseReader() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    public void readFrom(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            jediManagerTemp = (JediManager) objectInputStream.readObject();
            planetManagerTemp = (PlanetManager) objectInputStream.readObject();
            jediManager.copy(jediManagerTemp);
            planetManager.copy(planetManagerTemp);
        }
        finally {
            if(objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}