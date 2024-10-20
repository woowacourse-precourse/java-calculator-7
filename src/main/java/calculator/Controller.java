package calculator;

public class Controller {
    CalculatorManager calculatorManager = new CalculatorManager();
    InputHandler inputHandler = new InputHandler();
    DelimiterParser delimiterParser = new DelimiterParser();
    CheckCompatibility checkCompatibility = new CheckCompatibility();
    OutputHandler outputHandler = new OutputHandler();
    Calculator calculator = new Calculator();

    public void startProcess(){
        calculatorManager.makeUserInput(inputHandler);
        calculatorManager.makeDelimiter(delimiterParser);
        calculatorManager.checkCompatibility(checkCompatibility);
        calculatorManager.calculateSum(calculator);
        calculatorManager.printAnswer(outputHandler);
    }
}
