package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    void run() {
        printInputMsg();
        String input = Console.readLine();

        Data data = InputManager.validateInput(input);
        String str = data.getStr();
        String separators = data.getSeparators();

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
}
