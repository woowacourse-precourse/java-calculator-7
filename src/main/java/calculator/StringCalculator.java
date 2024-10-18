package calculator;

import static calculator.CustomPartManager.validateCustomPart;
import static calculator.StringPartManager.initString;
import static calculator.StringPartManager.validateString;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String separators;
    boolean hasCustomSeparator;

    void run() {
        printInputMsg();
        String input = Console.readLine();

        if (validateCustomPart(input)) {
            hasCustomSeparator = true;
        }
        separators = initSeparator(input, hasCustomSeparator);

        String str = initString(input, hasCustomSeparator);
        validateString(str, separators);

        String[] separatedNumbers = str.split('[' + separators + ']');
        int sumValue = calculateSumValue(separatedNumbers);
        printOutputMsg(sumValue);
    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    void printOutputMsg(int sumValue) {
        System.out.println("결과 : " + sumValue);
    }

    int calculateSumValue(String[] separatedNumbers) {
        int sumValue = 0;
        for (String number : separatedNumbers) {
            if (!number.isEmpty()) {
                sumValue += Integer.parseInt(number);
            }
        }
        return sumValue;
    }

    String initSeparator(String input, boolean hasCustomSeparator) {
        String basicSeparators = ",:";
        if (hasCustomSeparator) {
            char customSeparator = input.charAt(2);
            return basicSeparators + customSeparator;
        }
        return basicSeparators;
    }
}
