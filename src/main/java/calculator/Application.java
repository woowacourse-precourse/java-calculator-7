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
        splitWithDefaultSeparator(calculator);

        int total = 0;

        else {
            int escapeIdx = input.indexOf("\\n");
            if(escapeIdx > 0) {
                String delimiter = input.substring(0, escapeIdx);
                if(delimiter.startsWith("//")){
                    delimiter = delimiter.replace("//", "");
                }
                String leftInput = input.substring(escapeIdx + 2);
                String[] splitInput = leftInput.split(delimiter);
                processedInput.addAll(Arrays.asList(splitInput));
            }
        }

        for (String number : processedInput) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException();
            }
        }

        for (String number : processedInput) {
            if (Character.isDigit(Integer.parseInt(number))) {
                throw new IllegalArgumentException();
            }
        }

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
}
