package calculator.service;

import calculator.model.Delimiter;
import java.util.ArrayList;
import java.util.List;

public class DelimiterService {

    private List<Delimiter> delimiters = new ArrayList<>();

    public void addDelimiter(String delimiter) {
        delimiters.add(new Delimiter(delimiter));
    }
}
