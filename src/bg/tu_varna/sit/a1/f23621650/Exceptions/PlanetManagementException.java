package bg.tu_varna.sit.a1.f23621650.Exceptions;


/**
 * Exception thrown when an error occurs during planet management operations,
 * such as invalid actions related to adding, removing, or querying Jedi on a planet.
 */
public class PlanetManagementException extends Exception {
  /**
   * Constructs a new {@code PlanetManagementException} with the specified detail message.
   *
   * @param message the detail message explaining the reason for the exception
   */
  public PlanetManagementException(String message) {
    super(message);
  }
}
