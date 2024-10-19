package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorInputHandler calculatorInputHandler = new CalculatorInputHandler();
        CalculatorOutputHandler calculatorOutputHandler = new CalculatorOutputHandler();

        String input = calculatorInputHandler.input();
        Parser parser = new DefaultParser(input);
        Alu AddUnit = new AddUnit(parser.parse());
        Calculator calculator = new Calculator(AddUnit);
        calculatorOutputHandler.output(calculator.calculate());
    }
}
