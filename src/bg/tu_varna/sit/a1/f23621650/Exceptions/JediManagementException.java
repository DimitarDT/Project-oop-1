package bg.tu_varna.sit.a1.f23621650.Exceptions;

/**
 * Exception thrown when an error occurs during Jedi management operations,
 * such as invalid strength values, rank promotion/demotion limits,
 * or attempts to query Jedi data under invalid conditions.
 */
public class JediManagementException extends Exception {
    /**
     * Constructs a new {@code JediManagementException} with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public JediManagementException(String message) {
        super(message);
    }
}
