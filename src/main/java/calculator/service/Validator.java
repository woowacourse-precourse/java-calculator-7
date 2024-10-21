package calculator.service;

import calculator.service.util.ManageDelimiters;
import calculator.view.Constant;

import java.util.List;

public class Validator {
    static ManageDelimiters manageDelimiters = new ManageDelimiters();

    private static boolean hasCustomDelimiter(String s) {
        return s.startsWith("//") && (s.contains("\\n"));
    }

    public static void validateCustomDelimiter(String s) {
        if (s.indexOf("\\n") == 2)
            throw new IllegalArgumentException(Constant.NOT_ENTERED_DELIMITER);
        if (s.indexOf("\\n") > 3)
            throw new IllegalArgumentException(Constant.NOT_ONE_DELIMITER);
        if (s.indexOf("\\n") == 3)
            manageDelimiters.addDelimiter(getCustomDelimiter(s));
    }

    private static String getCustomDelimiter(String s) {
        return String.valueOf(s.charAt(2));
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

    public void validateInput(String s) {
        if (hasCustomDelimiter(s)) {
            validateCustomDelimiter(s);
            s = s.substring(5);
        }
        validateDelimiter(s);
        validateNumbers(s);
    }

    public List<Integer> getConvertedInput(String s) {
        Converter converter = new Converter();
        if (hasCustomDelimiter(s)) {
            s = s.substring(5);
        }
        return converter.convertToNumbers(s, manageDelimiters.getDelimiters());
    }
}