package calculator;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        StringDivider stringDivider = StringDividerFactory.createStringDivider(input);
        String[] dividedNum = stringDivider.divideStringBy();
        Calculator calculator = new Calculator();
        int result = calculator.sum(dividedNum);
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printResult(result);
    }
}
