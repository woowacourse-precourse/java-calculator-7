package calculator;

import calculator.domain.Calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        getUserInput(calculator);
        checkIsInputEmpty(calculator);

        int escapeIdx = calculator.userInput.indexOf("\\n");
        if (escapeIdx > 0) {
            splitWithCustomSeparator(calculator, escapeIdx);
        } else {
            splitWithDefaultSeparator(calculator);
        }

        checkIsPositiveNumber(calculator);
        checkHasNumberFormat(calculator);

        int total = 0;


        for (String number : processedInput) {
            total += Integer.parseInt(number);
        }

        System.out.println("결과 : " + total);
    }

    static void getUserInput(Calculator calculator) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        calculator.userInput = Console.readLine();
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
}
