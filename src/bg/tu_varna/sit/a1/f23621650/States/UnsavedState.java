package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.JediManager;
import bg.tu_varna.sit.a1.f23621650.PlanetManager;

import java.io.IOException;
import java.util.Scanner;

public class UnsavedState extends SavedState {
    public UnsavedState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    @Override
    public void readFromFile(String fileName) throws IOException {
        throw new IOException("You haven't saved your work! Loading a new file now will delete it!");
    }

    @Override
    public void close() throws IOException {
        System.out.println("You haven't saved. Are you sure you want to close the file?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")){
            jediManager.clear();
            planetManager.clear();
        }
        else{
            throw new IOException("File was not closed.");
        }
    }
}