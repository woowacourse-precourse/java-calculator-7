package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = CalStart.inputMessage();
        String delimiter = InputValidate.checkCustom(userInput);
        String[] totalSum = StringParsing.stringParsingCheck(userInput, delimiter);
        int sum = Calculator.calculateTotal(totalSum);
        CalFinish.print(sum);
    }
}