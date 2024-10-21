package calculator;

public class MetaCharacterUtil {

    private static final String[] META_CHARACTERS = {".", "*", "+", "?", "|", "^", "$", "(", ")", "[", "]", "{", "}", "\\"};

    public static String escapeMetaCharacters(String delimiter) {
        for (String metaChar : META_CHARACTERS) {
            if (delimiter.equals(metaChar)) {
                return "\\" + delimiter;
            }
        }
        return delimiter;
    }
}

