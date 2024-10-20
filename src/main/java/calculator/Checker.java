package calculator;

public class Checker {
    private StringData stringData;

    public Checker(StringData stringData) {
        this.stringData = stringData;
    }

    public boolean checkIsNotString() {
        String inputString = stringData.getInputString();
        boolean isNotString = false;

        if (inputString.equals("\0")) {
            isNotString = true;
        }
        if (inputString.isEmpty()) {
            isNotString = true;
        }
        return isNotString;
    }

    public boolean checkIsSingleNumber() {
        String inputString = stringData.getInputString();
        boolean isSingleNumber = true;

        try {
            Double number = Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            isSingleNumber = false;
        }
        return isSingleNumber;
    }

    public String checkCustomSeparator() throws IllegalArgumentException {
        String inputString = stringData.getInputString();
        String customSeparator = null;

        if (inputString.length() < 5) {
            return customSeparator;
        }

        String customPatternStart = inputString.substring(0, 2);
        boolean hasCustomPatternStart = customPatternStart.equals("//");

        if (!hasCustomPatternStart) {
            return customSeparator;
        }

        String customPatternEnd = inputString.substring(3, 5);
        boolean hasCustomPatternEnd = customPatternEnd.equals("\\n");

        if (!hasCustomPatternEnd) {
            throw new IllegalArgumentException();
        }

        char customCharacter = inputString.charAt(2);

        if (Character.isDigit(customCharacter)) {
            throw new IllegalArgumentException();
        }

        customSeparator = Character.toString(customCharacter);
        return customSeparator;
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

        String defaultSeparator = "[:,]";
        return defaultSeparator;
    }
}