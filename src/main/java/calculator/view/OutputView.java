package calculator.view;

import java.math.BigDecimal;

public class OutputView {

    public void printResult(BigDecimal result) {
        System.out.println("결과 : " + result.stripTrailingZeros().toPlainString());
    }
}
