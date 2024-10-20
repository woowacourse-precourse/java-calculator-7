package calculator;

public class CalculatorController {
    private final Calculator calculator = new Calculator();
    private final SeparatorHandler separatorHandler = new SeparatorHandler();


    public int processInput(String input) {
        String[] numbers = separatorHandler.getSeparatedNumbers(input);

        InputHandler.checkNumbersNull(numbers);

        return calculator.getTotal(numbers);
    }
}