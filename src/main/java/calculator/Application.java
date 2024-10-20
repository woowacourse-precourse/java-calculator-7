package calculator;

public class Application {
    public static void main(String[] args) {
        InputOutputManager printManager = new InputOutputManager();

        String input = printManager.inputMessage();
        System.out.println("input = " + input);
        String delimiters = CustomDelimiter.parseDelimiters(input);
        String parseString = ParsingString.parsingString(input, delimiters);

        System.out.println("delimiters = " + delimiters);
        System.out.println("parseString = " + parseString);
        Calculator calculator = new Calculator();
        printManager.outputMessage(calculator.add(parseString, delimiters));
    }
}
