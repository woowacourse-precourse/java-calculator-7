package calculator;

public class Checker {
    private StringData stringData;

    public Checker(StringData stringData) {
        this.stringData = stringData;
    }

    public boolean checkIsNotString() {
        String inputString = stringData.getInputString();
        if (inputString.equals("\0")) {
            return true;
        }
        if (inputString.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean checkIsSingleNumber() {
        String inputString = stringData.getInputString();
        try {
            Double number = Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public String checkCustomSeparator() throws IllegalArgumentException {
        String inputString = stringData.getInputString();
        if (inputString.length() < 5) {
            return null;
        }
        String customPattern = inputString.substring(0, 2);
        boolean hasCustomPatternStart = customPattern.equals("//");
        if (!hasCustomPatternStart) {
            return null;
        }

        customPattern = inputString.substring(3, 5);
        boolean hasCustomPatternEnd = customPattern.equals("\\n");
        if (hasCustomPatternStart && !hasCustomPatternEnd) {
            throw new IllegalArgumentException();
        }
        char customSeparator = inputString.charAt(2);
        if (Character.isDigit(customSeparator)) {
            throw new IllegalArgumentException();
        }
        return Character.toString(customSeparator);
    }

    public String checkDefaultSeparator() throws IllegalArgumentException {
        String inputString = stringData.getInputString();
        if (inputString.contains("-")) {
            throw new IllegalArgumentException();
        }
        boolean colon = inputString.contains(":");
        boolean comma = inputString.contains(",");
        if (!colon && !comma) {
            throw new IllegalArgumentException();
        }
        return "[:,]";
    }
}