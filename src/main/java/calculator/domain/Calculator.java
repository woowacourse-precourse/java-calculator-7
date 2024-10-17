package calculator.domain;

import calculator.global.ui.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    InputView inputView = new InputView();

    public Calculator() {
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.println("결과 : " + sum(inputView.splitNumbers(Console.readLine())));
    }

    private int sum(String[] numbers) {

        int sum = 0;
        for (String number : numbers) {
            try {
                negativeNumberException(number);
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }

    private void negativeNumberException(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }
}
