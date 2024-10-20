package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.*?)\\\\n(.*)";
    private String input;
    private List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public Calculator(String input) {
        this.input = input != null ? input : "";
    }

    public void addCustomDelimiter() {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            input = matcher.group(2);

            delimiters.add(Pattern.quote(customDelimiter));
        }
    }

}