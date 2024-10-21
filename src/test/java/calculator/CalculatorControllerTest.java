package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;
import org.junit.jupiter.api.Test;

public class CalculatorControllerTest {

    static class TestInputView extends InputView {
        private final String input;

        public TestInputView(String input) {
            this.input = input;
        }

        @Override
        public String readExpression() {
            return input;
        }
    }

    static class TestOutputView extends OutputView {
        private int result;

        @Override
        public void printResult(int result) {
            this.result = result;
            System.out.println("결과 : " + result);  // 실제 출력 대신 결과 저장
        }

        public int getResult() {
            return result;
        }
    }

    @Test
    void shouldPrintCorrectSum() {
        InputView inputView = new TestInputView("1,2,3");
        TestOutputView outputView = new TestOutputView();
        CalculatorController controller = new CalculatorController(inputView, outputView);

        controller.run();
        assertEquals(6, outputView.getResult(), "1,2,3의 합은 6이어야 합니다.");
    }

    @Test
    void shouldHandleInvalidInputGracefully() {
        InputView inputView = new TestInputView("1,a,3");
        TestOutputView outputView = new TestOutputView();
        CalculatorController controller = new CalculatorController(inputView, outputView);

        assertThrows(IllegalArgumentException.class, controller::run);
    }
}
