package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputString {
    private static final String CUSTOM_DELIMITERS_START = "//";
    private static final String CUSTOM_DELIMITERS_END = "\\\\n";
    private final String input;

    public UserInputString(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public boolean isInputEmpty() {
        return input.isEmpty();
    }

    public List<String> parser(String delimiterRegex) {
        String numbers = "";
        if (delimiterRegex.equals(",|:")) {
            numbers = input;
        } else {
            String pattern = String.join("", CUSTOM_DELIMITERS_START, "(.)", CUSTOM_DELIMITERS_END, "(.*)");
            Matcher m = Pattern.compile(pattern).matcher(input);
            if (m.find()) {
                numbers = m.group(2);
            }

        }
        InputParser inputParser = new InputParser(delimiterRegex, numbers);
        return inputParser.parse();
    }
}
