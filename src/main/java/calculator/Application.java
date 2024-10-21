package calculator;

import calculator.controller.ApplicationController;
import calculator.dto.CalculatorResultDTO;
import calculator.dto.ExpressionDTO;
import calculator.view.StringCalculatorView;
import java.math.BigDecimal;

public class Application {

    private static final StringCalculatorView view = new StringCalculatorView();

    private static BigDecimal totalSum = BigDecimal.ZERO;

    public static void main(String[] args) {
        CalculatorResultDTO<BigDecimal> currentSum;
        do {
            String input;
            try {
                input = view.displayInput();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                return;
            }
            // 현재 입력된 문자열 한 줄에 대한 덧셈 연산 후 결과 출력
            currentSum = ApplicationController.run(new ExpressionDTO(input), view);
            totalSum = totalSum.add(currentSum.get());  // 덧셈 결과 누적
        } while (!currentSum.get().equals(BigDecimal.ZERO));    // 빈 문자열 입력 시 종료

        // 누적합 출력
        view.displayOutput(new CalculatorResultDTO<>(totalSum));
    }
}