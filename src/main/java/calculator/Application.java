package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorInputHandler calculatorInputHandler = new CalculatorInputHandler();
        CalculatorOutputHandler calculatorOutputHandler = new CalculatorOutputHandler();

        Parser parser = new DefaultParser(calculatorInputHandler.input());
        Alu addUnit = new AddUnit(parser.parse());
        Calculator calculator = new Calculator(addUnit);
        calculatorOutputHandler.output(calculator.excute());
    }
}
