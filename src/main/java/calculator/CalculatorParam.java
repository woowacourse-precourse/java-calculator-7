package calculator;

import java.util.List;

public class CalculatorParam {

    private List<Character> delimiters;
    private List<Integer> numbers;

    protected CalculatorParam() {
        this.delimiters = List.of(',', ':');
    }

    public static CalculatorParam of() {
        return new CalculatorParam();
    }

    public void changeDelimiters(List<Character> delimiters) {
        this.delimiters = delimiters;
    }

    public void changeNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Character> getDelimiters() {
        return this.delimiters;
    }
}
