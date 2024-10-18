package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorIO calculatorIO = new CalculatorIO();
        SplitStringWithSeparator splitStringWithSeparator = new SplitStringWithSeparator();
        DataVerification dataVerification = new DataVerification();

        calculatorIO.getUserInput();
        dataVerification.checkIsInputEmpty(calculatorIO);

        int escapeIdx = calculatorIO.userInput.indexOf("\\n");
        if (escapeIdx > 0) {
            splitStringWithSeparator.splitWithCustomSeparator(calculatorIO, escapeIdx);
        } else {
            splitStringWithSeparator.splitWithDefaultSeparator(calculatorIO);
        }

        dataVerification.checkIsPositiveNumber(splitStringWithSeparator);
        dataVerification.checkHasNumberFormat(splitStringWithSeparator);

        calculator.getTotal(splitStringWithSeparator);
        calculatorIO.printResult(calculator);
    }
}
