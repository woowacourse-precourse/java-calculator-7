package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
    private static final String REGEX = "^//(.)\\n";
    private static final int CUSTOM_DELIMETER_START_INDEX = 2;
    private static final int CUSTOM_DELIMETER_END_INDEX = 3;
    private static final int START_INDEX_EXCEPT_REGEX = 4;

    public String[] splitByDelimeter(String input) {
        if (containsCustomDelimeter(input)) {
            String customDelimeter = getCustomDelimeter(input);
            input = input.substring(START_INDEX_EXCEPT_REGEX);
            return input.split(customDelimeter);
        }
        return input.split("[,:]");
    }

    private boolean containsCustomDelimeter(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private String getCustomDelimeter(String input) {
        return input.substring(CUSTOM_DELIMETER_START_INDEX, CUSTOM_DELIMETER_END_INDEX);
    }
}
