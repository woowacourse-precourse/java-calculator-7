package calculator.numbercalculator;

import calculator.numbercalculator.delimiter.Delimiter;
import calculator.numbercalculator.delimiter.Delimiters;
import java.util.List;

public class DelimiterProcessor {
    private final CustomDelimiterProcessor customDelimiterProcessor = new CustomDelimiterProcessor();

    public List<String> process(String str) {
        Delimiters delimiters = new Delimiters();

        if (customDelimiterProcessor.matches(str)) {
            Delimiter customDelimiter = customDelimiterProcessor.extract(str);
            delimiters.add(customDelimiter);
            str = customDelimiterProcessor.removeCustomDelimiter(str);
        }

        return delimiters.split(str);
    }
}
