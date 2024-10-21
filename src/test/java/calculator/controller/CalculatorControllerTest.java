package calculator.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {

    private CalculatorController calculatorController;
    private StubCalculatorView stubView;

    @BeforeEach
    void setUp() {
        // 실제 서비스와 Stub View 사용
        CalculatorService calculatorService = new CalculatorService();
        stubView = new StubCalculatorView(); // Stub View 사용

        // 실제 서비스와 Stub View를 사용하여 Controller 생성
        calculatorController = new CalculatorController(calculatorService, stubView);
    }

    @Test
    void 빈_문자열_입력_테스트() {
        //given: 빈 문자열 입력
        stubView.setInput("");

        //when: 입력 처리
        int result = calculatorController.run();

        //then: 결과는 0
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_입력_테스트() {
        //given: 숫자 3 입력
        stubView.setInput("3");

        //when: 입력 처리
        int result = calculatorController.run();

        //then: 결과는 3
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_콜론_구분자_테스트() {
        //given: "3:3,2"
        stubView.setInput("3:3,2");

        //when: 입력 처리
        int result = calculatorController.run();

        //then: 결과는 8
        assertThat(result).isEqualTo(8);
    }

    @Test
    void 커스텀_구분자_테스트() {
        //given: "//;\n1;2;3"
        stubView.setInput("//;\\n1;2;3");

        //when: 입력 처리
        int result = calculatorController.run();

        //then: 결과는 6
        assertThat(result).isEqualTo(6);
    }

    class StubCalculatorView extends CalculatorView {
        private String input;

        // 입력값을 미리 설정할 수 있는 메서드
        public void setInput(String input) {
            this.input = input;
        }

        //콘솔 입력 피하기 위하여 override
        @Override
        public String getInput() {
            return input;
        }
    }
}
