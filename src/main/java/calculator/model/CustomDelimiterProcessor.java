package calculator.model;

public class CustomDelimiterProcessor {
    public static boolean usesCustomDelimiter(String inputString) {
        char firstChar = inputString.charAt(0);
        return firstChar == '/';
    }

    public boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals("//");
    }

    public boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals("\n");
    }
}
