package calculator.view;

import calculator.model.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorViewTest {
    @Test
    void 결과_출력_테스트() {
        //given: 값 입력
        Calculator calculator = new Calculator();
        CalculatorView calculatorView = new CalculatorView();
        calculator.setSum(10);

        //when: 출력 처리
        String output = calculatorView.displayOutput(calculator);

        //then: "결과 : 10" 출력
        assertThat(output).isEqualTo("결과 : 10");
    }
}
