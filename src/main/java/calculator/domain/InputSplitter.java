package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private static final String REGEX = "^//(.)\\\\n";
    private static final int CUSTOM_DELIMETER_START_INDEX = 2;
    private static final int CUSTOM_DELIMETER_END_INDEX = 3;
    private static final int START_INDEX_EXCEPT_REGEX = 5;

    public String[] splitByDelimeter(String input) {
        if (input.isEmpty()) {
            return new String[]{"0"};
        }
        if (containsCustomDelimeter(input)) {
            String customDelimeter = getCustomDelimeter(input);
            input = input.substring(START_INDEX_EXCEPT_REGEX);
            return input.split(customDelimeter);
        }
        return validateCommaAndColonDelimiter(input);
    }

    private boolean containsCustomDelimeter(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private String getCustomDelimeter(String input) {
        return input.substring(CUSTOM_DELIMETER_START_INDEX, CUSTOM_DELIMETER_END_INDEX);
    }

    private String[] validateCommaAndColonDelimiter(String input) {
        if (!input.matches("^[0-9]+([,:][0-9]+)*$")) {
            throw new IllegalArgumentException("쉼표(,) 또는 콜론(:) 외의 다른 구분자는 사용할 수 없으며, 숫자 사이에만 올 수 있습니다.");
        }
        return input.split("[,:]");
    }
}
