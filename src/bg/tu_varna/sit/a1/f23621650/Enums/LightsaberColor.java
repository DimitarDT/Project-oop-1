package bg.tu_varna.sit.a1.f23621650.Enums;

/**
 * Represents the possible colors of a Jedi's lightsaber.
 * Each color may correspond to different meanings or affiliations within the Star Wars universe.
 */
public enum LightsaberColor {
    BLUE, GREEN, PURPLE, YELLOW, ORANGE, WHITE, BLACK, RED;

    /**
     * Converts a string input to the corresponding {@code LightsaberColor} enum constant.
     * The input is case-insensitive and trimmed of whitespace.
     *
     * @param input the string representation of a lightsaber color
     * @return the matching {@code LightsaberColor}, or {@code null} if no match is found or input is {@code null}
     */
    public static LightsaberColor fromString(String input) {
        if (input == null) return null;

        try {
            return LightsaberColor.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
