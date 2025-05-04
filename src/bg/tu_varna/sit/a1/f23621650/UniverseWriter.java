package bg.tu_varna.sit.a1.f23621650;

import java.io.*;

public class UniverseWriter {
    JediManager jediManager;
    PlanetManager planetManager;

    public UniverseWriter(JediManager jediManager, PlanetManager planetManager) {
        this.jediManager = jediManager;
        this.planetManager = planetManager;
    }

    public void writeTo(String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        objectOutputStream.writeObject(jediManager);
        objectOutputStream.writeObject(planetManager);
        objectOutputStream.close();
    }
}
