package bg.tu_varna.sit.a1.f23621650.FileHandling;

import bg.tu_varna.sit.a1.f23621650.JediManager;
import bg.tu_varna.sit.a1.f23621650.PlanetManager;

import java.io.*;

/**
 * Responsible for saving the current state of the Star Wars universe to a file.
 * Serializes the singleton {@link JediManager} and {@link PlanetManager} instances.
 */
public class UniverseWriter {
    JediManager jediManager;
    PlanetManager planetManager;

    /**
     * Constructs a new {@code UniverseWriter} linked to the singleton managers.
     */
    public UniverseWriter() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    /**
     * Writes the current universe state to the specified file by serializing
     * the {@link JediManager} and {@link PlanetManager}.
     * <p>
     * This method ensures that the file stream is closed regardless of whether
     * the operation completes successfully or an exception is thrown.
     *
     * @param fileName the path to the file where the universe state will be saved
     * @throws IOException if an I/O error occurs while writing to the file
     */
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
