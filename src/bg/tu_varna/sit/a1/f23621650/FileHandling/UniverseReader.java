package bg.tu_varna.sit.a1.f23621650.FileHandling;

import bg.tu_varna.sit.a1.f23621650.JediManager;
import bg.tu_varna.sit.a1.f23621650.PlanetManager;

import java.io.*;

/**
 * Responsible for reading the state of the Star Wars universe from a file.
 * Loads serialized {@link JediManager} and {@link PlanetManager} objects
 * and updates the singleton instances with the loaded data.
 */
public class UniverseReader {
    JediManager jediManager;
    PlanetManager planetManager;
    JediManager jediManagerTemp;
    PlanetManager planetManagerTemp;

    /**
     * Constructs a new {@code UniverseReader} linked to the singleton managers.
     */
    public UniverseReader() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    /**
     * Reads the serialized universe state from the specified file,
     * updating the internal managers with the loaded data.
     * <p>
     * This method ensures that the file stream is closed regardless of whether
     * the operation completes successfully or an exception is thrown.
     *
     * @param fileName the path to the file containing the saved universe state
     * @throws IOException if an I/O error occurs while reading the file
     * @throws ClassNotFoundException if the class of a serialized object cannot be found
     */
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