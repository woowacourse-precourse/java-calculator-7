package calculator;

public class Cleaner {
    private StringData stringData;

    public Cleaner(StringData stringData) {
        this.stringData = stringData;
    }

    public String refineString() {
        String inputString = stringData.getInputString();
        if (inputString.length() == 5) {
            return "";
        }
        return inputString.substring(5);
    }

    public String refineSeparator() {
        String separator = stringData.getSeparator();
        String regexSpecialChars = ".^$*+?()[]{}|\\";
        boolean isRegexSpecialSeparator = regexSpecialChars.contains(separator);
        if (!isRegexSpecialSeparator) {
            return separator;
        }

        StringBuilder refinedSeparator = new StringBuilder();
        refinedSeparator.append("\\");
        refinedSeparator.append(separator);
        return refinedSeparator.toString();
    }
}