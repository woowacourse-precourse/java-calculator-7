package calculator.domain;

import java.util.List;

public class Calculator {
    public Numbers calculate(String numbers) {
        Separator separator = new Separator(numbers);
        List<String> extractedNumbers = separator.getExtractedNumbers();
        return new Numbers(extractedNumbers);
    }
}
