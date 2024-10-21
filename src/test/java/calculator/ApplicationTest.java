package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CalculationModel;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    private void runException(String input) {
        CalculationModel model = new CalculationModel();
        OutputView outputView = new OutputView();
        outputView.printInput();
        model.parseInput(input);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}