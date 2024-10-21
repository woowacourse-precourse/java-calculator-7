package calculator.service;

public class HeaderUtils {

    private static final String END_STR = "\\n";
    private static final String START_STR = "//";

    public static boolean hasCustomDelimiter(String input) {
        return input != null && input.startsWith(START_STR);
    }

    public static String extractHeader(String input) {
        int endIndex = input.indexOf(END_STR);
        if (endIndex == -1) {
            throw new IllegalArgumentException("invalid header: missing newline after header");
        }

        String delimiter = input.substring(START_STR.length(), endIndex);
        validate(delimiter);

        return input.substring(0, endIndex + END_STR.length());
    }

    private static void validate(String delimiter) {
        if (delimiter.isBlank()) {
            throw new IllegalArgumentException("invalid header: delimiter cannot be blank");
        }
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("invalid header: invalid length");
        }
        if (Character.isDigit(delimiter.charAt(0))) {
            throw new IllegalArgumentException("invalid header: delimiter cannot be a digit");
        }
    }
}
