package calculator.model;

public class CustomDelimiterProcessor {
    public static String addCustomDelimiters(String inputString, Delimiters delimiters) {
        while (usesCustomDelimiter(inputString)) {
            correctCustomDelimiterFormatOrThrow(inputString);
            char customDelimiter = inputString.charAt(2);
            delimiters.addCustomDelimiter(customDelimiter);
            inputString = inputString.substring(5);
        }
        return inputString;
    }

    private static boolean usesCustomDelimiter(String inputString) {
        if (inputString.length() == 0) {
            return false;
        }
        char firstChar = inputString.charAt(0);
        return firstChar == '/';
    }

    private static void correctCustomDelimiterFormatOrThrow(String inputString) {
        if (!checkCustomDelimiterFormatLength(inputString)) {
            throw new IllegalArgumentException();
        }
        if (isCustomDelimiterFirstFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
        if (isCustomDelimiterLastFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkCustomDelimiterFormatLength(String inputString) {
        return inputString.length() >= 5;
    }

    private static boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals("//");
    }

    private static boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals("\n");
    }
}
