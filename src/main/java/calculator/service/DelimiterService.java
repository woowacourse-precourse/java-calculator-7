package calculator.service;

import calculator.model.Delimiter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DelimiterService {

    private List<Delimiter> delimiters = new ArrayList<>();
    private final Pattern customDelimiterPattern = Pattern.compile("^//.\\n.*");

    public void addDelimiter(String delimiter) {
        delimiters.add(new Delimiter(delimiter));
    }

    public void addDelimiters(List<String> delimiters) {
        delimiters.forEach(this::addDelimiter);
    }
    public boolean validateCustomDelimiterFormat(String string) {
        return customDelimiterPattern.matcher(string).matches();
    }
}
