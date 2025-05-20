package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.Exceptions.EmptyFileException;
import bg.tu_varna.sit.a1.f23621650.JediManager;
import bg.tu_varna.sit.a1.f23621650.PlanetManager;
import bg.tu_varna.sit.a1.f23621650.FileHandling.UniverseReader;

import java.io.File;
import java.io.IOException;

/**
 * Represents the state of the application when no universe file is currently opened.
 * <p>
 * In this state, most operations are unavailable except for reading/loading
 * a universe file. If the specified file does not exist, it is created and
 * an {@link EmptyFileException} is thrown to indicate the new empty file.
 * If the file exists but is empty, an {@link EmptyFileException} is also thrown.
 * </p>
 * <p>
 * Successfully reading a non-empty file loads the universe data into the system.
 * </p>
 */
public class UnopenedState extends AbstractState {

    /**
     * Constructs a new UnopenedState initializing references to the singleton managers.
     */
    public UnopenedState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    /**
     * Attempts to read and load universe data from the specified file.
     * <p>
     * If the file does not exist, it will be created and an {@link EmptyFileException}
     * is thrown indicating that a new empty file was created.
     * If the file exists but is empty, an {@link EmptyFileException} is thrown.
     * Otherwise, the universe data is loaded from the file.
     * </p>
     * <p>
     * Internally, this method uses {@link UniverseReader} to load the data from the file.
     * </p>
     *
     * @param fileName the path of the file to read the universe data from
     * @throws IOException if an I/O error occurs during reading or file creation
     * @throws EmptyFileException if the file is empty or newly created
     * @throws ClassNotFoundException if deserialization fails due to missing class definitions
     */
    @Override
    public void readFromFile(String fileName) throws IOException, EmptyFileException, ClassNotFoundException {
        if(new File(fileName).createNewFile())
            throw new EmptyFileException("No such file found. New one created.");
        if(new File(fileName).length() == 0)
            throw new EmptyFileException("File is empty but opened for editing.");
        UniverseReader universeReader = new UniverseReader();
        universeReader.readFrom(fileName);
    }
}
