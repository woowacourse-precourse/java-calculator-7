package calculator;

import calculator.controller.FunctionOperator;
import calculator.view.InputView;
import calculator.view.OutputView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    void testFullOperation_withCustomSeparator() {
        FunctionOperator operator = new FunctionOperator();
        operator.inputView = new InputView();
        operator.outputView = new OutputView();

        // 커스텀 구분자를 사용하는 경우
        operator.inputView = new InputView() {
            @Override
            public String input() {
                return "//;\\n1;2";
            }
        };

        // 예시 데이터 테스트
        String input = operator.inputView.input();
        assertEquals("//;\\n1;2", input);
        // 실제 동작 수행 및 결과 확인 필요 (다음 과정에서)
    }

    @Test
    void testFullOperation_withDefaultSeparators() {
        FunctionOperator operator = new FunctionOperator();
        operator.inputView = new InputView();
        operator.outputView = new OutputView();

        // 기본 구분자
        operator.inputView = new InputView() {
            @Override
            public String input() {
                return "1,2:3";
            }
        };

        String input = operator.inputView.input();
        assertEquals("1,2:3", input);
        // 실제 동작 수행 및 결과 확인 필요
    }
}
