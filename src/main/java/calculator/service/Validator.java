package calculator.service;

import calculator.service.util.ManageDelimiters;
import calculator.view.Constant;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    static ManageDelimiters manageDelimiters = new ManageDelimiters();

    private static boolean hasCustomDelimiter(String s) {
        return s.startsWith(CUSTOM_DELIMITER_PREFIX) && (s.contains(CUSTOM_DELIMITER_SUFFIX));
    }

    private static String getCustomDelimiter(String s) {
        return String.valueOf(s.charAt(CUSTOM_DELIMITER_PREFIX.length()));
    }

    public List<Integer> getConvertedInput(String s) {
        Converter converter = new Converter();
        return converter.convertToNumbers(s, manageDelimiters.getDelimiters());
    }

    public static void validateCustomDelimiter(String s) {
        if (s.indexOf(CUSTOM_DELIMITER_SUFFIX) == 2)
            throw new IllegalArgumentException(Constant.NOT_ENTERED_DELIMITER);
        if (s.indexOf(CUSTOM_DELIMITER_SUFFIX) > 3)
            throw new IllegalArgumentException(Constant.NOT_ONE_DELIMITER);
        if (s.indexOf(CUSTOM_DELIMITER_SUFFIX) == 3)
            manageDelimiters.addDelimiter(getCustomDelimiter(s));
    }

    private static void validateDelimiter(String s) {
        String[] numbers = s.split(manageDelimiters.getDelimiters());
        for (String number : numbers) {
            if (!number.matches("^[0-9]*"))
                throw new IllegalArgumentException(Constant.NOT_ALLOWED_DELIMITER);
        }
    }

    private static void validateNumbers(String s) {
        String[] numbers = s.split(manageDelimiters.getDelimiters());
        for (String number : numbers) {
            if (Integer.parseInt(number) <= 0)
                throw new IllegalArgumentException(Constant.INCLUDE_ZERO);
        }
    }

    public String validateInput(String s) {
        if (hasCustomDelimiter(s)) {
            validateCustomDelimiter(s);
            s = s.substring(CUSTOM_DELIMITER_PREFIX.length() + CUSTOM_DELIMITER_SUFFIX.length() + 1);
        }
        validateDelimiter(s);
        validateNumbers(s);
        return s;
    }
}