package calculator.service;

import calculator.model.Delimiter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterService {

    public static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    public static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private List<Delimiter> delimiters = new ArrayList<>();
    private final Pattern customDelimiterPattern = Pattern.compile("^//.\\n.*");
    private final Pattern defaultDelimiterPattern = Pattern.compile("[0-9:,]*");

    public void addDelimiter(String delimiter) {
        delimiters.add(new Delimiter(delimiter));
    }

    public void addDelimiters(List<String> delimiters) {
        delimiters.forEach(this::addDelimiter);
    }

    public void addCustomDelimiter(String string) {
        if (validateCustomDelimiterFormat(string)) {
            addDelimiter(customDelimiterParser(string));
        }
        if (validateDefaultDelimiterFormat(string)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateCustomDelimiterFormat(String string) {
        return customDelimiterPattern.matcher(string).matches();
    }

    public boolean validateDefaultDelimiterFormat(String string) {
        return defaultDelimiterPattern.matcher(string).matches();
    }

    private String customDelimiterParser(String string) {
        return string.substring(CUSTOM_DELIMITER_BEGIN_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }
}
