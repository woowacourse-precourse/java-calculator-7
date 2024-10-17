package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String BLANK = "";
    private static final String COMMA = ",";
    private static final String COLON = ":";

    private static List<String> separators = Arrays.asList(COMMA, COLON);


    public boolean isBlank(String input) {
        return input.equals(BLANK);
    }

    public boolean isSeparator(String potentialSeparator) {
        return separators.contains(potentialSeparator);
    }
}
