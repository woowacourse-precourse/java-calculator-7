package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorIO calculatorIO = new CalculatorIO();

        calculatorIO.getUserInput();
        checkIsInputEmpty(calculator);

        int escapeIdx = calculatorIO.userInput.indexOf("\\n");
        if (escapeIdx > 0) {
            splitWithCustomSeparator(calculator, escapeIdx);
        } else {
            splitWithDefaultSeparator(calculator);
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

    static void splitWithDefaultSeparator(Calculator calculator) {
        String delimiter = "[,:]";
        String[] splitInput = calculator.userInput.split(delimiter);
        calculator.processedInput.addAll(Arrays.asList(splitInput));
    }

    static void splitWithCustomSeparator(Calculator calculator, Integer escapeIdx) {
        String separator = calculator.userInput.substring(0, escapeIdx);

        if (separator.startsWith("//")) {
            separator = separator.replace("//", "");
        }

        String leftInput = calculator.userInput.substring(escapeIdx + 2);
        String[] splitInput = leftInput.split(separator);
        calculator.processedInput.addAll(Arrays.asList(splitInput));
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
