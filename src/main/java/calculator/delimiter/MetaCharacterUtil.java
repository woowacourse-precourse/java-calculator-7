package calculator.delimiter;

public class MetaCharacterUtil {

    private static final String[] META_CHARACTERS = {".", "*", "+", "?", "|", "^", "$", "(", ")", "[", "]", "{", "}",
            "\\"};

    public static String isContainMetaCharacters(String delimiter) {
        for (String metaChar : META_CHARACTERS) {
            delimiter = escapeMetaChar(delimiter, metaChar);
        }
        return delimiter;
    }

    public static String escapeMetaChar(String delimiter, String metaChar) {
        if (delimiter.equals(metaChar)) {
            return "\\" + delimiter;
        }
        return delimiter;
    }
}

