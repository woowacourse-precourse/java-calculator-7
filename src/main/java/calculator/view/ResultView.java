package calculator.view;

import java.math.BigDecimal;

public class ResultView {
    public void printResult(BigDecimal sumResult) {
        System.out.println("결과 : " + sumResult.toPlainString());
    }
}
