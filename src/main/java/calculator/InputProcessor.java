package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
    private static InputProcessor instance;

    private InputProcessor() {
    }

    public static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }

    ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();

    public void getInputFromUser() {
        String input = Console.readLine();
        String delimiters = ",:";
        char customDelim = '0';
        boolean customDelimFlag = isInputHasCustomDelim(input);

        if (customDelimFlag) {
            delimiters = delimiters.concat(getCustomDelim(input));
            input = input.substring(5);
            customDelim = delimiters.charAt(2);
        }

        validateIsInputIncorrect(input, customDelimFlag, customDelim);
    }

    private boolean isInputHasCustomDelim(String input) {
        if (input.charAt(0) == '/') {
            for (int i = 0; i < 2; i++) {
                exceptionHandler.checkIncorrectDelimGenerateInput(input.charAt(i));
            }
            for (int i = 3; i < 5; i++) {
                exceptionHandler.checkIncorrectDelimGenerateInput(input.charAt(i));
            }

            return true;
        }

        return false;
    }

    private String getCustomDelim(String input) {
        char delim = input.charAt(2);
        exceptionHandler.checkIncorrectDelim(delim);

        return String.valueOf(delim);
    }

    private void validateIsInputIncorrect(String input, boolean customDelimFlag, char customDelim) {
        if (customDelimFlag) {
            exceptionHandler.checkIncorrectInputWithCustomDelim(input.toCharArray(), customDelim);
            return;
        }

        exceptionHandler.checkIncorrectInputWithoutCustomDelim(input.toCharArray());
    }
}
