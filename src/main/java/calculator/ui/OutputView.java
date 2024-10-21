package calculator.ui;

import calculator.domain.Number;

public class OutputView {

    public void printAddMessage() {
        System.out.println("덧샘할 문자열을 입력해 주세요.");
    }

    public void printResult(Number number) {
        System.out.println("결과 : " + number.value());
    }
}
