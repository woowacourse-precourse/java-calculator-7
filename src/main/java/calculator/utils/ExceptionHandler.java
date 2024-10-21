package calculator.utils;

import calculator.enums.ExceptionMessages;
import java.util.List;

public class ExceptionHandler {
    private static final char PRE_CUSTOM_DELIM_SLASH = '/';
    private static final char POST_CUSTOM_DELIM_BACKSLASH = '\\';
    private static final char POST_CUSTOM_DELIM_N = 'n';
    private static final char BASIC_DELIM_COMMA = ',';
    private static final char BASIC_DELIM_COLON = ':';
    private static final char HYPHEN = '-';

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
        if (elem != PRE_CUSTOM_DELIM_SLASH && elem != POST_CUSTOM_DELIM_N && elem != POST_CUSTOM_DELIM_BACKSLASH) {
            throw new IllegalArgumentException(ExceptionMessages.INCORRECT_INPUT_MSG.getMsg());
        }
    }

    public void checkIncorrectInputWithoutCustomDelim(char[] elems) {
        for (char elem : elems) {
            if (elem != BASIC_DELIM_COMMA && elem != BASIC_DELIM_COLON && elem != HYPHEN && !Character.isDigit(elem)) {
                throw new IllegalArgumentException(ExceptionMessages.INCORRECT_INPUT_MSG.getMsg());
            }
        }
    }

    public void checkIncorrectInputWithCustomDelim(char[] elems, char customDelim) {
        for (char elem : elems) {
            if (elem != BASIC_DELIM_COMMA && elem != BASIC_DELIM_COLON && elem != customDelim && elem != HYPHEN && !Character.isDigit(elem)) {
                throw new IllegalArgumentException(ExceptionMessages.INCORRECT_INPUT_MSG.getMsg());
            }
        }
    }

    public void checkIncorrectDelim(char delim) {
        if (delim == BASIC_DELIM_COMMA || delim == BASIC_DELIM_COLON) {
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
