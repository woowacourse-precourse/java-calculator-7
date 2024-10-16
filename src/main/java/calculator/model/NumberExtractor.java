package calculator.model;

public class NumberExtractor {
    public static void extractNumber(String inputString, Delimiters delimiters, Calculator calculator) {
        if (!isStartingWithDigit(inputString)) {
            throw new IllegalArgumentException();
        }
        String[] splitedStringArray = splitByDelimiters(delimiters, inputString);
        for (String str : splitedStringArray) {
            validateNumberString(str);
            int number = Integer.parseInt(str);
            calculator.saveNumber(number);
        }
    }

    private static boolean isStartingWithDigit(String inputString) {
        char firstChar = inputString.charAt(0);
        return Character.isDigit(firstChar);
    }

    private static String[] splitByDelimiters(Delimiters delimiters, String inputString) {
        String delimiterRegex = createDelimiterRegex(delimiters);
        String[] splitedStringArray = inputString.split(delimiterRegex);
        return splitedStringArray;
    }

    private static String createDelimiterRegex(Delimiters delimiters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : delimiters.getDelimiters()) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static void validateNumberString(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
