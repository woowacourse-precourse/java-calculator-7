package calculator;

public class Application {
    public static void main(String[] args) {
        String input = InputOutputManager.inputMessage();

        String delimiters = CustomDelimiter.parseDelimiters(input);
        String parseString = ParsingString.parsingString(input, delimiters);

        Calculator calculator = new Calculator();
        int result = calculator.add(parseString, delimiters);

        InputOutputManager.outputMessage(result);
    }
}
