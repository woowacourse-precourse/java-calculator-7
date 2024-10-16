package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.guideComment();

        InputHandler inputHandler = new InputHandler();
        Calculator cal = new Calculator(inputHandler.getUserInput());

        String delimiter = cal.extractDelimiter();
        String[] numbers = cal.extractNumbers(delimiter);

        int sum = cal.sumStringArray(numbers);

        //outputHandler.printExtractedValues(delimiter, numbers);

        outputHandler.printSum(sum);

    }
}
