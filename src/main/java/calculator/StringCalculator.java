package calculator;

import static calculator.CustomPartManager.validateCustomSeparator;
import static calculator.StringPartManager.validateString;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String separators = ",:";
    boolean hasCustomSeparator;

    void run() {
        printInputMsg();
        String input = Console.readLine();
        if (hasCustomPart(input)) {
            if (!validateCustomSeparator(input)) {
                throw new IllegalArgumentException("커스텀 구분자 에러");
            }
            addCustomSeparator(input.charAt(2));
        }

        String str = initString(input);
        validateString(str, separators);

        String[] separatedNumbers = str.split('[' + separators + ']');
        int sumValue = calculateSumValue(separatedNumbers);
        System.out.println("결과 : " + sumValue);
    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
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

    boolean hasCustomPart(String input) {
        if (input.startsWith("//")) {
            return input.contains("\\n");
        }
        return false;
    }

    void addCustomSeparator(char customSeparator) {
        hasCustomSeparator = true;
        separators += customSeparator;
    }

    String initString(String input) {
        String str = input;
        if (hasCustomSeparator) {
            int strStartIdx = input.indexOf("\\n") + 2;
            str = input.substring(strStartIdx);
        }
        return str;
    }
}
