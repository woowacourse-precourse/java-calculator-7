package calculator;

public class Cleaner {
    private StringData stringData;

    public Cleaner(StringData stringData) {
        this.stringData = stringData;
    }

    public String refineString() {
        String inputString = stringData.getInputString();
        boolean hasNumberString = true;

        if (inputString.length() == 5) {
            hasNumberString = false;
            inputString = "";
        }
        if (hasNumberString) {
            inputString = inputString.substring(5);
        }
        return inputString;
    }

    public String refineSeparator() {
        String separator = stringData.getSeparator();
        String specialRegexes = ".^$*+?()[]{}|\\";
        boolean isSpecialRegexSeparator = specialRegexes.contains(separator);

        if (isSpecialRegexSeparator) {
            StringBuilder refinedSeparator = new StringBuilder();
            
            refinedSeparator.append("\\");
            refinedSeparator.append(separator);

            separator = refinedSeparator.toString();
        }
        return separator;
    }
}