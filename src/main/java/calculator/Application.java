package calculator;
public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String input = calculator.input();
        String basicProcess = calculator.replaceBasicSeparators(input);
        String customProcess = (calculator.replaceCustomSeparate(basicProcess));

        calculator.validationCheck(customProcess);
        calculator.calculationResult(customProcess);
    }
}
