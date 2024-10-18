package calculator.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    private static String DELIMITERS = "[,;]";
    private static String DELIMITER_COMMAS = ",";
    private static String DELIMITERS_SEMIKOLON = ";";
    private static String CUSTOM_START = "//";
    private static String CUSTOM_END = "\\n";

    public String getUserInput() {
        return readLine();
    }

    public String[] convertInputListBy(String userInput) {

        if (userInput == null || userInput.isEmpty()) {
            return new String[]{"0"};
        }

        if (checkInputIsCustom(userInput)) {
            return convertValidInputListCustom(userInput);
        } else {
            return convertValidInputList(userInput);
        }
    }

    public boolean checkInputIsCustom(String userInput) {
        if (userInput.startsWith(CUSTOM_START)
                && (userInput.indexOf(CUSTOM_END, 3) != -1)) {
            return true;
        }

        return false;
    }

    public String[] convertValidInputListCustom(String userInput) {
        String delimiter = userInput.substring(CUSTOM_START.length(), CUSTOM_START.length() + 1);
        String extractInputs = userInput.substring(CUSTOM_START.length() + CUSTOM_END.length() + 2);

        lastIndexIsInteger(extractInputs);

        checkDelimiterDuplicateCustom(extractInputs, delimiter);

        String[] separatorInput = extractInputs.split(delimiter);
        for (String s : separatorInput) {
            isPositiveInteger(s);
        }

        return separatorInput;
    }

    public String[] convertValidInputList(String userInput) {
        lastIndexIsInteger(userInput);

        checkDelimiterDuplicate(userInput);

        String[] separatorInput = userInput.split(DELIMITERS);
        for (String s : separatorInput) {
            isPositiveInteger(s);
        }

        return separatorInput;
    }

    public void lastIndexIsInteger(String userInput) {
        try {
            String lastIndex = String.valueOf(userInput.charAt(userInput.length() - 1));
            Integer.parseInt(lastIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public void checkDelimiterDuplicateCustom(String extractInput, String delimiter) {
        for (int i = 0; i < extractInput.length(); i++) {
            if (delimiter.equals(String.valueOf(extractInput.charAt(i)))
            ) {
                if (
                        (i + 1 < extractInput.length())
                                && (delimiter.equals(String.valueOf(extractInput.charAt(i + 1))))
                ) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void checkDelimiterDuplicate(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (DELIMITER_COMMAS.equals(String.valueOf(userInput.charAt(i)))
                    || DELIMITERS_SEMIKOLON.equals(String.valueOf(userInput.charAt(i)))
            ) {
                if (
                        (i + 1 < userInput.length())
                                && (DELIMITER_COMMAS.equals(String.valueOf(userInput.charAt(i + 1)))
                                || DELIMITERS_SEMIKOLON.equals(String.valueOf(userInput.charAt(i + 1))))
                ) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public boolean isPositiveInteger(String s) {
        try {

            int number = Integer.parseInt(s);

            if (number < 1) {
                throw new IllegalArgumentException();
            }

            return true;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
