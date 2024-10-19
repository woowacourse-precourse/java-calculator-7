package calculator;

public class Application {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.getInput();
        StringDivider stringDivider = createStringDivider(input);
        String[] dividedNum = stringDivider.divideStringBy();
        Calculator calculator = new Calculator();
        int result = calculator.sum(dividedNum);
        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printResult(result);
    }

    private static StringDivider createStringDivider(String input) {
        SeparatorParser separatorParser = new SeparatorParser(input);
        if (separatorParser.isCustomSeparatorExist()) {
            String customSeparator = separatorParser.getCustomSeparator();
            String mathExpression = separatorParser.getMathematicalExpression();
            return new StringDivider(customSeparator, mathExpression);
        }
        return new StringDivider(input);
    }

}
