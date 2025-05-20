package bg.tu_varna.sit.a1.f23621650;


/**
 * Utility class for capitalizing words in a string.
 * <p>
 * Provides a method to capitalize the first letter of each word while
 * converting the rest of the characters to lowercase.
 */
public class CapitalizeWords {

    /**
     * Capitalizes the first letter of each word in the given string,
     * converting the rest of the characters in each word to lowercase.
     * Words are separated by whitespace.
     * <p>
     * Usually used for output of names.
     * Also works if the name contains the ' symbol.
     * </p>
     *
     * @param input the string to capitalize; may be {@code null} or empty
     * @return a new string with each word capitalized, or the original
     *         string if {@code input} is {@code null} or empty
     */
    public static String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.trim().split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String[] parts = word.split("'");
                for (int i = 0; i < parts.length; i++) {
                    if (!parts[i].isEmpty()) {
                        capitalized.append(Character.toUpperCase(parts[i].charAt(0)))
                                .append(parts[i].substring(1).toLowerCase());
                    }
                    if (i < parts.length - 1) {
                        capitalized.append("'");
                    }
                }
                capitalized.append(" ");
            }
        }

        return capitalized.toString().trim();
    }
}