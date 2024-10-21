package calculator;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        Number number = new Number();
        Adder adder = new Adder();
        InputHandler inputHandler = new InputHandler();
        String inputStr = inputHandler.getInput();

        if (inputStr.isEmpty()) {
            return;
        }

        String processedString = separator.addCustomParser(inputStr);
        number.extractNumbers(processedString, separator.createDelimiterRegex());
        adder.sumNumbers(number.getExtractedNumbers());
    }
}
