package calculator.domain;

import java.util.*;

import static calculator.utils.MyStringUtils.buildRegexFromSet;

public class Calculator {
    private final List<Double> numbers;

    public Calculator(List<Double> numbers) {
        this.numbers = numbers;
    }

    public List<Double> getNumbers() {
        return numbers;
    }
}
