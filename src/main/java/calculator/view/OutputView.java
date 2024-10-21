package calculator.view;

import calculator.model.vo.Number;

public class OutputView {
    public void printResult(Number number) {
        System.out.println("결과 : " + number);
    }

    public void printStart() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
