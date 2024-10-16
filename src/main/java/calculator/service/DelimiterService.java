package calculator.service;

import calculator.model.Delimiter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterService {

    private List<Delimiter> delimiters = new ArrayList<>();
    private final Pattern customDelimiterPattern = Pattern.compile("^//.\\n.*");
    private final Pattern defaultDelimiterPattern = Pattern.compile("[0-9:,]*]");

    public void addDelimiter(String delimiter) {
        delimiters.add(new Delimiter(delimiter));
    }

    public void addDelimiters(List<String> delimiters) {
        delimiters.forEach(this::addDelimiter);
    }
    public boolean validateCustomDelimiterFormat(String string) {
        return customDelimiterPattern.matcher(string).matches();
    }

    public boolean validateDefaultDelimiterFormat(String string) {
        return defaultDelimiterPattern.matcher(string).matches();
    }
}
