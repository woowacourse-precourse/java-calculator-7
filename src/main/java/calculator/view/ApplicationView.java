package calculator.view;

import java.math.BigDecimal;

public class ApplicationView {

    public String requestInputMessage() {
        return "덧셈할 문자열을 입력해 주세요.";
    }

    public String responseInputMessage(BigDecimal result) {
        return "결과 : " + result.toString();
    }
}