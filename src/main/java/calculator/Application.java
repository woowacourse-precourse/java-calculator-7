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

        getTotal(calculator);
        calculatorIO.printResult(calculator);
    }

    static void getTotal(Calculator calculator) {
        for (String number : calculator.processedInput) {
            calculator.total += Integer.parseInt(number);
        }
    }
}
