package bg.tu_varna.sit.a1.f23621650.States;

import bg.tu_varna.sit.a1.f23621650.JediManager;
import bg.tu_varna.sit.a1.f23621650.PlanetManager;

import java.io.IOException;
import java.util.Scanner;


/**
 * Represents the state where the universe file has been modified but not yet saved.
 * <p>
 * This state inherits behavior from {@link SavedState}, reusing most of its logic for
 * operations on Jedi and planets. However, it overrides file operations to prevent data loss.
 * </p>
 * <p>
 * In particular, it prevents reading a new file until changes are saved, and asks for user confirmation before closing.
 * </p>
 */
public class UnsavedState extends SavedState {

    /**
     * Initializes the UnsavedState with shared manager instances.
     */
    public UnsavedState() {
        this.jediManager = JediManager.getInstance();
        this.planetManager = PlanetManager.getInstance();
    }

    /**
     * Prevents reading a new file while unsaved changes exist.
     *
     * @param fileName The name of the file the user attempted to read.
     * @throws IOException always thrown to block the operation and warn about unsaved data loss.
     */
    @Override
    public void readFromFile(String fileName) throws IOException {
        throw new IOException("You haven't saved your work! Loading a new file now will delete it!");
    }

    /**
     * Prompts the user for confirmation before closing without saving changes.
     * If the user confirms, clears the internal Jedi and Planet managers.
     *
     * @throws IOException if the user chooses not to proceed with closing.
     */
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