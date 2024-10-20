package calculator.domain;

public class Calculator {

    public int calculate(final Numbers numbers) {
        return numbers.getNumbers().stream().mapToInt(number -> number).sum();
    }

}
