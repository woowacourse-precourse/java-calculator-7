package calculator.domain;

import java.util.List;

public class Calculator {

    private List<String> separator;
    private List<Integer> numbers;

    public Calculator() {
        this.separator.add(",");
        this.separator.add(";");
    }

    public void addSeparator(String separator) {
        this.separator.add(separator);
    }

    public void addNumber(int number) {
        this.numbers.add(number);
    }
}
