package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorParam {

    private List<Character> delimiters;
    private List<String> stringNumbers;
    private List<Integer> numbers;

    protected CalculatorParam() {
        this.delimiters = List.of(',', ':');
        this.numbers = new ArrayList<>();
        this.stringNumbers = new ArrayList<>();
    }

    public static CalculatorParam of() {
        return new CalculatorParam();
    }

    public void changeDelimiters(List<Character> delimiters) {
        this.delimiters = delimiters;
    }

    public void splitStringNumbers(List<String> stringNumbers) {
        this.stringNumbers = stringNumbers;
    }

    public void changeNumbers(List<Integer> numbers) {
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
}
