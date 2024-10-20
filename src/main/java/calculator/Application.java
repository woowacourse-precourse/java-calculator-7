package calculator;

public class Application {
    public static void main(String[] args) {
        InputOutputManager printManager = new InputOutputManager();

        String input = printManager.inputMessage();

        String delimiters = CustomDelimiter.parseDelimiters(input);
        String parseString = ParsingString.parsingString(input, delimiters);

        Calculator calculator = new Calculator();
        printManager.outputMessage(calculator.add(parseString, delimiters));
    }
}
