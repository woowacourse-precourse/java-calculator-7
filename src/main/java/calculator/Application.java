package calculator;

public class Application {
    public static void main(String[] args) {
        CalculatorConsole calculatorConsole = new CalculatorConsole();
        String s = calculatorConsole.inputString();

        Calculator calculator = new Calculator();
        calculator.run(s);
    }
}
