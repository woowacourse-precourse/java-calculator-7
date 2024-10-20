package calculator.View;

import calculator.DTO.StringCalculatorDTO;

public class StringCalculatorView {
    // 결과를 출력하는 메서드
    public void displayResult(StringCalculatorDTO inputDTO) {
        // DTO에서 합계를 가져와 출력
        System.out.println("결과 : " + inputDTO.getSum());
    }
}
