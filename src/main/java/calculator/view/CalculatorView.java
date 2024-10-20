package calculator.view;

import calculator.domain.Number;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String requestAddCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void responseResult(Number result) {
        System.out.printf("결과 : %d", result.getValue());
    }
}
