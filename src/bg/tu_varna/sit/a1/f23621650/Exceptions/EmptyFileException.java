package bg.tu_varna.sit.a1.f23621650.Exceptions;

/**
 * Thrown to indicate that an attempt was made to read from a file
 * that is either newly created or contains no data.
 * <p>
 * This exception is typically used during file loading operations
 * to distinguish between a missing file and an empty but valid file.
 * </p>
 */
public class EmptyFileException extends Exception {

    /**
     * Constructs a new {@code EmptyFileException} with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public EmptyFileException(String message) {
        super(message);
    }
}
