package calculator.domain;

import java.util.List;

public class DelimiterAndNumber {

    private final List<String> delimiters;
    private final String numbers;

    public DelimiterAndNumber(List<String> delimiters, String numbers) {
        this.delimiters = delimiters;
        this.numbers = numbers;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String getNumbers() {
        return numbers;
    }

}
