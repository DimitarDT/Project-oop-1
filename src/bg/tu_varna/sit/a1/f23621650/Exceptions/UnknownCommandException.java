package bg.tu_varna.sit.a1.f23621650.Exceptions;

/**
 * Exception thrown when an unrecognized or unsupported command
 * is encountered in the command line interface.
 */
public class UnknownCommandException extends Exception {

    /**
     * Constructs a new UnknownCommandException with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public UnknownCommandException(String message) {
        super(message);
    }
}
