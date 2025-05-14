package bg.tu_varna.sit.a1.f23621650;

import java.io.*;

public class UniverseWriter {
    JediManager jediManager;
    PlanetManager planetManager;

    public UniverseWriter() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    public void writeTo(String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try{
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            objectOutputStream.writeObject(jediManager);
            objectOutputStream.writeObject(planetManager);
        }
        finally{
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
