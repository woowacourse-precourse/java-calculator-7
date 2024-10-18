package calculator.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    private static String DELIMITERS = "[,;]";
    private static String DELIMITER_COMMAS = ",";
    private static String DELIMITERS_SEMIKOLON = ";";
    private static String CUSTOM_START = "//";
    private static String CUSTOM_END = "\n";

    public String getUserInput() {
        return readLine();
    }

    public String[] convertInputListBy(String userInput) {

        if (userInput == null || userInput.isEmpty()) {
            return new String[]{"0"};
        }

        if (checkInputIsCustom(userInput)) {

        } else {
            return convertValidInputList(userInput);
        }

        return null;
    }

    public boolean checkInputIsCustom(String userInput) {
        if (userInput.startsWith(CUSTOM_START)
                && userInput.indexOf(CUSTOM_END, 1, 4) != -1) {
            return true;
        }

        return false;
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
            throw new IllegalArgumentException("잘못된 입력입니다.");
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
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }
    }

    public boolean isPositiveInteger(String s) {
        try {

            int number = Integer.parseInt(s);

            if (number < 1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            return true;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
