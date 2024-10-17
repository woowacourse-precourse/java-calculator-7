package calculator;

public class Application {
    public static void main(String[] args) {

        String input = InputOutputManager.inputMessage();
        String delimiters = CostomDelimiter.parseDelimiters(input);
        String parseString = PasingString.pasingString(input, delimiters);

        Calculator calculator = new Calculator();
        InputOutputManager.outputMessage(calculator.add(delimiters, parseString));
    }
}