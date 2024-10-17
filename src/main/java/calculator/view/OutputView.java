package calculator.view;

import calculator.Numbers;

public class OutputView {

    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(Numbers numbers) {
        Double sum = numbers.getSum();
        if(sum%1 == 0) {
            String result = String.format("%.0f", sum);
            System.out.println("결과 : " + result);
        }
        if(sum%1 != 0) System.out.println("결과 : " + sum);
    }
}
