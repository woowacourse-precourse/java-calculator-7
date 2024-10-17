package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorParamDomain {

    private List<Character> delimiters;
    private List<String> stringNumbers;
    private List<Integer> numbers;

    protected CalculatorParamDomain() {
        this.delimiters = List.of(',', ':');
        this.numbers = new ArrayList<>();
        this.stringNumbers = new ArrayList<>();
    }

    public static CalculatorParamDomain of() {
        return new CalculatorParamDomain();
    }

    public void changeUserDelimiters(List<Character> delimiters) {
        this.delimiters = delimiters;
    }

    public void splitStringNumbers(List<String> stringNumbers) {
        this.stringNumbers = stringNumbers;
    }

    public void parseUserNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<String> getStringNumbers() {
        return this.stringNumbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Character> getDelimiters() {
        return this.delimiters;
    }

    public Long getSumNumbers() {
        return this.numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();
    }
}
