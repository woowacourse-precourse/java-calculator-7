package calculator;
public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setUserInputByCustomConsole();
        calculator.checkInputByRule();
        calculator.getSumByCalculate();
        calculator.resultShowConsole();
    }
}
