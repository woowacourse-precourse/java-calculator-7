// Calculator.java
package calculator.model;

public class Calculator {
    private final DelimiterParser delimiterParser;
    private final InputValidator inputValidator;

    public Calculator() {
        this.delimiterParser = new DelimiterParser();
        this.inputValidator = new InputValidator();
    }

    public int add(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim()); // 각 숫자를 더함
        }
        return sum;
    }
}
