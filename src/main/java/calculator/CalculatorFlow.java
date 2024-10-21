package calculator;

public class CalculatorFlow {
    public void start() {
        UserInput.showInputPrompt();
        String inputValue = UserInput.receiveInput();

        int[] extractedNumbers = NumberExtractor.extractNumbers(inputValue);
    }
}
