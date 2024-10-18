package calculator;

import java.math.BigDecimal;

public class Output {

    public Output() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void output(BigDecimal result) {
        System.out.println("결과 : " + result);
    }

}
