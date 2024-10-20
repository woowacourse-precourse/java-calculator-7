package calculator;

import java.util.List;

public class ExceptionHandler {
    private static ExceptionHandler instance;

    private ExceptionHandler() {
    }

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public void checkIncorrectCustomDelimGenerateInput(char elem) {
        if (elem != '/' && elem != 'n' && elem != '\\') {
            throw new IllegalArgumentException(ExceptionMessages.INCORRECT_INPUT_MSG.getMsg());
        }
    }

    public void checkIncorrectInputWithoutCustomDelim(char[] elems) {
        for (char elem : elems) {
            if (elem != ',' && elem != ':' && elem != '-' && !Character.isDigit(elem)) {
                throw new IllegalArgumentException(ExceptionMessages.INCORRECT_INPUT_MSG.getMsg());
            }
        }
    }

    public void checkIncorrectInputWithCustomDelim(char[] elems, char customDelim) {
        for (char elem : elems) {
            if (elem != ',' && elem != ':' && elem != customDelim && elem != '-' && !Character.isDigit(elem)) {
                throw new IllegalArgumentException(ExceptionMessages.INCORRECT_INPUT_MSG.getMsg());
            }
        }
    }

    public void checkIncorrectDelim(char delim) {
        if (delim == ',' || delim == ':') {
            throw new IllegalArgumentException(ExceptionMessages.INCORRECT_CUSTOM_DELIM_MSG.getMsg());
        }
    }

    public void checkZeroAndNegativeDigit(List<Integer> nums) {
        for (int num : nums) {
            if (num <= 0) {
                throw new IllegalArgumentException(ExceptionMessages.ZERO_AND_NEGATIVE_MSG.getMsg());
            }
        }
    }
}
