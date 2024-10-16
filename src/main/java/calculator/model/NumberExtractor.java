package calculator.model;

public class NumberExtractor {
    private boolean isStartingWithDigit(String inputString) {
        char firstChar = inputString.charAt(0);
        return Character.isDigit(firstChar);
    }

    private String[] splitByDelimiters(Delimiters delimiters, String inputString) {
        String delimiterRegex = createDelimiterRegex(delimiters);
        String[] splitedStringArray = inputString.split(delimiterRegex);
        return splitedStringArray;
    }

    private String createDelimiterRegex(Delimiters delimiters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : delimiters.getDelimiters()) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
