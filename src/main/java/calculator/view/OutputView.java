package calculator.view;

import calculator.Numbers;

public class OutputView {

    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(Numbers numbers) {
        int sum = numbers.getSum();
        System.out.println("결과 : " + sum);
    }
}
