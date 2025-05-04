package bg.tu_varna.sit.a1.f23621650;

import java.io.*;

public class UniverseReader {
    JediManager jediManager;
    PlanetManager planetManager;

    public void readFrom(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        jediManager = (JediManager) objectInputStream.readObject();
        planetManager = (PlanetManager) objectInputStream.readObject();
        objectInputStream.close();
    }

    public JediManager getJediManager() {
        if(jediManager == null)
            throw new NullPointerException("jediManager is null");
        return jediManager;
    }

    public PlanetManager getPlanetManager() {
        if(jediManager == null)
            throw new NullPointerException("jediManager is null");
        return planetManager;
    }
}
