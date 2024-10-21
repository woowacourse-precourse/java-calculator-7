package calculator;

public class Application {
    public static void main(String[] args) {
        InputPrinter inputPrinter = new InputPrinter();
        inputPrinter.printInputMessage();
        String input = inputPrinter.input();

        StringParser stringParser = new StringParser();
        String[] strings = stringParser.parseString(input);

        Calculator calculator = new Calculator();
        int result = calculator.calculate(strings);

        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.print(result);
    }
}
