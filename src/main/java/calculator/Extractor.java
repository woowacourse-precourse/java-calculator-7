package calculator;

public class Extractor {

    public static String extractDelimiter(String value, String delimiter,String prefix, String suffix){
        if (isCustomDelimiter(value, prefix)) {
            int delimiterIndex = value.indexOf(suffix);
            String customDelimiter = value.substring(prefix.length(), delimiterIndex);
            return addDelimiter(delimiter, customDelimiter);
        }
        return delimiter;
    }

    public static String extractNumberPart(String value, String prefix, String suffix){
        if (isCustomDelimiter(value, prefix)) {
            int delimiterIndex = value.indexOf(suffix);
            return value.substring(delimiterIndex + 2);
        }
        return value;
    }

    private static boolean isCustomDelimiter(String value, String prefix){
        return value.startsWith(prefix);
    }

    private static String addDelimiter(String existingDelimiters, String newDelimiter) {
        return existingDelimiters.substring(0, existingDelimiters.length() - 1) + newDelimiter + "]";
    }
}
