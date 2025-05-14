package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.Exceptions.EmptyFileException;
import bg.tu_varna.sit.a1.f23621650.JediManager;
import bg.tu_varna.sit.a1.f23621650.PlanetManager;
import bg.tu_varna.sit.a1.f23621650.UniverseReader;

import java.io.File;
import java.io.IOException;

public class UnopenedState extends AbstractState {
    public UnopenedState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

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
