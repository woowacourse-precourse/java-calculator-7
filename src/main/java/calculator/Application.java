package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorIO calculatorIO = new CalculatorIO();
        SplitStringWithSeparator splitStringWithSeparator = new SplitStringWithSeparator();

        calculatorIO.getUserInput();
        checkIsInputEmpty(calculator);

        int escapeIdx = calculatorIO.userInput.indexOf("\\n");
        if (escapeIdx > 0) {
            splitStringWithSeparator.splitWithCustomSeparator(calculatorIO, escapeIdx);
        } else {
            splitStringWithSeparator.splitWithDefaultSeparator(calculatorIO);
        }

        checkIsPositiveNumber(calculator);
        checkHasNumberFormat(calculator);
        getTotal(calculator);
        calculatorIO.printResult(calculator);
    }

    static void checkIsInputEmpty(Calculator calculator) {
        if (calculator.userInput.isEmpty()) {
            System.out.println("결과 : " + 0);
        }
    }

    static void checkIsPositiveNumber(Calculator calculator) {
        for (String number : calculator.processedInput) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    static void checkHasNumberFormat(Calculator calculator) {
        for (String number : calculator.processedInput) {
            if (Character.isDigit(Integer.parseInt(number))) {
                throw new IllegalArgumentException();
            }
        }
    }

    static void getTotal(Calculator calculator) {
        for (String number : calculator.processedInput) {
            calculator.total += Integer.parseInt(number);
        }
    }
}
