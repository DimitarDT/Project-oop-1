package bg.tu_varna.sit.a1.f23621650;

public enum LightsaberColor {
    BLUE, GREEN, PURPLE, YELLOW, ORANGE, WHITE, BLACK, RED;

    public static LightsaberColor fromString(String input) {
        if (input == null) return null;

        try {
            return LightsaberColor.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
