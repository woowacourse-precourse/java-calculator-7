package calculator.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorViewTest {
    @Test
    void 결과_출력_테스트() {
        //given: 값 입력
        CalculatorView calculatorView = new CalculatorView();

        //when: 출력 처리
        String output = calculatorView.displayOutput(10);

        //then: "결과 : 10" 출력
        assertThat(output).isEqualTo("결과 : 10");
    }
}
