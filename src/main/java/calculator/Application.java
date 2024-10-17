package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.guideComment();

        InputHandler inputHandler = new InputHandler();
        String userInput = inputHandler.getUserInput();

        ExceptionHandler exceptionHandler = new ExceptionHandler(userInput);
        // 빈 문자열이면 0을 출력 후 종료
        if (!exceptionHandler.validateInput()) {
            outputHandler.printSum(0);
            return;
        }
        Calculator cal = new Calculator(userInput);

        //exceptionHandler.validateCommonInput();
        String delimiter = cal.extractDelimiter();

        String[] numbers = cal.extractNumbers(delimiter);

        int sum = cal.sumStringArray(numbers);

        outputHandler.printExtractedValues(delimiter, numbers);

        outputHandler.printSum(sum);

    }
}
