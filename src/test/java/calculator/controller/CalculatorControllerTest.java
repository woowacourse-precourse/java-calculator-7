package calculator.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorControllerTest  {
    @Test
    void 빈_문자열_입력_테스트() {
        //given: 빈 문자열 입력
        String input = "";
        CalculatorController controller = new CalculatorController();

        //when: 입력 처리
        int result = controller.input(input);

        //then: 결과는 0
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_입력_테스트() {
        //given: 숫자 3 입력
        String input = "3";
        CalculatorController controller = new CalculatorController();

        //when: 입력 처리
        int result = controller.input(input);

        //then: 결과는 3
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_콜론_구분자_테스트() {
        //given: "3:3,2"
        String input = "3:3,2";
        CalculatorController controller = new CalculatorController();

        //when: 입력 처리
        int result = controller.input(input);

        //then: 결과는 8
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 커스텀_구분자_테스트() {
        //given: "//;\n1;2;3"
        String input = "//;\n1;2;3";
        CalculatorController controller = new CalculatorController();

        //when: 입력 처리
        int result = controller.input(input);

        //then: 결과는 6
        assertThat(result).isEqualTo(6);
    }
}
